package br.com.ithiago.springtesting.exception;

import br.com.ithiago.springtesting.exception.dto.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GloballyExceptionHandler {

    @ExceptionHandler({ClientNotFoundException.class})
    public ResponseEntity<ErrorMessageDTO> handleExceptions(ClientNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorMessageDTO errorMessage = new ErrorMessageDTO(status.value(), ex.getMessage());

        return new ResponseEntity<>(errorMessage, status);
    }
}
