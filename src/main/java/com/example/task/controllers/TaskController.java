package com.example.task.controllers;

import com.example.task.dtos.TaskRequestDTO;
import com.example.task.dtos.TaskResponseDTO;
import com.example.task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {
    @Autowired
    TaskService service;

    @GetMapping
    List<TaskResponseDTO> getTasks() {
        return service.getTasks();
    }


    @PostMapping
    void saveTask(@RequestBody TaskRequestDTO taskDto) {
        service.saveTask(taskDto);
    }

}