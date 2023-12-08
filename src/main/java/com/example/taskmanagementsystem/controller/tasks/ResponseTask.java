package com.example.taskmanagementsystem.controller.tasks;

import com.example.taskmanagementsystem.controller.comments.ResponseComment;

import java.util.List;

public record ResponseTask(Long id, String description, String ownerEmail, String performerEmail, String status, List<ResponseComment> comments) {
}
