package com.example.taskmanagementsystem.controller.users;

import com.example.taskmanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseUser addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

}
