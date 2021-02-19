package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    private TodosRepository todosRepository;

    @Transactional
    @Override
    public void markComplete(long todoid)
    {
        Todos t = todosRepository.findById(todoid)
            .orElseThrow(() -> new EntityNotFoundException("Todo "+todoid+" not found!"));

        t.setTodoid(todoid);
        t.setCompleted(true);
    }
}
