package br.com.mjv.modelo.validations;

public class ValorDepositarInvalido extends Exception {
    public ValorDepositarInvalido() {
        super();

    }
    @Override
    public String toString() {
        return "O valor de depósito deve ser superior a zero.";
    }
}


