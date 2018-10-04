package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.model.TodoResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/basic")
public class BasicController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public Todo basic() {
        return new Todo(counter.incrementAndGet(), "라면사오기");
    }

    @RequestMapping(value = "/todop", method = RequestMethod.POST)
    public Todo postBasic(@RequestParam(value = "todoTitle") String todoTitle){
        return new Todo(counter.incrementAndGet(), todoTitle);
    }

    @RequestMapping(value = "/todor", method = RequestMethod.POST)
    public ResponseEntity<Todo> postBasicResponseEntity(@RequestParam(value = "todoTitle") String todoTitle){
        return new ResponseEntity(new Todo(counter.incrementAndGet(), todoTitle), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/todos/{todoId}", method = RequestMethod.GET)
    public Todo getPath(@PathVariable int todoId){
        Todo todo1 = new Todo(1L, "문서쓰기");
        Todo todo2 = new Todo(2L, "기획회의");
        Todo todo3 = new Todo(3L, "운동");

        Map<Integer,Todo> todoMap = new HashMap();
        todoMap.put(1, todo1);
        todoMap.put(2, todo2);
        todoMap.put(3, todo3);

        return todoMap.get(todoId);
    }

    @RequestMapping(value = "/todoh", method = RequestMethod.GET)
    public ResponseEntity<TodoResource> geth(@RequestParam(value = "todoTitle") String todoTitle){
        TodoResource todoResource = new TodoResource(todoTitle);
        todoResource.add(linkTo(methodOn(BasicController.class).geth(todoTitle)).withSelfRel());

        return  new ResponseEntity(todoResource, HttpStatus.OK);
    }
}
