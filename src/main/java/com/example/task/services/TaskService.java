package com.example.task.services;

import com.example.task.dtos.TaskResponseDTO;
import com.example.task.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository repository;

    public List<TaskResponseDTO> getTasks() {
        List<TaskResponseDTO> tasks = repository.findAll().stream().map(task -> new TaskResponseDTO(task)).toList();

        return tasks;
    }
}