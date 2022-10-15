package br.com.mjv.model;

/**
 *
 * @author Evandro
 */
public class Cliente {

    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;

   
    public Cliente() {
    }

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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
 @Override
    public String toString() {
        return "\n Nome: " + nome 
                + "\n email: " + email 
                + "\n Telefone: " + telefone 
                + "\n CPF: " + cpf 
                + "\n CEP: " + cep;
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
