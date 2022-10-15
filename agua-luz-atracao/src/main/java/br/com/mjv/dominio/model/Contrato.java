package br.com.mjv.dominio.model;

import br.com.mjv.dominio.enums.TipoServicoEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Contrato {

    private String protocolo;
    private LocalDate dataAgendamento;
    private String hora;
    private TipoServicoEnum tipoServico;
    private BigDecimal valor;
}
