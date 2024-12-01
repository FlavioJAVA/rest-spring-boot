package br.com.rest.aplication.rest_spring_boot.service;

import br.com.rest.aplication.rest_spring_boot.enums.TipoOperacao;
import br.com.rest.aplication.rest_spring_boot.exceptions.FalhaNaOperacaoException;
import br.com.rest.aplication.rest_spring_boot.exceptions.OperacaoInvalidaException;
import br.com.rest.aplication.rest_spring_boot.util.Util;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculadoraService {

    public Double calcular(String numero1, String numero2, int operacao, HttpServletRequest request) {

        validarParametros(numero1, numero2, operacao, request);

        switch (operacao){
            case 1:
                return Double.parseDouble(numero1) + Double.parseDouble(numero2);
            case 2:
                return Double.parseDouble(numero1) - Double.parseDouble(numero2);
            case 3:
                return Double.parseDouble(numero1) * Double.parseDouble(numero2);
            case 4:
                if(Double.parseDouble(numero2) == 0){
                    throw new FalhaNaOperacaoException("Favor informar um número divisor diferente de zero");
                }
                return Double.parseDouble(numero1) / Double.parseDouble(numero2);
            case 5:
                return (Double.parseDouble(numero1) + Double.parseDouble(numero2)) / 2;
            case 6:
                return Math.sqrt(Double.parseDouble(numero1));
            default:
                throw new OperacaoInvalidaException("Não foi possível realizar nenhuma operação", criarLinksPossiveis(request.getRequestURL().toString()));
        }
    }

    private void validarParametros(String numero1, String numero2, int operacao, HttpServletRequest request) {
        if(!Util.isNumeric(numero1) || !Util.isNumeric(numero2)) {
            throw new FalhaNaOperacaoException("Favor inserir um valor numérico");
        } else if(!TipoOperacao.isTipoOperacaoValido(operacao)){
            throw new OperacaoInvalidaException("Não foi possível realizar nenhuma operação", criarLinksPossiveis(request.getRequestURL().toString()));
        }
    }

    private List<String> criarLinksPossiveis(String baseLink) {
        List<String> links = new ArrayList<>();

        // Loop sobre o índice das operações definidas no enum
        for (int i = 1; i <= TipoOperacao.values().length; i++) {
            // Monta a nova URL substituindo a operação pelo índice da iteração
            String link = baseLink.replaceAll("/[0-9]+$", "/" + i);
            links.add(link); // Adiciona o link à lista
        }

        return links;
    }

}
