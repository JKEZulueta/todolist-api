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

    public Todo create(Todo todo){
        return todoItemRepository.save(todo);
    }

    public void delete(String todo){
        todoItemRepository.deleteById(todo);
    }

    public Todo update(String id, Todo todoItem){
        Todo getTodo = retrieve(id);
        getTodo.setDone(todoItem.getDone());
        return todoItemRepository.save(getTodo);
    }

    public Todo retrieve(String id){
        return todoItemRepository.findById(id)
                .orElse(null);
    }

}
