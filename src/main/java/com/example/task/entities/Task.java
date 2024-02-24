package com.example.task.entities;

import com.example.task.dtos.TaskRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tasks")
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String title;

    @Column
    private Boolean completed;


    public Task(TaskRequestDTO taskDto) {
        this.title = taskDto.title();
        this.completed = taskDto.completed();
    }
}