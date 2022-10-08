package br.com.mjv.modelo;

import br.com.mjv.interfaces.IConta;
import br.com.mjv.modelo.validations.SaldoInsuficiente;
import lombok.Data;

@Data
public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected String extrato = "";
    protected boolean statusConta;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.statusConta = true;
    }

    public void sacar(double valor) throws SaldoInsuficiente {
        try {
            if (valor > getSaldo()) {
                throw new SaldoInsuficiente(numero, getSaldo());
            }
            saldo -= valor;
            extrato = extrato + "Debito: R$ " + valor + " Saldo: R$ " + getSaldo() + "\n";

        } catch (SaldoInsuficiente e) {
            throw new SaldoInsuficiente(numero, getSaldo());
        }
    }

    public boolean cancelarConta(String justificativa){
        if (justificativa.isEmpty() || justificativa.isBlank()){
            this.statusConta = false;
            return true;
        }
        return false;
    }

    public void depositar(double valor) {
        saldo += valor;
        extrato = extrato + "Credito: R$ " + valor + " Saldo: R$ " + getSaldo() + "\n";
    }

    public void transferir(double valor, IConta contaDestino) throws SaldoInsuficiente {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public abstract void imprimirExtrato();

    protected void imprimirDadosDaConta() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println("Movimentacao:");

        if (extrato.isEmpty()) {
            System.out.println("Saldo: R$ " + this.getSaldo());
        } else {
            System.out.println(extrato);
        }
    }
}