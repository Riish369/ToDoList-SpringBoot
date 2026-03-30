package com.example.ToDoList.controller;

import com.example.ToDoList.model.ToDo;
import com.example.ToDoList.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final ToDoService toDoService;
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> getAll() {
        return toDoService.getAll();
    }

    @PostMapping
    public ToDo createToDo(@RequestBody ToDo todo){
        return toDoService.createToDo(todo);
    }

    @GetMapping("/{id}")
    public ToDo getById(@PathVariable Integer id){
        return toDoService.getById(id);
    }

    @PutMapping("/{id}")
    public ToDo updateToDo(@PathVariable Integer id, @RequestBody ToDo todo){
        return toDoService.updateToDo(id,todo);
    }

    @DeleteMapping("/{id}")
    public String deleteToDo(@PathVariable Integer id){
        return toDoService.deleteTodo(id);
    }

}
