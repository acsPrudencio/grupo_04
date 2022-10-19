
package br.com.mjv.model;

/**
 *
 * @author Evandro
 */
public class Pedido extends Cliente {
    
    private String  agua;
    private String luz;

    public String getAgua() {
        return agua;
    }

    public void setAgua(String agua) {
        this.agua = agua;
    }

    public String getLuz() {
        return luz;
    }

    public void setLuz(String luz) {
        this.luz = luz;
    }
    
}
