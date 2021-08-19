package com.example.todolist.integration;

import com.example.todolist.model.Todo;
import com.example.todolist.repository.TodoItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoIntegrationTest {
    @Autowired
    private TodoItemRepository todoItemRepository;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void todoData(){
        todoItemRepository.deleteAll();
        Todo todoItem = new Todo("test", false);
        todoItemRepository.save(todoItem);
    }

    @Test
    void should_return_all_todo_when_get_all() throws Exception {
        //given

        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath(("$[0].id")).isString())
                .andExpect(jsonPath("$[0].text").value("test"))
                .andExpect(jsonPath("$[0].done").value(false));

    }

    @Test
    void should_return_created_todo_when_addTodo_given_todo_information() throws Exception{
        String todo = "{\n" +
                "  \"text\": \"test\",\n" +
                "  \"done\": false\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/todos")
        .contentType(MediaType.APPLICATION_JSON)
                .content(todo))
                .andExpect(status().isOk());

    }
    
}
