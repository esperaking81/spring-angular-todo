package com.esperaawo.todos.data;

import com.esperaawo.todos.data.entities.TodoEntity;
import com.esperaawo.todos.domain.models.Todo;

public class TodoMapper {
    public static Todo toDomainModel(TodoEntity entity) {
        return new Todo(entity.getId(), entity.getTitle(), entity.isCompleted());
    }
}
