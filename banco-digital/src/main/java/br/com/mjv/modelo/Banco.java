package br.com.mjv.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.mjv.modelo.validations.*;
import lombok.Data;
import lombok.Getter;


@Getter
public class Banco {

    private String nome;
    private List<Conta> contas = new ArrayList<Conta>();

    public void incluir(Conta conta) throws ContaInexistente {
        if (conta == null) {
            throw new ContaInexistente();
        } else {
            contas.add(conta);
        }
    }

    public double saldo(Conta conta) throws ContaInexistente {
        Conta c = null;
        c = pesquisarConta(conta);
        return c.getSaldo();
    }

    public void sacar(Conta conta, double value) throws ContaInexistente, SaldoInsuficiente {
        Conta c = null;
        c = pesquisarConta(conta);
        c.sacar(value);

    }

    public void deposito(Conta conta, double value) throws ContaInexistente, ValorDepositarInvalido {

        Conta c = null;
        c = pesquisarConta(conta);
        c.depositar(value);

    }

    public Conta pesquisarConta(Conta conta) throws ContaInexistente {
        try {
            for (Conta c : contas) {
                if (c.getNumero() == conta.getNumero()) {
                    return c;
                }
            }
            throw new ContaInexistente(conta.getNumero());
        }catch (ContaInexistente e){
            System.out.println(e);
        }
        return null;
    }

    public String consultarExtrato(Conta conta, LocalDate ld1, LocalDate ld2) throws ContaInexistente, DataInvalida {
        Conta c = null;
        try{
            if(ld1.isAfter(ld2)){
                throw new DataInvalida(conta);
            }

            c = pesquisarConta(conta);
            return c.consultarExtrato(ld1, ld2);
        }catch (DataInvalida e){
            System.out.println(e);
        }
       return "";
    }
    public void rendeJuros(Conta conta, double t) throws ContaInexistente, NaoEhPoupanca {
        Conta c = null;
        c = pesquisarConta(conta);

        try {
            if (c.getClass().getSimpleName() == ContaCorrente.class.getSimpleName()){
                throw new NaoEhPoupanca(c);
            }
            ((ContaPoupanca) c).renderJuros(t);
        } catch (NaoEhPoupanca e) {
            System.out.println(e);
        } catch (ValorDepositarInvalido e) {
            System.out.println(e.toString());
        }
    }

    public void extrato(Conta n) throws ContaInexistente {
        Conta c = pesquisarConta(n);
        c.imprimirDadosDaConta();
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, double valor)
            throws ContaInexistente, SaldoInsuficiente, ValorDepositarInvalido {
        Conta c1, c2 = null;

        c1 = pesquisarConta(contaOrigem);
        c1.sacar(valor);
        c2 = pesquisarConta(contaDestino);
        c2.depositar(valor);

    }

    public boolean cancelarConta(Conta conta,String justificativa){
        if (!(justificativa.isEmpty() || justificativa.isBlank())){
            conta.statusConta = false;
            return true;
        }
        return false;
    }
}