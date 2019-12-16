package com.mohammed.todoapi.service;


import com.mohammed.todoapi.model.Todo;
import com.mohammed.todoapi.repo.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepo todoRepo;
    public TodoService(TodoRepo todoRepo){
        this.todoRepo = todoRepo;
    }

    public List<Todo> allTodos(){
        return todoRepo.findAll();
    }


    public void delete(Long id){
        todoRepo.deleteById(id);
    }
    public Todo findItemById(Long id){
        Optional<Todo> optionalTodo = todoRepo.findById(id);
        if (optionalTodo.isPresent()){
            return optionalTodo.get();
        } else {
            return null;
        }

    }
}
