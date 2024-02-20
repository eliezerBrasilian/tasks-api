package com.example.task.dtos;

import com.example.task.enums.UserRole;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(@NotNull String email, @NotNull String password, @NotNull UserRole role) {
}