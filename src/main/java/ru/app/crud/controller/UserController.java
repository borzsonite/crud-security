package ru.app.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.app.crud.model.User;
import ru.app.crud.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUsers(Model model) {
        User user = new User();
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("title", "Add");
        model.addAttribute("user", user);
        return "users";
    }

    @PostMapping("/user")
    public String addUser(@ModelAttribute(value = "user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users";
    }

    @GetMapping("/remove/{id}")
    public String removeUser(@PathVariable(value = "id") Long id) {
        User user = userService.getUserById(id);
        userService.remove(user);
        return "redirect:/";
    }
}

