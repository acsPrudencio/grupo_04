package br.com.mjv.dominio.enums;


public enum TipoServicoEnum {

    AGUA("Água"),
    LUZ("Luz");
    private String descricao;
    TipoServicoEnum(String descricao){
        this.descricao = descricao;
    }


}
