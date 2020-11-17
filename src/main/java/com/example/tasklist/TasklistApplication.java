package com.example.tasklist;

import com.example.tasklist.model.Task;
import com.example.tasklist.model.TaskRepository;
import com.example.tasklist.model.User;
import com.example.tasklist.model.UserRepository;

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
	public CommandLineRunner taskDemo(TaskRepository TaskRepository, UserRepository UserRepository) {

		return (args) -> {
		User user1 = new User("user","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","USER");
		User user2 =new User("admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","ADMIN");
		UserRepository.save(user1);
		UserRepository.save(user2);

		TaskRepository.save(new Task("Finish this project", "ToDo", UserRepository.findByName("user")));
		TaskRepository.save(new Task("test", "ToDo", UserRepository.findByName("user")));

		};
	}
}
