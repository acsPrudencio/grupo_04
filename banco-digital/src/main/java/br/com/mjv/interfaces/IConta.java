package br.com.mjv.interfaces;

import br.com.mjv.modelo.validations.SaldoInsuficiente;
import br.com.mjv.modelo.validations.ValorDepositarInvalido;

public interface IConta {

    void sacar(double valor) throws SaldoInsuficiente;

    void depositar(double valor) throws ValorDepositarInvalido;

    void transferir(double valor, IConta contaDestino) throws SaldoInsuficiente, ValorDepositarInvalido;

    void imprimirExtrato();
}
