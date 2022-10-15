package br.com.mjv;

import java.time.LocalDateTime;

public abstract class Contrato {
    private Cliente cliente;
    private Endereco endereco;
    private String protocolo;
    private Servico servico;
    private LocalDateTime dataHora;


    public Contrato(){
        this.cliente = new Cliente();
        this.endereco = new Endereco();
    }
    public Cliente getCliente() {
        return cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }


    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }
}
