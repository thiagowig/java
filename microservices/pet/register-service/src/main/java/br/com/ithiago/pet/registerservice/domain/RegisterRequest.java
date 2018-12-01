package br.com.ithiago.pet.registerservice.domain;

import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by thiago on 12/1/18.
 */
@Data
public class RegisterRequest implements Serializable {

    private Long userId;

    private String message;
}

