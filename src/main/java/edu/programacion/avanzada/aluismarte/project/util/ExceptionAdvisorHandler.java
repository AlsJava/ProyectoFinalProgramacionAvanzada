package edu.programacion.avanzada.aluismarte.project.util;

import edu.programacion.avanzada.aluismarte.project.model.APIError;
import edu.programacion.avanzada.aluismarte.project.model.exceptions.AddressNoFoundException;
import edu.programacion.avanzada.aluismarte.project.model.exceptions.BadSagaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionAdvisorHandler {

    @ExceptionHandler(BadSagaException.class)
    public ResponseEntity<APIError> handle(BadSagaException ex) {
        return createResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddressNoFoundException.class)
    public ResponseEntity<APIError> handle(AddressNoFoundException ex) {
        return createResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<APIError> createResponse(String message, HttpStatus httpStatus) {
        log.info("Generating Error {}  and message {}", httpStatus, message);
        APIError apiError = APIError.builder().message(message).status(httpStatus.value()).build();
        return ResponseEntity.status(httpStatus).body(apiError);
    }
}
