
package br.com.mjv.model;

/**
 *
 * @author Evandro
 */
public enum Paises {
    SORRY_NOT_EXIST("NOT_EXIST"),
    BRASIL("BRASIL"),
    ESTADOS_UNIDOS("ESTADO_UNIDO"),
    FRANÇA("FRANCA");
  
    private String descricao;
    
    Paises(String descricao){
        this.descricao = descricao;
    }
   
}
