package com.travel.agency.controller;

import com.travel.agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @GetMapping("/management")
    public String managementAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "management";
    }

//    @GetMapping("management/{id}")
//    public String management(@PathVariable Long id, Model model) {
//        model.addAttribute("users", Collections.singletonList(userService.read(id)));
//        return "management";
//    }
}
