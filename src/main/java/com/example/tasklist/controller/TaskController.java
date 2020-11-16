package com.example.tasklist.controller;

import com.example.tasklist.model.TaskRepository;
import com.example.tasklist.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    //Show user's tasks
    @RequestMapping(value = "/tasklist")
    public String taskList(Model model) {
        model.addAttribute("tasks", TaskRepository.findAll());
        return "tasklist";
    }

}
