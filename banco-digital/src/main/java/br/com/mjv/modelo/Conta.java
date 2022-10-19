package br.com.mjv.modelo;

import br.com.mjv.interfaces.IConta;
import br.com.mjv.modelo.validations.SaldoInsuficiente;
import br.com.mjv.modelo.validations.ValorDepositarInvalido;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Extrato> extrato;
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
                throw new SaldoInsuficiente(this, valor);
            }
            saldo -= valor;
            adicionarAoExtrato("Debito: R$ " + valor + " Saldo: R$ " + this.getSaldo() + "\n");

        } catch (SaldoInsuficiente e) {
            System.out.println(e);
        }
    }


    public void depositar(double valor) throws ValorDepositarInvalido {

            if (valor <= 0) {
                throw new ValorDepositarInvalido();
            }
            saldo += valor;
            adicionarAoExtrato("Credito: R$ " + valor + " Saldo: R$ " + getSaldo() + "\n");

    }

    public void transferir(double valor, IConta contaDestino) throws SaldoInsuficiente, ValorDepositarInvalido {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {

    }


    protected void imprimirDadosDaConta() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println("Saldo: R$ " + this.getSaldo());
    }

    protected void adicionarAoExtrato(String movimentacao) {
        if (extrato == null){
            extrato = new ArrayList<>();
        }
        extrato.add(new Extrato(movimentacao, LocalDateTime.now()));
    }

    protected String consultarExtrato(LocalDate ld1, LocalDate ld2){
        String extr = "Cliente: " + this.cliente.getNome() +
                        "\nAgencia: " + this.getAgencia() +
                        ", Conta: " + this.getNumero() +
                        "\n";
        for (Extrato e: extrato){
            if((e.getData().toLocalDate().isAfter(ld1) || e.getData().toLocalDate().isEqual(ld1))
                    && (e.getData().toLocalDate().isBefore(ld2) || e.getData().toLocalDate().isEqual(ld2))){
                extr += e.getExtrato();
            }
        }
        return extr;
    }

}
