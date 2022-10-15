package br.com.mjv.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

/**
 *
 * @author Evandro
 */
public class Contrato {

    private Integer numeroDoContrato = +1;
    private String date;
    private String hora;
    private Cliente cliente;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Contrato() {
    }

    public Integer getNumeroDoContrato() {
        return numeroDoContrato;
    }

   
 public Integer gerarProtocolo() {

        Random rd = new Random();
      
        rd.ints(0, 11);
      
       return rd.nextInt();
       
    }
}
