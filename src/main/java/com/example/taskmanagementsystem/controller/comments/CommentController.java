package com.example.taskmanagementsystem.controller.comments;

import com.example.taskmanagementsystem.controller.tasks.TaskDTO;
import com.example.taskmanagementsystem.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addComment(@RequestBody CommentDTO commentDTO) {
        commentService.addComment(commentDTO);
    }
}
