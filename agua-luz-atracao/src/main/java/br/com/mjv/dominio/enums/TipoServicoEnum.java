package br.com.mjv.dominio.enums;


public enum TipoServicoEnum {

    AGUA("AGUA"),
    LUZ("LUZ");
    private String descricao;
    TipoServicoEnum(String descricao){
        this.descricao = descricao;
    }

}
