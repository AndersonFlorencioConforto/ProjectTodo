package com.anderson.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.todo.Model.Todo;
import com.anderson.todo.services.TodoService;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {
	
	@Autowired private TodoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo>findById(@PathVariable Integer id) throws Exception{
		Todo obj = service.findById(id);
		if(obj == null) {
			throw new Exception("id não encontrado");
		}
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping(value="/open")
	public ResponseEntity<List<Todo>> listOpen(){
		List<Todo> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
		
	}

}
