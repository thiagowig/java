package br.com.ithiago.greendog.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by thiago on 5/31/18.
 */
@Entity
@Data
public class Property {

    @Id
    private String name;

    private String value;

    private String description;

    private String category;

}
