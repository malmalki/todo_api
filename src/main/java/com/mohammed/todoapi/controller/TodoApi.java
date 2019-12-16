package com.mohammed.todoapi.controller;


import com.mohammed.todoapi.model.Todo;
import com.mohammed.todoapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoApi {

    private final TodoService todoService;



    public TodoApi(TodoService todoService){
        this.todoService = todoService;
    }




    @RequestMapping("/todos")
    public List<Todo> allTodos(){
        return todoService.allTodos();
    }

    @RequestMapping(value = "/todo/{id}" , method = RequestMethod.GET)
    public Todo todo(@PathVariable("id") Long id){

        return todoService.findItemById(id);
    }

    @RequestMapping(value = "todo/{id}" , method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable("id") Long id){
        todoService.delete(id);
    }
}
