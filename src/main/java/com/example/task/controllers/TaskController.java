package com.example.task.controllers;

import com.example.task.dtos.TaskResponseDTO;
import com.example.task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tasks/v1")
public class TaskController {
    @Autowired
    TaskService service;

    @GetMapping
    List<TaskResponseDTO> getTasks() {
        return service.getTasks();
    }

}