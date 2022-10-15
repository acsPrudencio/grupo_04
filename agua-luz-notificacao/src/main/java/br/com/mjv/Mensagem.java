package br.com.mjv;

public enum Mensagem {
    SMS("S"),
    WHAT("W");

    private String sigla;
    private Mensagem(String sigla){
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }

}
