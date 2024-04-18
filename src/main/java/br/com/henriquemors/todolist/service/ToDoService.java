package br.com.henriquemors.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.henriquemors.todolist.entity.ToDo;
import br.com.henriquemors.todolist.repository.ToDoRepository;

@Service
public class ToDoService {
    private ToDoRepository ToDoRepository;
    
    
    public ToDoService(br.com.henriquemors.todolist.repository.ToDoRepository toDoRepository) {
        this.ToDoRepository = toDoRepository;
    }

    public List<ToDo> create(ToDo ToDo) {
        ToDoRepository.save(entity:null); //11:28

    }
    public List<ToDo> list() {

    }
    public List<ToDo> delete() {

    }
    public List<ToDo> create() {

    }
}
