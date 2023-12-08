package com.example.taskmanagementsystem.controller.tasks;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record TaskDTO(@NotBlank String description, @Email String ownerEmail, @Email String performerEmail) {
}
