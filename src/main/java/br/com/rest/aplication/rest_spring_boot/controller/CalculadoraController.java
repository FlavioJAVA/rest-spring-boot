package br.com.rest.aplication.rest_spring_boot.controller;

import br.com.rest.aplication.rest_spring_boot.exceptions.OperacaoNaoSuportadaException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    @RequestMapping(value = "/soma/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double somar(@PathVariable(value = "numero1") String numero1, @PathVariable(value = "numero2") String numero2) throws OperacaoNaoSuportadaException{
        if(!isNumeric(numero1) || !isNumeric(numero2)) {
            throw new OperacaoNaoSuportadaException("Favor inserir um valor numérico");
        }
        return Double.parseDouble(numero1) + Double.parseDouble(numero2);
    }

    @RequestMapping(value = "/subtrai/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double subtrair(@PathVariable(value = "numero1") String numero1, @PathVariable(value = "numero2") String numero2) throws OperacaoNaoSuportadaException{
        if(!isNumeric(numero1) || !isNumeric(numero2)) {
            throw new OperacaoNaoSuportadaException("Favor inserir um valor numérico");
        }
        return Double.parseDouble(numero1) - Double.parseDouble(numero2);
    }

    @RequestMapping(value = "/multiplica/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double multiplicar(@PathVariable(value = "numero1") String numero1, @PathVariable(value = "numero2") String numero2) throws OperacaoNaoSuportadaException{
        if(!isNumeric(numero1) || !isNumeric(numero2)) {
            throw new OperacaoNaoSuportadaException("Favor inserir um valor numérico");
        }
        return Double.parseDouble(numero1) * Double.parseDouble(numero2);
    }

    @RequestMapping(value = "/divide/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double dividir(@PathVariable(value = "numero1") String numero1, @PathVariable(value = "numero2") String numero2) throws OperacaoNaoSuportadaException {
        if(!isNumeric(numero1) || !isNumeric(numero2)) {
            throw new OperacaoNaoSuportadaException("Favor inserir um valor numérico");
        } else if(Double.parseDouble(numero2) == 0){
            throw new OperacaoNaoSuportadaException("Favor informar um número divisor diferente de zero");
        }
        return Double.parseDouble(numero1) / Double.parseDouble(numero2);
    }

    @RequestMapping(value = "/calculamedia/{numero1}/{numero2}", method = RequestMethod.GET)
    public Double calcularMedia(@PathVariable(value = "numero1") String numero1, @PathVariable(value = "numero2") String numero2) throws OperacaoNaoSuportadaException{
        if(!isNumeric(numero1) || !isNumeric(numero2)) {
            throw new OperacaoNaoSuportadaException("Favor inserir um valor numérico");
        }
        return (Double.parseDouble(numero1) + Double.parseDouble(numero2)) / 2;
    }

    @RequestMapping(value = "/calcularaizquadrada/{numero1}", method = RequestMethod.GET)
    public Double calcularRaizQuadrada(@PathVariable(value = "numero1") String numero1) throws OperacaoNaoSuportadaException{
        if(!isNumeric(numero1)) {
            throw new OperacaoNaoSuportadaException("Favor inserir um valor numérico");
        }
        return Math.sqrt(Double.parseDouble(numero1)) ;
    }

    private boolean isNumeric(String numero) {
        if(numero == null) {
            return false;
        }
        return numero.replaceAll(",", ".").matches("[-+]?[0-9]*\\.?[0-9]+");
    }



}
