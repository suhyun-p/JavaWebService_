package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

@Getter
@Setter
public class TodoResource extends ResourceSupport {
    private String title;

    public TodoResource() {

    }

    public TodoResource(String title) {
        this.title = title;
    }
}
