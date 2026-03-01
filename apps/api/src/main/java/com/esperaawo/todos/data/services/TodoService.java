package com.esperaawo.todos.data.services;

import com.esperaawo.todos.data.TodoMapper;
import com.esperaawo.todos.data.entities.TodoEntity;
import com.esperaawo.todos.data.repositories.TodoRepository;
import com.esperaawo.todos.domain.models.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo create(String title) {
        final TodoEntity entity = new TodoEntity();
        entity.setTitle(title);

        todoRepository.save(entity);

        return TodoMapper.toDomainModel(entity);
    }

    public Todo find(Long id) {
        final Optional<TodoEntity> entity = todoRepository.findById(id);
        return entity.map(TodoMapper::toDomainModel).orElse(null);

    }

    public List<Todo> queryAll() {
        return todoRepository.findAll().stream().map(TodoMapper::toDomainModel).toList();
    }
}
