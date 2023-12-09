package com.example.taskmanagementsystem.controller.users;

import io.swagger.v3.oas.annotations.media.Schema;

public record ResponseUser(@Schema(description = "Id номер пользователя")
                           Long id,
                           @Schema(description = "email пользователя, к которому относится номер")
                           String email) {
}
