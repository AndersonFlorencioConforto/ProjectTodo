package com.anderson.todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import com.anderson.todo.Model.Todo;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	@Autowired private com.anderson.todo.repositories.Repository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular", LocalDateTime.parse("22/05/1998 12:00", formatter), false);
		
		repository.saveAll(Arrays.asList(t1));
		
	}

}
