package edu.programacion.avanzada.aluismarte.project.util;

import edu.programacion.avanzada.aluismarte.project.model.APIError;
import edu.programacion.avanzada.aluismarte.project.model.exceptions.*;
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

    @ExceptionHandler(CheckoutAddressNoAssignedException.class)
    public ResponseEntity<APIError> handle(CheckoutAddressNoAssignedException ex) {
        return createResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CheckoutPaymentMethodNoAssignedException.class)
    public ResponseEntity<APIError> handle(CheckoutPaymentMethodNoAssignedException ex) {
        return createResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AddressNoFoundException.class)
    public ResponseEntity<APIError> handle(AddressNoFoundException ex) {
        return createResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CheckoutNoFoundException.class)
    public ResponseEntity<APIError> handle(CheckoutNoFoundException ex) {
        return createResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderNoFoundException.class)
    public ResponseEntity<APIError> handle(OrderNoFoundException ex) {
        return createResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PayCheckoutWithoutProductsException.class)
    public ResponseEntity<APIError> handle(PayCheckoutWithoutProductsException ex) {
        return createResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<APIError> createResponse(String message, HttpStatus httpStatus) {
        log.info("Generating Error {}  and message {}", httpStatus, message);
        APIError apiError = APIError.builder().message(message).status(httpStatus.value()).build();
        return ResponseEntity.status(httpStatus).body(apiError);
    }
}
