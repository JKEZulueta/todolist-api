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

    public Todo retrieve(String id){
        return todoItemRepository.findById(id)
                .orElse(null);
    }

    public Todo updateTodo(String id, Todo updateTodo){
        Todo currentTodo = todoItemRepository.getById(id);
        return todoItemRepository.save(updateTodoInfo(currentTodo, updateTodo));
    }

    public Todo updateTodoInfo(Todo currentTodo, Todo todoToUpdate){
        if(todoToUpdate.getText() != null){
            currentTodo.setText(todoToUpdate.getText());
        }
        if(todoToUpdate.getDone()){
            currentTodo.setDone(todoToUpdate.getDone());
        }
        return currentTodo;
    }

}
