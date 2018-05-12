package br.com.ithiago.camelcourse.exception;

/**
 * Created by thiago on 5/12/18.
 */
public class DataValidationException extends RuntimeException {

    public DataValidationException(String message) {
        super(message);
    }
}
