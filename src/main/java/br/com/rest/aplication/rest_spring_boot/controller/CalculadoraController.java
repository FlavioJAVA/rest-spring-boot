package br.com.rest.aplication.rest_spring_boot.controller;

import br.com.rest.aplication.rest_spring_boot.exceptions.FalhaNaOperacaoException;
import br.com.rest.aplication.rest_spring_boot.service.CalculadoraService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    private CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @RequestMapping(value = "calculadora/{numero1}/{numero2}/{operacao}", method = RequestMethod.GET)
    public ResponseEntity calculadora(@PathVariable(value = "numero1") String numero1, @PathVariable(value = "numero2") String numero2, @PathVariable(value = "operacao") int operacao, HttpServletRequest request) throws FalhaNaOperacaoException {
        return ResponseEntity.ok(calculadoraService.calcular(numero1, numero2, operacao, request) );
    }
}
