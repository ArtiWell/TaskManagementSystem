package com.example.taskmanagementsystem.dao.tasks;

import com.example.taskmanagementsystem.controller.tasks.FilterTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import static com.example.taskmanagementsystem.dao.tasks.Specifications.withOwnerEmail;
import static com.example.taskmanagementsystem.dao.tasks.Specifications.withPerformerEmail;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>, JpaSpecificationExecutor<TaskEntity> {


    default Page<TaskEntity> findAll(FilterTask filterTask, Pageable pageable) {
        return findAll(
                withOwnerEmail(filterTask.ownerEmail())
                        .and(withPerformerEmail(filterTask.performerEmail()))
                , pageable);
    }
}
