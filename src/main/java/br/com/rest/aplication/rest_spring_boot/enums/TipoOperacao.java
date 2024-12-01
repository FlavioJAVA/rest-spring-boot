package br.com.rest.aplication.rest_spring_boot.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum TipoOperacao {

    SOMAR(1, "Soma"),
    SUBTRAIR(2, "Subtrair"),
    MULTIPLICAR(3, "Multiplicar"),
    DIVIDIR(4, "Dividir"),
    CALCULARMEDIA(5, "Calcular Media"),
    CALCULAR_RAIZ_QUADRADA(6, "Calcular Raiz Quadrada");

    private int codigoOperacao;
    private String nomeOperacao;

    TipoOperacao(int codigoOperacao, String nomeOperacao) {
        this.codigoOperacao = codigoOperacao;
        this.nomeOperacao = nomeOperacao;
    }

    public Optional<TipoOperacao> obtemTipoOperacao(int codigoOperacao) {
        return Arrays.stream(TipoOperacao.values())
                .filter(status -> status.getCodigoOperacao() == codigoOperacao)
                .findFirst();
    }

    public static Optional<TipoOperacao> encontrarPorNome(String nome) {
        return Arrays.stream(TipoOperacao.values())
                .filter(status -> status.getNomeOperacao().equalsIgnoreCase(nome))
                .findFirst();
    }

    public static boolean isTipoOperacaoValido(int indexOperacao) {
        return indexOperacao > 0 && indexOperacao <= TipoOperacao.values().length;
    }
}
