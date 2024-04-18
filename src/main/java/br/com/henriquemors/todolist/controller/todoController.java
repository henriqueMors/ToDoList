package br.com.henriquemors.todolist.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.henriquemors.todolist.entity.ToDo;
import br.com.henriquemors.todolist.service.ToDoService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/ToDo")

public class ToDoController {
    
    private ToDoService ToDoService;
    

    public ToDoController(br.com.henriquemors.todolist.service.ToDoService toDoService) {
        this.ToDoService = toDoService;
    }

    @PostMapping
    List<ToDo> create(@RequestBody ToDo ToDo) {        
        return ToDoService.create(ToDo);
    }

    @GetMapping
    List<ToDo> list() {        
        return ToDoService.list();
    }

    @PutMapping
    List<ToDo> update(@RequestBody ToDo ToDo) {        
        return ToDoService.update(ToDo);
    }


    @DeleteMapping("{id}")
    List<ToDo> delete(@PathVariable("id") Long id) {   
        return ToDoService.delete(id);     

    }
}
