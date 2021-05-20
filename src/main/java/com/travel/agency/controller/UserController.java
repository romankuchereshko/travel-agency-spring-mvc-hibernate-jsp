package com.travel.agency.controller;

import com.travel.agency.model.User;
import com.travel.agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public String create() {
        return "create-user";
    }

    @PostMapping("/create")
    public String create(User user) {
        userService.createOrUpdate(user);
        return "redirect:/home";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable Long id, Model model) {
        model.addAttribute("users", Collections.singletonList(userService.read(id)));
        return "redirect:/management/{id}";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/management";
    }
}
