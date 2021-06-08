package com.travel.agency.controller;

import com.travel.agency.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping({"/login", "/"})
    public String loginForm(Model model, @RequestParam(value = "error", required = false) String error) {
        boolean errorMessage = false;
        if (error != null) {
            errorMessage = true;
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }

    @GetMapping("/management")
    public String managementAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "management";
    }

    @GetMapping("/success")
    public String getSuccessfulMessage() {
        return "success";
    }
}
