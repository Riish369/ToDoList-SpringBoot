package com.example.ToDoList.service;

import java.util.*;
import com.example.ToDoList.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ToDoService {
    private final List<ToDo> toDos = new ArrayList<>();
    private Integer nextId = 1;

    public List<ToDo> getAll(){
        return toDos;
    }

    public ToDo getById(Integer id){
        for(ToDo todos : toDos){
            if(todos.getId().equals(id)){
                return todos;
            }
        }
        return null;
    }

    public ToDo createToDo(ToDo todo){
        todo.setId(nextId++);
        toDos.add(todo);
        return todo;
    }

    public ToDo updateToDo(Integer id, ToDo updatedtodo){
        for (ToDo todos : toDos){
            if(todos.getId().equals(id)){
                todos.setTitle(updatedtodo.getTitle());
                todos.setCompleted(updatedtodo.getCompleted());
                return todos;
            }
        }
        return null;
    }

    public String deleteTodo(Integer id) {
        ToDo todo = getById(id);
        if (todo != null) {
            toDos.remove(todo);
            return "Todo deleted successfully";
        }
        return "Todo not found";
    }
}
