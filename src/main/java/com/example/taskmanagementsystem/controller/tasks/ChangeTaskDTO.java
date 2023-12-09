package com.example.taskmanagementsystem.controller.tasks;

import com.example.taskmanagementsystem.enums.TaskStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;

public record ChangeTaskDTO(@Schema(description = "новый статус")
                            TaskStatusEnum status) {
}
