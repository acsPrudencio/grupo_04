package br.com.mjv;

public enum Paises {
    BRASIL("BR"),
    ESTADOS_UNIDOS("US"),
    FRANÇA("FR");

    private String sigla;
    private Paises(String sigla){
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }
}
