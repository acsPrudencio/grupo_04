package br.com.mjv.interfaces;

import br.com.mjv.modelo.validations.SaldoInsuficiente;

public interface IConta {

    void sacar(double valor) throws SaldoInsuficiente;

    void depositar(double valor);

    void transferir(double valor, IConta contaDestino) throws SaldoInsuficiente;

    void imprimirExtrato();
}
