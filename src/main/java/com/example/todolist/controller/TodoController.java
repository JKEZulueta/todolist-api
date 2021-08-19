package com.example.todolist.controller;


import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/todos")
public class TodoController {
//    @Autowired
    private final TodoItemService todoItemService;

    @Autowired
    public TodoController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping
    public List<Todo> getAll(){
        return todoItemService.getAll();
    }

}
