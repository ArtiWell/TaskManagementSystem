package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.controller.comments.CommentDTO;
import com.example.taskmanagementsystem.dao.comments.CommentEntity;
import com.example.taskmanagementsystem.dao.comments.CommentRepository;
import com.example.taskmanagementsystem.dao.tasks.TaskRepository;
import com.example.taskmanagementsystem.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    public void addComment(CommentDTO commentDTO) {
        CommentEntity comment = new CommentEntity();
        comment.setComment(commentDTO.comment());
        comment.setTaskEntity(taskRepository.findById(comment.getId()).orElseThrow(() -> new NotFoundException(comment.getId())));
        commentRepository.save(comment);
    }
}
