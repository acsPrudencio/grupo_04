package br.com.mjv.model;

/**
 *
 * @author Evandro
 */
public class Cliente {
    
    private Paises pais;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String rg;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }
    
    
    
    public String getRg() {
        return rg;
    }
    
    public void setRg(String rg) {
        this.rg = rg;
    }
    
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
                + "\n RG: " + rg
                + "\n CEP: " + cep
                + " \n País: " + pais;
    }
    
    public Paises siglaDoPais(String pais) {
        
        if (pais.equalsIgnoreCase("br")
                || pais.equalsIgnoreCase("bra")
                || pais.equalsIgnoreCase("brasil")) {
            return Paises.BRASIL;
        } else if (pais.equalsIgnoreCase("us")
                || pais.equalsIgnoreCase("usa")
                || pais.equalsIgnoreCase("estados unidos")) {
            return Paises.ESTADOS_UNIDOS;
        } else if (pais.equalsIgnoreCase("fr")
                || pais.equalsIgnoreCase("fra")
                || pais.equalsIgnoreCase("frança")) {
            return Paises.FRANÇA;
        }
        return Paises.SORRY_NOT_EXIST;
    }    
    
}
