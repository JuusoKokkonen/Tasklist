package com.example.tasklist;

import com.example.tasklist.model.Task;
import com.example.tasklist.model.TaskRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TasklistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasklistApplication.class, args);
	}

	@Bean
	public CommandLineRunner taskDemo(TaskRepository TaskRepository) {

		return (args) -> {

		Task task1 = new Task("Finish this project", "ToDo");
		Task task2 = new Task("Test", "ToDo");
		TaskRepository.save(task1);
		TaskRepository.save(task2);
		};
	}
}
