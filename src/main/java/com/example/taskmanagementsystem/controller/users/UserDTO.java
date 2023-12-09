package com.example.taskmanagementsystem.controller.users;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(@Schema(description = "email пользователя", example = "misha@mail.com")
                      @NotBlank
                      String email,
                      @Schema(description = "пароль для входа", example = "1234")
                      @NotBlank
                      String password) {
}
