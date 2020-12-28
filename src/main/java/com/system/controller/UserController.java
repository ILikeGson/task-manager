package com.system.controller;

import com.system.service.TaskService;
import com.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class UserController {

    private UserService userService;
    private TaskService taskService;

    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/users")
    private String getUsersPage(Model model, @RequestParam(defaultValue = "") String name) {
        model.addAttribute("users", userService.findByName("%"+name+"%"));
        return "users";
    }

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal) {
        model.addAttribute("tasks", taskService.findTasksByUser(userService.findByEmail(principal.getName())));
        return "profile";
    }


}
