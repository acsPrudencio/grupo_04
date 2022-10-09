package br.com.mjv.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.mjv.modelo.validations.NaoEhPoupanca;
import br.com.mjv.modelo.validations.SaldoInsuficiente;
import br.com.mjv.modelo.validations.ValorDepositarInvalido;
import lombok.Data;
import br.com.mjv.modelo.validations.ContaInexistente;


@Data
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
        for (Conta c : contas) {
            if (c.getNumero() == conta.getNumero()) {
                return c;
            }
        }
        throw new ContaInexistente(conta.getNumero());
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