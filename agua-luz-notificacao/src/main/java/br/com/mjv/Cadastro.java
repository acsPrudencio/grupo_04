package br.com.mjv;

import java.time.LocalDate;
import java.util.List;

public class Cadastro extends Contrato{

    @Override
    public Servico getServico() {
        return super.getServico();
    }
    public double taxaServico(){
        double taxa;
       if(super.getServico()==Servico.AGUA){
          taxa = 137.21;
       }else{
           taxa = 132.15;
       }
        return taxa;
    }
    public String exibir(){
        String formatada = String.format("Senhor(a) %s cpf de número %s, Informamos " +
                "que conforme contrato com protocolo de número %s está \n agendado para a data\\hora" +
                " %s 16:00h a instalação do serviço de %s com taxa de valor %2f em sua" +
                " residência\n localizada no endereço abaixo:",getCliente().getNome(),getCliente().getCpf(),
                getProtocolo(),getDataHora().toString(),getServico(),taxaServico());
        return formatada;
    }
}
