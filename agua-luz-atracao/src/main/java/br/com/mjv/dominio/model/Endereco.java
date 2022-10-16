package br.com.mjv.dominio.model;

public class Endereco {
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String pais;

    public enum UF {
        RO("Rondônia"), AC("Acre"), AM("Amazonas"), RR("Roraima"), PA("Pará"), AP("Amapá"), TO("Tocantins"),
        MA("Maranhão"), PI("Piauí"), CE("Ceará"), RN("Rio Grande do Norte"), PB("Paraíba"), PE("Pernambuco"),
        AL("Alagoas"), SE("Sergipe"), BA("Bahia"), MG("Minas Gerais"), ES("Espírito Santo"), RJ("Rio de Janeiro"),
        SP("São Paulo"), PR("Paraná"), SC("Santa Catarina"), RS("Rio Grande do Sul"), MS("Mato Grosso do Sul"),
        MT("Mato Grosso"), GO("Goiânia"), DF("Distrito Federal");

        private String descricao;

        UF(String descricao) {
            this.descricao = descricao;
        }
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
