package ru.sergeyrozhkov.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sergeyrozhkov.crud.model.User;
import ru.sergeyrozhkov.crud.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String hello(Model model) {
        System.out.println(userService.getAllUsers());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("title", "Add");
        model.addAttribute("user", new User());
        return "hello";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "hello";
    }

    @PostMapping("/user/{id}")
    public String addUser(@PathVariable String id, @ModelAttribute(value = "user") User user) {
            userService.save(user);
        return "redirect:/";
    }
}

