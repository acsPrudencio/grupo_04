package br.com.mjv.modelo.validations;

import br.com.mjv.modelo.Conta;

public class SaldoInsuficiente extends Exception {

    private static final long serialVersionUID = 1L;
    private Conta conta ;
    private double valor ;
    public SaldoInsuficiente(Conta conta, double valor) {
        super();
        this.conta = conta;
        this.valor = valor;
    }
    @Override
    public String toString() {
        return conta.getCliente().getNome() + " o saque no valor de: " + this.valor +
                " não foi realizado, pois o saldo é insuficiente. \n"
                + "Saldo atual: " + this.conta.getSaldo();
    }
}
