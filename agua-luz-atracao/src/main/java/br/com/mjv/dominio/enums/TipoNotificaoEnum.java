package br.com.mjv.dominio.enums;


public enum TipoNotificaoEnum {

    SMS("sms"),
    WHATS("WhatsApp");
    private String descricao;
    TipoNotificaoEnum(String descricao){
        this.descricao = descricao;
    }

}
