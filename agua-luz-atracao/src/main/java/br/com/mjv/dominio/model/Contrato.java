package br.com.mjv.dominio.model;

import br.com.mjv.dominio.enums.TipoNotificaoEnum;
import br.com.mjv.dominio.enums.TipoServicoEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Contrato {

    private String protocolo;
    private LocalDate dataAgendamento;
    private String hora;
    private TipoServicoEnum tipoServico;
    private BigDecimal valor;
    private TipoNotificaoEnum tipoNotificao;

    private Pessoa pessoa;

    public Contrato(TipoServicoEnum tipoServico, BigDecimal valor, Pessoa pessoa) {
        LocalDateTime agora = LocalDateTime.now();
        this.protocolo = gerarNumeroProtocolo(agora);
        this.dataAgendamento = LocalDate.from(agora);
        this.hora = agora.getHour() + ":" + agora.getMinute();
        this.tipoServico = tipoServico;
        this.valor = valor;
    }
    private String gerarNumeroProtocolo(LocalDateTime agora){
        Random numAleatorio = new Random(19700621);
        return LocalDate.from(agora).toString() + numAleatorio.nextInt();
    }

    public String getProtocolo() {
        return protocolo;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public String getHora() {
        return hora;
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

    public void setTipoNotificao(TipoNotificaoEnum tipoNotificao) {
        this.tipoNotificao = tipoNotificao;
    }
}
