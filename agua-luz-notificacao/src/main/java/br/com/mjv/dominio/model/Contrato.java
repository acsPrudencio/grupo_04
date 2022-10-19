package br.com.mjv.dominio.model;

import br.com.mjv.dominio.enums.TipoNotificaoEnum;
import br.com.mjv.dominio.enums.TipoServicoEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import static java.time.format.DateTimeFormatter.ofPattern;

/**
 *
 * @author Evandro
 */
public class Contrato {

    private Integer numeroDoContrato = +1;
    private String dataAgendamento;
    private String hora;
    private Cliente cliente;
    private TipoServicoEnum tipoServico;
    private BigDecimal valor;
    private TipoNotificaoEnum tipoNotificao;
    private String protocolo;


    public Contrato(TipoServicoEnum tipoServico, BigDecimal valor, String protocolo, String dataAgendamento, String hora, Cliente cliente) {
        this.protocolo = protocolo;
        this.dataAgendamento = dataAgendamento;
        this.hora = hora;
        this.tipoServico = tipoServico;
        this.valor = valor;
        this.cliente = cliente;
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

//    public Contrato(TipoServicoEnum tipoServico, BigDecimal valor, Cliente cliente) {
//        LocalDateTime agora = LocalDateTime.now();
//        this.protocolo = gerarNumeroProtocolo(agora);
//        this.dataAgendamento = LocalDate.from(agora);
//        this.hora = agora.format(ofPattern("HH:mm"));
//        this.tipoServico = tipoServico;
//        this.valor = valor;
//        this.cliente = cliente;
//    }



    private String gerarNumeroProtocolo(LocalDateTime agora){
        Random numAleatorio = new Random();
        return Integer.toString(numAleatorio.nextInt(9999999));
    }
   
 public Integer gerarProtocolo() {

        Random rd = new Random();
      
        rd.ints(0, 11);
      
       return rd.nextInt();
       
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public TipoServicoEnum getTipoServico() {
        return tipoServico;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TipoNotificaoEnum getTipoNotificao() {
        return tipoNotificao;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setTipoNotificao(TipoNotificaoEnum tipoNotificao) {
        this.tipoNotificao = tipoNotificao;
    }
}
