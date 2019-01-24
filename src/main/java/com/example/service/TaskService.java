package com.example.service;

import com.example.persistence.entity.Task;

public interface TaskService {
    Iterable<Task> findAll();
    void save(Task task);
}
