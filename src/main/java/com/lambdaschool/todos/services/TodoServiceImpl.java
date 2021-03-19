package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service(value = "todoServices")
public class TodoServiceImpl implements TodosService
{
    @Autowired
    private TodosRepository todosRepository;

    @Transactional
    @Override
    public void markComplete(long todoid)
    {
      Todos todos = todosRepository.findById(todoid)
            .orElseThrow(()-> new EntityNotFoundException("Todo "+todoid+" not found"));
       todos.setCompleted(true);
    }
}
