package br.com.mjv;

import br.com.mjv.modelo.*;
import br.com.mjv.modelo.validations.NaoEhPoupanca;
import br.com.mjv.modelo.validations.SaldoInsuficiente;
import br.com.mjv.modelo.validations.ContaInexistente;


public class Main {
    public static void main(String[] args) throws ContaInexistente, NaoEhPoupanca, SaldoInsuficiente {
        Cliente Antonio = new Cliente("Antonio");
        Cliente Jose = new Cliente("Jose");
        Cliente Francisco = new Cliente("Francisco");

        Conta correnteAntonio = new ContaCorrente(Antonio);
        Conta poupancaJose = new ContaPoupanca(Jose);
        Conta poupancaFrancisco = new ContaPoupanca(Francisco);


        correnteAntonio.depositar(100);
        poupancaJose.depositar(100);

        correnteAntonio.sacar(1);
        poupancaJose.sacar(1);

        Banco banco = new Banco();

        banco.incluir(correnteAntonio);
        banco.incluir(poupancaJose);
        banco.incluir(poupancaFrancisco);
        banco.deposito(poupancaFrancisco, 2000);
        banco.saque(poupancaFrancisco, 200);
        banco.transferir(poupancaJose, correnteAntonio,10);
        banco.saque(correnteAntonio, 50);



        System.out.println(banco.saldo(poupancaJose));
        banco.rendeJuros(poupancaJose, 5);
        System.out.println(banco.saldo(poupancaJose));

        banco.extrato(correnteAntonio);
        banco.extrato(poupancaFrancisco);
        banco.extrato(poupancaJose);


    }
}