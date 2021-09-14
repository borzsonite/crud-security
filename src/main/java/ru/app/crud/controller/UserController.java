package ru.app.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.app.crud.model.User;
import ru.app.crud.service.UserService;

import java.util.ArrayList;
import java.util.List;

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
        model.addAttribute("title", "Add user");
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
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("title", "Edit user");
        return "users";
    }

    @GetMapping("/remove/{id}")
    public String removeUser(@PathVariable(value = "id") Long id) {
        User user = userService.getUserById(id);
        userService.remove(user);
        return "redirect:/";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
}

