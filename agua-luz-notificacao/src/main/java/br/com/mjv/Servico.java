package br.com.mjv;

public enum Servico {
    AGUA("A"),
    LUZ("L");

    private String sigla;
    private Servico(String sigla){
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }

}
