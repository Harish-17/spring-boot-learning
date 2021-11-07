//$Id$
package com.example.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.pojo.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo,Integer>
{}
