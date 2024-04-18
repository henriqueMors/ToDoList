package br.com.henriquemors.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.henriquemors.todolist.entity.ToDo;
import br.com.henriquemors.todolist.repository.ToDoRepository;

@Service
public class ToDoService {
    private ToDoRepository ToDoRepository;
    
    
    public ToDoService(ToDoRepository toDoRepository) {
        this.ToDoRepository = toDoRepository;
    }

    public List<ToDo> create(ToDo ToDo) {
        ToDoRepository.save(ToDo);
        return list();
    }

    public List<ToDo> list() {
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending());
        return ToDoRepository.findAll(sort);
    }

    public List<ToDo> update(ToDo ToDo) {
        ToDoRepository.save(ToDo);
        return list();
    }

    public List<ToDo> delete(Long id) {
        ToDoRepository.deleteById(id);
        return list();
    }
}
