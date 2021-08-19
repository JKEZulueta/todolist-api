package com.example.todolist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private String id;
    private String text;
    private boolean done;

    public Todo(String text, boolean done) {
        this.text = text;
        this.done = done;
    }

    public Todo(){

    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean getDone() {
        return done;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
