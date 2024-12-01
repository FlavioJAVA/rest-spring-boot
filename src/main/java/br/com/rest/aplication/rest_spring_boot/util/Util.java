package br.com.rest.aplication.rest_spring_boot.util;

public class Util {

    public static boolean isNumeric(String numero) {
        if(numero == null) {
            return false;
        }
        return numero.replaceAll(",", ".").matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
