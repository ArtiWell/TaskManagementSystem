package com.example.taskmanagementsystem.controller.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Profile(value = {"test"})
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void addTask() {

    }

    @Test
    void getAllTasks() {
        ResponseTask[] responseTask = restTemplate.withBasicAuth("masha@mail.com","1234").getForObject("http://localhost:"+port+"/api/v1/task", ResponseTask[].class);
        Assertions.assertEquals(4,responseTask.length);


    }

    @Test
    void testAddTask() {
    }

    @Test
    void testGetAllTasks() {
    }

    @Test
    void deleteTask() {
    }

    @Test
    void patchTask() {
    }

    @Test
    void changeStatus() {
    }
}