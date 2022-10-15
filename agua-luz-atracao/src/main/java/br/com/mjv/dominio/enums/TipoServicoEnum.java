package br.com.mjv.dominio.enums;


public enum TipoServicoEnum {

    AGUA("água"),
    LUZ("luz");
    private String descricao;
    TipoServicoEnum(String descricao){
        this.descricao = descricao;
    }

}
