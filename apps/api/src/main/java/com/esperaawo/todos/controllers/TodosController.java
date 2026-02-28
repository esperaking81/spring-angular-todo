package com.esperaawo.todos.controllers;

import com.esperaawo.todos.domain.Todo;
import com.esperaawo.todos.dtos.CreateTodoDto;
import com.esperaawo.todos.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodosController {
    private final TodoService todoService;

    public TodosController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todos")
    Todo create(@RequestBody CreateTodoDto body) {
        return todoService.create(body.title());
    }

    @GetMapping("/todos/{id}")
    ResponseEntity<Todo> getById(@PathVariable String id) {
        final Todo todo = todoService.find(Long.parseLong(id));
        if (todo == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }


    @GetMapping("/todos")
    List<Todo> getAll() {
        return todoService.queryAll();
    }
}