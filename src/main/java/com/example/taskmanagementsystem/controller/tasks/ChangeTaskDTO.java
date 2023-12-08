package com.example.taskmanagementsystem.controller.tasks;

import com.example.taskmanagementsystem.enums.TaskStatusEnum;

public record ChangeTaskDTO(TaskStatusEnum status) {
}
