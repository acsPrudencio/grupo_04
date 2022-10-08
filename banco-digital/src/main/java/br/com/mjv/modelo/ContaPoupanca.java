package br.com.mjv.modelo;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente){
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupanca ===");
        super.imprimirDadosDaConta();
    }

    public void renderJuros(double taxa) {
        extrato += "Rendimento Juros R$ "+ getSaldo() * (taxa/100) +" \n";
        depositar(getSaldo() * (taxa/100));
    }
}
