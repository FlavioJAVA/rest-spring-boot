package br.com.rest.aplication.rest_spring_boot.exceptions;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String message;
    private String details;
    private List<String> links;

    public ExceptionResponse(Date timestamp, String message, String details, List<String> links) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.links = links;
    }
}
