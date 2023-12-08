package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.configuration.UserCredentials;
import com.example.taskmanagementsystem.controller.comments.ResponseComment;
import com.example.taskmanagementsystem.controller.tasks.ChangeTaskDTO;
import com.example.taskmanagementsystem.controller.tasks.FilterTask;
import com.example.taskmanagementsystem.controller.tasks.ResponseTask;
import com.example.taskmanagementsystem.controller.tasks.TaskDTO;
import com.example.taskmanagementsystem.dao.tasks.Specifications;
import com.example.taskmanagementsystem.dao.tasks.TaskEntity;
import com.example.taskmanagementsystem.dao.tasks.TaskRepository;
import com.example.taskmanagementsystem.exceptions.NotAuthException;
import com.example.taskmanagementsystem.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {

    private final UserCredentials userCredentials;
    private final TaskRepository taskRepository;

    public void addTask(TaskDTO taskDTO) {
        TaskEntity task = new TaskEntity();
        task.setDescription(taskDTO.description());
        task.setOwnerEmail(taskDTO.ownerEmail());
        task.setPerformerEmail(taskDTO.performerEmail());
        taskRepository.save(task);
    }

    public List<ResponseTask> getAllTasks(Pageable pageable, FilterTask filterTask) {
        return taskRepository.findAll(filterTask, pageable)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }


    public void deleteTask(Long id) {

        var taskOpt = taskRepository.findById(id);
        if (taskOpt.isEmpty()) {
            return;
        }
        if (userCredentials.getEmail().equals(taskOpt.get().getOwnerEmail())) {
            taskRepository.deleteById(id);
        } else {
            throw new NotAuthException();
        }
    }


    public ResponseTask patchTask(Long id, TaskDTO taskDTO) {
        var task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException(id));


        if (userCredentials.getEmail().equals(task.getOwnerEmail())) {
            if (taskDTO.description() != null) {
                task.setDescription(taskDTO.description());
            }
            if (taskDTO.performerEmail() != null) {
                task.setPerformerEmail(taskDTO.performerEmail());
            }
        } else {
            throw new NotAuthException();
        }

        taskRepository.save(task);

        return new ResponseTask(task.getId(), task.getDescription(), task.getOwnerEmail(), task.getPerformerEmail(),
                task.getStatus().toString(), task.getComments().stream().map(
                commentEntity ->
                        new ResponseComment(commentEntity.getId(), commentEntity.getComment())
        ).collect(Collectors.toList()));

    }

    public ResponseTask changeStatus(Long id, ChangeTaskDTO taskDTO) {
        var task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        if (taskDTO.status() != null) {
            if (userCredentials.getEmail().equals(task.getOwnerEmail()) ||
                    userCredentials.getEmail().equals(task.getPerformerEmail())) {
                task.setStatus(taskDTO.status());
            }
        } else {
            throw new NotAuthException();
        }
        return new ResponseTask(task.getId(), task.getDescription(), task.getOwnerEmail(), task.getPerformerEmail(),
                task.getStatus().toString(), task.getComments().stream().map(
                commentEntity ->
                        new ResponseComment(commentEntity.getId(), commentEntity.getComment())
        ).collect(Collectors.toList()));
    }


    private ResponseTask map(TaskEntity taskEntity) {
        return new ResponseTask(taskEntity.getId(),
                taskEntity.getDescription(),
                taskEntity.getOwnerEmail(),
                taskEntity.getPerformerEmail(),
                taskEntity.getStatus().toString(),
                taskEntity.getComments()
                        .stream()
                        .map(commentEntity ->
                                new ResponseComment(commentEntity.getId(), commentEntity.getComment())
                        ).collect(Collectors.toList()));
    }

}
