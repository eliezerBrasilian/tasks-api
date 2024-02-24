package com.example.task.services;

import com.example.task.dtos.TaskRequestDTO;
import com.example.task.dtos.TaskRequestRenameTitleDto;
import com.example.task.dtos.TaskResponseDTO;
import com.example.task.entities.Task;
import com.example.task.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public void saveTask(TaskRequestDTO taskDto) {
        var task = new Task(taskDto);
        repository.save(task);
    }

    public void renameTitle(TaskRequestRenameTitleDto taskDto) {

        var taskFounded = repository.findById(taskDto.id())
                .orElseThrow(() -> new RuntimeException("error with id provided"));
        taskFounded.setTitle(taskDto.newTitle());

        try {
            repository.save(taskFounded);
            ResponseEntity.ok().body("renamed successufly");
        } catch (RuntimeException ex) {
            throw new RuntimeException("error on rename task");
        }
    }

}