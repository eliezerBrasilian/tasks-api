package com.example.task.dtos;

import com.example.task.entities.Task;

public record TaskResponseDTO(String id, String title, Boolean completed) {
    public TaskResponseDTO(Task task) {
        this(task.getId(), task.getTitle(), task.getCompleted());
    }
}