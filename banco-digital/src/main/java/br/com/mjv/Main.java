package br.com.mjv;

import br.com.mjv.modelo.*;
import br.com.mjv.modelo.validations.NaoEhPoupanca;
import br.com.mjv.modelo.validations.SaldoInsuficiente;
import br.com.mjv.modelo.validations.ContaInexistente;
import br.com.mjv.modelo.validations.ValorDepositarInvalido;


public class Main {
    public static void main(String[] args) throws ContaInexistente, NaoEhPoupanca, SaldoInsuficiente, ValorDepositarInvalido {
        Cliente Antonio = new Cliente("Antonio");
        Cliente Jose = new Cliente("Jose");
        Cliente Francisco = new Cliente("Francisco");

        Conta correnteAntonio = new ContaCorrente(Antonio);
        Conta poupancaJose = new ContaPoupanca(Jose);
        Conta poupancaFrancisco = new ContaPoupanca(Francisco);

        Banco banco = new Banco();
        banco.incluir(correnteAntonio);
        banco.incluir(poupancaJose);
        banco.incluir(poupancaFrancisco);

        banco.deposito(correnteAntonio,50);
        banco.deposito(poupancaJose,100);
        banco.sacar(correnteAntonio,100);
        banco.sacar(poupancaJose,1);


        banco.deposito(poupancaFrancisco, 2000);
        banco.sacar(poupancaFrancisco, 200);
        banco.transferir(poupancaJose, correnteAntonio,10);
        banco.sacar(correnteAntonio, 50);



        System.out.println(banco.saldo(poupancaJose));
        banco.rendeJuros(poupancaJose, 5);
        System.out.println(banco.saldo(poupancaJose));
        banco.rendeJuros(correnteAntonio,6);
        banco.extrato(correnteAntonio);
        banco.extrato(poupancaFrancisco);
        banco.extrato(poupancaJose);


    }
}