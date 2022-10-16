package br.com.mjv.dominio.enums;


public enum TipoNotificaoEnum {

    SMS("SMS"),
    WHATS("WHATS");
    private String descricao;
    TipoNotificaoEnum(String descricao){
        this.descricao = descricao;
    }

}
