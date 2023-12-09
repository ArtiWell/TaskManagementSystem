package com.example.taskmanagementsystem.controller.comments;

import io.swagger.v3.oas.annotations.media.Schema;

public record ResponseComment(@Schema(description = "Id номер коментария")
                              Long id,
                              @Schema(description = "коментарий")
                              String comment) {
}
