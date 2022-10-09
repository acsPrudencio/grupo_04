package br.com.mjv.modelo.validations;

import br.com.mjv.modelo.Conta;

public class DataInvalida extends Exception {

    private static final long serialVersionUID = 1L;
    private Conta conta;
    public DataInvalida(Conta conta) {
        super();
        this.conta = conta;
    }

    @Override
    public String toString() {
        return  conta.getCliente().getNome() + " não foi possível consultar o extrato da sua conta de número: " + conta.getNumero() + ", pois a data final deve ser maior que a data inicial";
    }
}
