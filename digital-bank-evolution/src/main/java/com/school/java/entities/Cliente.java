package com.school.java.entities;

import com.scholl.java.impl.funcoesBasicas;
import com.school.java.exeptions.ContaExceptions;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Evandro
 */
public class Cliente extends Banco implements funcoesBasicas {

    private String titular;
    private Integer agencia;
    private Long numeroDaConta;
    private Integer digito;
    private NomeDoBanco nomeDoBanco;
    private Double saldo;
    private String abertura;

    public Cliente(NomeDoBanco nomeDoBanco, String titular, Integer agencia, Long numeroDaConta, Integer digito, Double saldo, String abertura) {
        this.titular = titular;
        this.agencia = agencia;
        this.numeroDaConta = numeroDaConta;
        this.digito = digito;
        this.nomeDoBanco = nomeDoBanco;
        this.saldo = saldo;
        this.abertura = abertura;

    }

    public Cliente() {
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Long getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(Long numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public Integer getDigito() {
        return digito;
    }

    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    public NomeDoBanco getNomeDoBanco() {
        return nomeDoBanco;
    }

    public void setNomeDoBanco(NomeDoBanco nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getAbertura() {
        return abertura;
    }

    @Override
    public String toString() {
        return "\n Data de abertura: " + abertura + "\n Banco: " + nomeDoBanco + "\n Titular: " + titular
                + "\n Agencia: " + agencia
                + "\n Conta: " + numeroDaConta
                + "\n Digito: " + digito
                + "\n Saldo: R$ " + String.format("%.2f\n", saldo);
    }
    // Comparando se o titular e o numero da conta são iguais

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.titular);
        hash = 41 * hash + Objects.hashCode(this.numeroDaConta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.titular, other.titular)) {
            return false;
        }
        return Objects.equals(this.numeroDaConta, other.numeroDaConta);
    }

    @Override
    public void sacar(Cliente conta, Double value) {

        if (value.isNaN()) {
            System.out.println(" Digite apenas numero!");
        }
        if (value <= 0) {
            System.out.println(" Valor inválido, tente um valor meior!");

        }
        if (value > this.saldo) {
            System.out.println(" Valor inválido, tente um valor menor!");
            System.out.println(" Seu saldo atual é de R$ " + String.format("%.2f", this.getSaldo()));
        }
        saldo -= value;
        System.out.println(" Saque realizado por " + conta.getTitular() + " no valor de R$ " + String.format("%.2f", value));
    }

    @Override
    public void depositar(Cliente conta, Double value) {
        if (value.isNaN()) {
            System.out.println(" Digite apenas numero!");

        }
        if (value <= 0) {
            System.out.println(" Valor inválido, tente um valor meior!");

        }
        saldo += value;
        System.out.println( " Deposito realosado por "+this.getTitular() + " no valor de R$  "+ String.format("%.2f", value)+" na conta " + conta.getNumeroDaConta());
    }

    @Override
    public void tranferir(Cliente partida,Cliente destino, Double value) {
        if(partida.equals(destino)){
            System.out.println("Não é possivle tranferir para a mesma conta!");
        }
        if(value.isNaN()){
             System.out.println(" Digite apenas numero!");
        }
        if (value <= 0) {
            System.out.println(" Valor inválido, tente um valor meior!");

        }
        saldo -= value;
        System.out.println(" Valor tranferido com sucesso!");
        System.out.println(partida.getTitular()+" fez atransferência no valorl de R$ " +String.format("%.2f", value) + " para " + destino.getTitular());
        destino.depositar(destino,value);
        
    }
}
