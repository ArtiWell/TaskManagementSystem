package com.example.taskmanagementsystem.dao.tasks;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Specifications {

    public static Specification<TaskEntity> withPerformerEmail(String performerEmail) {
        return (root, query, cb) -> {
            if (performerEmail == null) {
                return cb.conjunction();
            }
            return cb.equal(root.get("performerEmail"), performerEmail);
        };
    }

    public static Specification<TaskEntity> withOwnerEmail(String ownerEmail) {
        return (root, query, cb) -> {
            if (ownerEmail == null) {
                return cb.conjunction();
            }
            return cb.equal(root.get("ownerEmail"), ownerEmail);
        };
    }

}
