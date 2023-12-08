package com.example.taskmanagementsystem.controller.tasks;

import com.example.taskmanagementsystem.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;

@RestController
@RequiredArgsConstructor
@RequestMapping("task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addTask(@RequestBody TaskDTO taskDTO) {
        taskService.addTask(taskDTO);
    }

    @GetMapping
    public List<ResponseTask> getAllTasks(
            @PageableDefault(size = 20, sort = {"id"}, direction = ASC) Pageable pageable,
            FilterTask filterTask
    ){
        return taskService.getAllTasks(pageable,filterTask);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PatchMapping("{id}")
    public ResponseTask patchTask (@PathVariable Long id,@RequestBody @Valid TaskDTO taskDTO) {
        return taskService.patchTask(id, taskDTO);
    }
    @PutMapping("/{id}/status")
    public ResponseTask changeStatus(@PathVariable Long id,@RequestBody ChangeTaskDTO taskDTO){
        return taskService.changeStatus(id,taskDTO);
    }

}
