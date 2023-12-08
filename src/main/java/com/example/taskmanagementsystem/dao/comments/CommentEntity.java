package com.example.taskmanagementsystem.dao.comments;

import com.example.taskmanagementsystem.dao.tasks.TaskEntity;
import com.example.taskmanagementsystem.dao.users.UserEntity;
import com.example.taskmanagementsystem.enums.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "comments")
@Getter
@Setter
@ToString
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment")
    private String comment;

    @JoinColumn(name = "task_id", referencedColumnName = "id")
    @ManyToOne
    private TaskEntity taskEntity;



}
