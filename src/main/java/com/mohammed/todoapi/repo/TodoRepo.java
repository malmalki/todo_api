package com.mohammed.todoapi.repo;

import com.mohammed.todoapi.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends CrudRepository<Todo, Long> {

    List<Todo> findAll();

//    List<Todo> find
}
