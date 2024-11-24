package br.com.rest.aplication.rest_spring_boot.controller;

import br.com.entity.OlaMundo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class OlaMundoController {

    private static final String template = "Ola, %s!";
    private static AtomicLong counter = new AtomicLong();

    @RequestMapping("/olamundo")
    public OlaMundo olaMundo(@RequestParam(value = "nome", defaultValue = "world") String nome) {
        return new OlaMundo(counter.incrementAndGet(), String.format(template, nome));
    }

}
