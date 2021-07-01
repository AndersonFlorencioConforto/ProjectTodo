package com.anderson.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.todo.Model.Todo;
import com.anderson.todo.repositories.Repository;
import com.anderson.todo.services.exceptions.ObjectNotFoundException;

@Service
public class TodoService {
	
	@Autowired private Repository repository;
	
	public Todo findById(Integer id){
		Optional<Todo> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! "+ id + ", Tipo" + Todo.class.getName()));
	}

	public List<Todo> findAllOpen() {
		List<Todo> list = repository.findAllOpen();
		return list;
	}
	
	public List<Todo> findAllClose() {
		List<Todo> list = repository.findAllClosed();
		return list;
	}
	
	public List<Todo> findAll() {
		List<Todo> list = repository.findAll();
		return list;
	}

	public Todo create(Todo obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	public Todo update(Integer id, Todo obj) {
		Todo newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizado(obj.getFinalizado());
		return repository.save(newObj);
	}

}
