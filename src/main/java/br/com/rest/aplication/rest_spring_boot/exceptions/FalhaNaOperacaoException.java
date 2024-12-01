package br.com.rest.aplication.rest_spring_boot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FalhaNaOperacaoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public FalhaNaOperacaoException(String message) {
        super(message);
    }
}
