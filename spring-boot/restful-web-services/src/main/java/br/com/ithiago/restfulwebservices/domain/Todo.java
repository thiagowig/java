package br.com.ithiago.restfulwebservices.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Todo {

    private Long id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;

}
