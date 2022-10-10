package com.school.java.application;

import com.school.java.entities.Banco;
import com.school.java.entities.Cliente;
import com.school.java.entities.ContaCorrente;
import com.school.java.entities.ContaPoupanca;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Evandro
 */
public class ApplicatioConta {

    public static void main(String[] args) {

        Banco banco = new Banco();
        LocalDateTime date = LocalDateTime.now();
        String hoje = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        //Abrindo Contas 
        Cliente evandroContaCorrente = new ContaCorrente(banco.qualSeuBanco(237), "Evandro", 2271, 1004917L, 2, 0.0, hoje);
        Cliente mariaContaPoupanca = new ContaPoupanca(banco.qualSeuBanco(033), "Maria", 1245, 254448L, 9, 0.0, hoje);

        // Adicionando as contas na lista do Banco
        List<Cliente> contasPoupanca = new ArrayList<>();
        List<Cliente> contasCorrente = new ArrayList<>();
        contasPoupanca.add(mariaContaPoupanca);
        contasCorrente.add(evandroContaCorrente);

        // Imprimindo os estratos das conta
        System.out.println("============ Exibindo abertura de contas ============ ");
        System.out.println("\n Estrato das contas");
        banco.estratoContaCorrente(contasCorrente);
        banco.estratoContaPoupanca(contasPoupanca);
        System.out.println("=========== Realizando depositos ============ \n");
        

        //Realizando depositos 
        evandroContaCorrente.depositar(evandroContaCorrente,2210.5);
        mariaContaPoupanca.depositar(mariaContaPoupanca,4512.20);
        System.out.println("\n Estrato das contas");
        banco.estratoContaCorrente(contasCorrente);
        System.out.println("---------------------------");
        banco.estratoContaPoupanca(contasPoupanca);
        

        //Realizando saque das contas
        evandroContaCorrente.sacar(evandroContaCorrente,210.5);
        mariaContaPoupanca.sacar(mariaContaPoupanca,512.20);
          System.out.println("============ Realizando saques ============");
        // imprimindo o estrato
        System.out.println("\n Estrato das contas");
        banco.estratoContaCorrente(contasCorrente);
        System.out.println("---------------------------");
        banco.estratoContaPoupanca(contasPoupanca);
        

        //Realizando tranferencia do Evando para a Maria novalor de R$ 1000,00
        evandroContaCorrente.tranferir(evandroContaCorrente,mariaContaPoupanca, 1000.00);
         System.out.println("============ Realizando transferências  ============");
        // imprimindo o estrato
        System.out.println("\n Estrato das contas");
        banco.estratoContaCorrente(contasCorrente);
        System.out.println("---------------------------");
        banco.estratoContaPoupanca(contasPoupanca);
    }

}
