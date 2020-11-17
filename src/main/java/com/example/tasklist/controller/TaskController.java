package com.example.tasklist.controller;

import java.util.List;

import com.example.tasklist.model.Task;
import com.example.tasklist.model.TaskRepository;
import com.example.tasklist.model.User;
import com.example.tasklist.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TaskController {

    @Autowired 
    private TaskRepository TaskRepository;

    @Autowired
    private UserRepository UserRepository;

    // Show index page
    @RequestMapping("/index")
    public String taskIndex() {
        return "index";
    }

    // Show user's tasks
    @RequestMapping(value = "/tasklist")
    public String taskList(Model model) {
        model.addAttribute("tasks", TaskRepository.findAll());
        return "tasklist";
    }

    // Add new task
    @RequestMapping(value = "/add")
    public String addTask(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("users", UserRepository.findAll());
        return "addtask";
    }

    // Save new task
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Task task) {
        TaskRepository.save(task);
        return "redirect:tasklist";
    }

    // RESTful service to get all tasks
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public @ResponseBody List<Task> taskListRest() {
        return (List<Task>) TaskRepository.findAll();
    }

    // RESTful service to get all users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody List<User> userListRest() {
        return (List<User>) UserRepository.findAll();
    }
}
