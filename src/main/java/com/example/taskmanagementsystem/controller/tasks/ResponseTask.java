package com.example.taskmanagementsystem.controller.tasks;

import com.example.taskmanagementsystem.controller.comments.ResponseComment;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record ResponseTask(@Schema(description = "Id задачи")
                           Long id,
                           @Schema(description = "описание задачи")
                           String description,
                           @Schema(description = "email пользователя, который завел задачу")
                           String ownerEmail,
                           @Schema(description = "email пользователя, который назначен исполнителем")
                           String performerEmail,
                           @Schema(description = "статус задачи")
                           String status,
                           @Schema(description = "все коментарии к данной задаче")
                           List<ResponseComment> comments) {
}
