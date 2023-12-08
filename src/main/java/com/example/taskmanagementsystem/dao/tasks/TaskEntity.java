package com.example.taskmanagementsystem.dao.tasks;

import com.example.taskmanagementsystem.dao.comments.CommentEntity;
import com.example.taskmanagementsystem.enums.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@ToString
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "owner_email")
    private String ownerEmail;

    @Column(name = "performer_email")
    private String performerEmail;


    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private TaskStatusEnum status = TaskStatusEnum.IN_PROGRESS;


    @OneToMany(mappedBy = "taskEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments = new ArrayList<>();

}
