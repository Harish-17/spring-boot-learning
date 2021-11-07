//$Id$
package com.example.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.todo.dao.ToDoRepository;
import com.example.todo.pojo.ToDo;

@RestController
@CrossOrigin //Allow cross origin requests
public class ToDoController
{

	@Autowired private ToDoRepository toDoRepo;
	
	@GetMapping("todos") 
	public List<ToDo> getAllTodos(ToDo todo) {
		return toDoRepo.findAll();
	}
	
	@GetMapping("todos/{id}")
	public ToDo getTodo(@PathVariable Integer id) {
		try {
			return toDoRepo.findById(id).orElseThrow(IllegalArgumentException :: new);
		}catch(IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, id+" not found");
		}
	}
	
	@PostMapping("todos") 
	public ToDo createTodo(@RequestBody ToDo todo) {
		toDoRepo.save(todo);
		return todo;
	}
	
	@PutMapping("todos") 
	public ToDo updateTodo(@RequestBody ToDo todo) {
		toDoRepo.save(todo);
		return todo;
	}
}
