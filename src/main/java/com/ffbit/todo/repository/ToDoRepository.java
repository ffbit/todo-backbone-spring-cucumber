package com.ffbit.todo.repository;

import com.ffbit.todo.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

}
