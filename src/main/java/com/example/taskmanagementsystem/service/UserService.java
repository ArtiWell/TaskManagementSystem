package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.configuration.UserDetailsImpl;
import com.example.taskmanagementsystem.controller.users.ResponseUser;
import com.example.taskmanagementsystem.controller.users.UserDTO;
import com.example.taskmanagementsystem.dao.users.UserEntity;
import com.example.taskmanagementsystem.dao.users.UserRepository;
import com.example.taskmanagementsystem.exceptions.ConflictException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmailIgnoreCase(email).orElseGet(UserEntity::new);
        return new UserDetailsImpl(user);
    }

    public ResponseUser addUser(UserDTO userDTO) {
        if (userRepository.findByEmailIgnoreCase(userDTO.email()).isPresent()) {
            throw new ConflictException();
        }
        UserEntity user = new UserEntity();
        user.setEmail(userDTO.email());
        user.setPassword(encoder.encode(userDTO.password()));
        userRepository.save(user);
        return new ResponseUser(user.getId(),user.getEmail());
    }
}
