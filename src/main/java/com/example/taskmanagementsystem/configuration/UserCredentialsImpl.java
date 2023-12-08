package com.example.taskmanagementsystem.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserCredentialsImpl implements UserCredentials {

    @Override
    public String getEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
