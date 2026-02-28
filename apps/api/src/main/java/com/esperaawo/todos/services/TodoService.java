package com.esperaawo.todos.services;

import com.esperaawo.todos.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {
    private final AtomicLong counter = new AtomicLong();
    private final List<Todo> todos = new ArrayList<>();

    public Todo create(String title) {
        final Todo newTodo = new Todo(counter.incrementAndGet(), title, false);
        todos.add(newTodo);

        return newTodo;
    }

    public Todo find(Long id) {
        for (Todo todo : todos) {
            if (todo.id().equals(id)) {
                return todo;
            }
        }

        return null;
    }

    public List<Todo> queryAll() {
        return todos;
    }
}
