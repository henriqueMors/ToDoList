package br.com.henriquemors.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.henriquemors.todolist.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long>{
    
}
