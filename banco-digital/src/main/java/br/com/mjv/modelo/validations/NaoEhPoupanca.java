package br.com.mjv.modelo.validations;

public class NaoEhPoupanca extends Exception{
    private static final long serialVersionUID = 1L;
    public NaoEhPoupanca(int n) {
        super("A conta de numero "
                + n
                + " nao e poupanca");
    }
}
