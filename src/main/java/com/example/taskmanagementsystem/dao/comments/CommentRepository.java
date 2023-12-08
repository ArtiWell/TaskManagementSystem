package com.example.taskmanagementsystem.dao.comments;

import com.example.taskmanagementsystem.dao.tasks.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity,Long> {


}
