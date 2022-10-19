package br.com.mjv.dominio.model;

/**
 *
 * @author Evandro
 */
public class Cliente {
    private String nome;
    private String telefone;
    private String cpf;
    private String rg;
    private Endereco endereco;


    public Cliente(String cpf, String rg, String nome, Endereco endereco){
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.endereco = endereco;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Paises siglaPais(String sigla) {

        switch (sigla) {
            case "br": {
                return Paises.BRASIL;

            }
            case "us": {
                return Paises.ESTADOS_UNIDOS;

            }
            case "fr": {
                return Paises.FRANÇA;
            }
            case " uk ": {
                return Paises.INGLATERRA;
            }

            default: {
                return null;
            }
        }
    }

}
