package br.com.rest.aplication.rest_spring_boot.exceptions.handler;

import br.com.rest.aplication.rest_spring_boot.exceptions.ExceptionResponse;
import br.com.rest.aplication.rest_spring_boot.exceptions.FalhaNaOperacaoException;
import br.com.rest.aplication.rest_spring_boot.exceptions.OperacaoInvalidaException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class MyResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception exception, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false), null);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FalhaNaOperacaoException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception exception, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false), null);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OperacaoInvalidaException.class)
    public ResponseEntity<ExceptionResponse> handleOperacaoInvalida(OperacaoInvalidaException ex, HttpServletRequest request) {
        String requestDetails = request.getRequestURI();
        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), requestDetails, ex.getLinks());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
