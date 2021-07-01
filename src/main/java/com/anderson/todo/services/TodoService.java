package com.anderson.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.todo.Model.Todo;
import com.anderson.todo.repositories.Repository;

@Service
public class TodoService {
	
	@Autowired private Repository repository;
	
	public Todo findById(Integer id){
		Optional<Todo> obj = repository.findById(id);
		
		return obj.orElse(null);
	}

	public List<Todo> findAllOpen() {
		List<Todo> list = repository.findAllOpen();
		return list;
	}

}
