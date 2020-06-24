package br.com.ithiago.restfulwebservices.service;

import br.com.ithiago.restfulwebservices.domain.Todo;
import br.com.ithiago.restfulwebservices.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedAService {

    @Autowired
    public TodoRepository todoRepository;

    private static List<Todo> todos = new ArrayList();
    private static long idCounter = 0;

    static {
        todos.add(TodoHardcodedAService.generateTodo("fonseca", "Learn Angular", false));
        todos.add(TodoHardcodedAService.generateTodo("fonseca", "Learn how to Djing", false));
    }

    private static Todo generateTodo(String username, String description, boolean isDone) {
        return new Todo(
                ++idCounter,
                username,
                description,
                new Date(),
                isDone
        );
    }

    public List<Todo> getAll(String username) {
        return todoRepository.findByUsername(username);
    }

    public Todo getById(long id) {
        return todoRepository.findById(id).get();
    }

    public Todo saveOrUpdate(Todo todo) {
        if (todo.getId() != null) {
            this.delete(todo.getId());

        } else {
            todo.setId(++idCounter);
        }

        TodoHardcodedAService.todos.add(todo);

        return todo;
    }

    public void delete(long id) {
        Todo todo = this.getById(id);
        TodoHardcodedAService.todos.remove(todo);
    }



}
