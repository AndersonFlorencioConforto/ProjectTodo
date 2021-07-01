package com.anderson.todo.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.todo.Model.Todo;

@Service
public class DBService {

	@Autowired
	private com.anderson.todo.repositories.Repository repository;

	public void instaciaBaseDeDados() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular",
				LocalDateTime.parse("22/05/1998 12:00", formatter), false);

		repository.saveAll(Arrays.asList(t1));
	}
}
