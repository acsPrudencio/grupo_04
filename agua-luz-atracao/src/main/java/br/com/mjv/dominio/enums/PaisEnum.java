package br.com.mjv.dominio.enums;

public enum PaisEnum {
    BR("BRASIL"),
    US("ESTADOS UNIDOS"),
    FR("FRANÇA");

    private String descricao;

    PaisEnum(String descricao) {
        this.descricao = descricao;
    }
}
