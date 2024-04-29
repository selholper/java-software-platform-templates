package com.example.practice23.controllers;

import ch.qos.logback.core.model.Model;
import com.example.practice23.models.User;
import com.example.practice23.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addText("User with email " + user.getEmail() + " already exists");
            return "/register";
        }
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(User user) {
        if (user.isActive()) {
            return "redirect:/home";
        }
        System.out.println("Aboba");
        return "redirect:/login";
    }
}
