package br.com.rest.aplication.rest_spring_boot.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OperacaoInvalidaException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  @Getter private List<String> links;

  public OperacaoInvalidaException(String message, List<String> links) {
    super(message);
    this.links = links;
  }

}
