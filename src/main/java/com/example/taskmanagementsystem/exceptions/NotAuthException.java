package com.example.taskmanagementsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotAuthException extends RuntimeException{

        public NotAuthException() {
            super("Задача другого исполнителя");
        }

}
