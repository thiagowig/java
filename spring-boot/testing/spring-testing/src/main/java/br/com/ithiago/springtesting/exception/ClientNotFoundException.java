package br.com.ithiago.springtesting.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String id) {
        super(id);
    }
}
