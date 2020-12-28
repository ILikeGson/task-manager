package com.system.controller;

import com.system.entity.Task;
import com.system.service.TaskService;
import com.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TaskController {
    private UserService userService;
    private TaskService taskService;

    public TaskController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/addTask/{id}")
    public String taskForm(@PathVariable("id") long id, Model model, HttpSession session) {
        session.setAttribute("id", id);
        model.addAttribute("task", new Task());
        return "taskForm";
    }
    @PostMapping("/addTask")
    public String addTaskToUser(@ModelAttribute Task task, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "taskForm";
        }
        taskService.addTaskToUser(task , userService.findById(Long.parseLong(session.getAttribute("id").toString())));
        return "redirect:/users";
    }


}
