package br.com.mjv.dominio.model;

public class Pessoa {
    private String cpf;
    private String rg;
    private String nome;
    private String celular;

    private Endereco endereco;

    public Pessoa(String cpf, String rg, String nome, Endereco endereco){
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
    }

    public void setNumeroCelular(String numero){
        this.celular = numero;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
