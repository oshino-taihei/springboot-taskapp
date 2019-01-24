package com.example.web.controller;

import com.example.persistence.entity.Task;
import com.example.service.TaskService;
import com.example.web.form.TaskForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {

    @Autowired
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = {"/", "/tasks"})
    public String index(Model model) {
        Iterable<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @RequestMapping("/tasks/create")
    public String create(Model model) {
        // フィールドが全てnullのフォームインスタンスを追加する
        model.addAttribute(TaskForm.createEmptyForm());
        return "create";
    }

    @PostMapping("/tasks/insert")
    public String insert(@Validated TaskForm taskForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        // フォームをエンティティに変換
        Task task = taskForm.convertToEntity();
        taskService.save(task);
        return "redirect:/tasks";
    }
}
