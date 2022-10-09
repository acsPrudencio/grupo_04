package br.com.mjv.modelo.validations;

public class ValorDepositarInvalido extends Exception {
    public ValorDepositarInvalido(double valor) {
        super("O valor de depósito deve ser superior a zero.");

    }
}


