package com.example.taskmanagementsystem.controller.comments;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CommentDTO(@Schema(description = "комментарий к задаче", example = "успеть до нового года")
                         @NotBlank
                         String comment,
                         @Schema(description = "Id номер пользователя, который выполняет задачу", example = "2")
                         Long taskId) {
}
