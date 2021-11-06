package org.example;

import org.example.repository.TodoListRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoListServerApplication {
    public static void main(String[] args){

        SpringApplication.run(TodoListServerApplication.class, args);

    }
}
