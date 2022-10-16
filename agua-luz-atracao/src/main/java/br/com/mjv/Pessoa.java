package br.com.mjv;

public class Pessoa {
    private String cpf;
    private String rg;
    private String nome;
    private String celular;

    public Pessoa(String cpf, String rg, String nome){
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
    }

    public void setNumeroCelular(String numero){
        this.celular = numero;
    }
}
