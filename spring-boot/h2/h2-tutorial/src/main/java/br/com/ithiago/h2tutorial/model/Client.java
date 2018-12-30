package br.com.ithiago.h2tutorial.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by thiago on 12/30/18.
 */

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
