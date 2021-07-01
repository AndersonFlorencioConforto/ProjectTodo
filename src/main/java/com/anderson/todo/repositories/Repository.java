package com.anderson.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anderson.todo.Model.Todo;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Todo, Integer>{

}
