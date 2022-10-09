package br.com.mjv.modelo.validations;

import br.com.mjv.modelo.Conta;

public class NaoEhPoupanca extends Exception{
    private Conta conta;
    private static final long serialVersionUID = 1L;
    public NaoEhPoupanca(Conta conta) {
        super();
        this.conta = conta;
    }

    @Override
    public String toString() {
        return  conta.getCliente().getNome() + " a sua conta de número: " + conta.getNumero() +
                ", não eh do tipo poupanca, e por isso ela não rende juros.";
    }
}
