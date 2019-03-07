package br.com.ithiago.pet.scheduleservice.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by thiago on 12/2/18.
 */
@Data
public class RegisterRequest implements Serializable {

    private Long userId;

    private String message;
}