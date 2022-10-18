package br.com.mjv;

import br.com.mjv.modelo.*;
import br.com.mjv.modelo.validations.*;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) throws ContaInexistente, NaoEhPoupanca, SaldoInsuficiente, ValorDepositarInvalido, DataInvalida {
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



        banco.rendeJuros(poupancaJose, 5);
        banco.rendeJuros(correnteAntonio,6);
        String extratopoupancaFrancisco = banco.consultarExtrato(poupancaFrancisco, LocalDate.now(), LocalDate.now().plusDays(-1));
        String extratopoupancaJose = banco.consultarExtrato(poupancaJose, LocalDate.now(), LocalDate.now());
        String extratoCorrenteAntonio = banco.consultarExtrato(correnteAntonio, LocalDate.now(), LocalDate.now().plusDays(-1));

        System.out.println(extratoCorrenteAntonio);
        System.out.println(extratopoupancaJose);
        System.out.println(extratopoupancaFrancisco);

    }
}