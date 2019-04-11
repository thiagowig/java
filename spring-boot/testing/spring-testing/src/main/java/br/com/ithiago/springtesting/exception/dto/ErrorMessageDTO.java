package br.com.ithiago.springtesting.exception.dto;

public class ErrorMessageDTO {

    private Integer status;

    private String message;

    public ErrorMessageDTO(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
