package br.com.ithiago.restfulwebservices.controller;

import br.com.ithiago.restfulwebservices.domain.Todo;
import br.com.ithiago.restfulwebservices.exception.NotFoundException;
import br.com.ithiago.restfulwebservices.service.TodoHardcodedAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

    @Autowired
    public TodoHardcodedAService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAll(@PathVariable String username) {
        return todoService.getAll(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> getById(@PathVariable String username, @PathVariable long id) {
        try {
            Todo todo = todoService.getById(id);
            return new ResponseEntity<Todo>(todo, HttpStatus.OK);

        } catch (NotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Todo> saveOrUpdate(@PathVariable String username, @RequestBody Todo todo) {
        try {
            Todo savedTodo = todoService.saveOrUpdate(todo);
            return new ResponseEntity<Todo>(savedTodo, HttpStatus.OK);

        } catch (NotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> delete(@PathVariable String username, @PathVariable long id) {
        try {
            todoService.delete(id);
            return ResponseEntity.noContent().build();

        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
