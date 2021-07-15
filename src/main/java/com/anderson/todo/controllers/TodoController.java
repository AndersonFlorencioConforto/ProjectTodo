package com.anderson.todo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.anderson.todo.DTO.TodoDTO;
import com.anderson.todo.Model.Todo;
import com.anderson.todo.services.TodoService;
@CrossOrigin("*")
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
	
	@GetMapping(value="/closed")
	public ResponseEntity<List<Todo>> listClosed(){
		List<Todo> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/all")
	public ResponseEntity<List<Todo>> listAll(){
		List<Todo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Todo> create(@RequestBody TodoDTO obj){
		Todo obj2 = service.create2(obj);
		obj2 = service.create(obj2);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping(value = "alter/{id}")
	public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo obj){
		Todo newObj = service.update(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	

}
