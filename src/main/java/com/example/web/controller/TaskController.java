package com.example.web.controller;

import com.example.persistence.entity.Task;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {

    @Autowired
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "index";
    }
}
