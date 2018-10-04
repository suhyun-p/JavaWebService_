package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {
    private long id;
    private String title;

    public Todo(long id, String title) {
        this.id = id;
        this.title = title;
    }
}
