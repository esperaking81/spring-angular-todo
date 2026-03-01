package com.esperaawo.todos.data.repositories;

import com.esperaawo.todos.data.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
