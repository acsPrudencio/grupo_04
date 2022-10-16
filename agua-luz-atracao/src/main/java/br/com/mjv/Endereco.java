package br.com.mjv;

import br.com.mjv.dominio.enums.PaisEnum;
import br.com.mjv.dominio.enums.UfEnum;

public class Endereco {
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private PaisEnum pais;
    private UfEnum UF;
    private String logradouro;


    public UfEnum getUF() {
        return UF;
    }

    public void setUF(UfEnum UF) {
        this.UF = UF;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public PaisEnum getPais() {
        return pais;
    }

    public void setPais(PaisEnum pais) {
        this.pais = pais;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
