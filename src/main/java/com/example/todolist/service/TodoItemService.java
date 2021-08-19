package com.example.todolist.service;

import com.example.todolist.model.Todo;
import com.example.todolist.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    public TodoItemService(TodoItemRepository todoItemRepository){
        this.todoItemRepository = todoItemRepository;
    }

    public List<Todo> getAll(){
        return todoItemRepository.findAll();
    }



}
