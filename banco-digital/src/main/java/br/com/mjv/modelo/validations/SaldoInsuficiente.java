package br.com.mjv.modelo.validations;

public class SaldoInsuficiente extends Exception {

    private static final long serialVersionUID = 1L;
    private int conta ;
    private double saldo ;
    public SaldoInsuficiente(int conta, double saldo) {
        super();
        this.conta = conta;
        this.saldo = saldo;
    }
    @Override
    public String toString() {
        return "A conta de número " + this.conta +
                " não possui saldo para a operação. "
                + "Saldo atual: " +this.saldo;
    }
}
