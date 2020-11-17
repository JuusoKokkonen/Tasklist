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
		User user1 = new User("TestiUser", "Passu");
		User user2 = new User("TESTI", "XDD");
		UserRepository.save(user1);
		UserRepository.save(user2);

		TaskRepository.save(new Task("Finish this project", "ToDo", UserRepository.findByName("TestiUser")));
		TaskRepository.save(new Task("test", "ToDo", UserRepository.findByName("TESTI")));

		};
	}
}
