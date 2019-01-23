package com.example.service.impl;

import com.example.persistence.entity.Task;
import com.example.persistence.repository.TaskRepository;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private final TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }
}
