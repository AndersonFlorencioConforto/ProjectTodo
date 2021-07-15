package com.anderson.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.todo.Model.Todo;

@Service
public class DBService {

	@Autowired
	private com.anderson.todo.repositories.Repository repository;

	public void instaciaBaseDeDados() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		
		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular",
				sdf.parse("22/05/1998"), false);
		Todo t2 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular",
				sdf.parse("22/05/1998"), true);
		Todo t3 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular",
				sdf.parse("22/05/1998"), true);
		Todo t4 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular",
				sdf.parse("22/05/1998"), true);
		Todo t5 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular",
				sdf.parse("22/05/1998"), true);
		Todo t6 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular",
				sdf.parse("22/05/1998"), false);

		repository.saveAll(Arrays.asList(t1,t2,t3,t4,t5,t6));
	}
}
