package com.example.todolist.controller;

import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping(value = "/todos")
    List<Todo> create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping(value = "/todos")
    List<Todo> list() {
        return todoService.list();
    }

    @PutMapping(value = "/todos")
    List<Todo> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("/todos/{id}")
    List<Todo> delete(@PathVariable(value = "id") Long id) {
        return todoService.delete(id);
    }
}
