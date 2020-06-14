package br.com.ithiago.restfulwebservices.service;

import br.com.ithiago.restfulwebservices.domain.Todo;
import br.com.ithiago.restfulwebservices.utils.CustomCollector;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedAService {

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

    public List<Todo> getAll() {
        return TodoHardcodedAService.todos;
    }

    public Todo getById(long id) {
        Todo todo = TodoHardcodedAService.todos.stream()
            .filter(item -> item.getId().equals(id))
            .collect(CustomCollector.toSingleton());

        return todo;
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
