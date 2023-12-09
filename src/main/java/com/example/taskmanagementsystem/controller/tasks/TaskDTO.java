package com.example.taskmanagementsystem.controller.tasks;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record TaskDTO(@Schema(description = "описание задачи", example = "положить деньги на счет в банке")
                      @NotBlank
                      String description,
                      @Schema(description = "email исполнителя", example = "masha@mail.com")
                      @Email
                      String performerEmail) {
}
