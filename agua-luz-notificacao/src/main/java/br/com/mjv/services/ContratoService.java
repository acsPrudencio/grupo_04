package br.com.mjv.services;

import br.com.mjv.model.Cliente;
import br.com.mjv.model.Contrato;
import br.com.mjv.model.Paises;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Evandro
 */
public class ContratoService {

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

    private String agua;
    private String luz;
    private Contrato contrato;
    private final Double taxBrasileira = 187.90;
    private final Double taxExtrageira = 2750.90;

    public Double getTaxBrasileira() {
        return taxBrasileira;
    }

    public Double getTaxExtrageira() {
        return taxExtrageira;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public String gerarContratoDeServico(Contrato contrato, Cliente cliente) {

        return " -------- Contrato de Serviço para o Pais " + cliente.getPais() + "\n Senhor(a) " + cliente.getNome()
                + " CPF: " + cliente.getCpf()
                + "\n Informamos que conforme contrato com protocolo  de numero " + contrato.getProtocolo()
                + "\n está agendado para a data " + contrato.getDate() + " hora " + contrato.getHora()
                + "\n A instalação do serviço de Agua com a taxa de valor R$ " + this.getAgua()
                + "\n em sua residencia localizada no endereço abaixo \n\n - Logradouro: " + cliente.getLogradouro()
                + "\n - Complemento: " + cliente.getComplemento()
                + "\n - Bairro: " + cliente.getBairro()
                + "\n - Cidade: " + cliente.getCidade()
                + "\n - Cep: " + cliente.getCep();
    }
//        } else {
//
//            return " -------- Contrato de Serviço para o Pais " + cliente.getPais() + "\n Mr(s) " + cliente.getNome()
//                    + " CPF: " + cliente.getCpf()
//                    + "\n We inform you that according to the contract with protocol number " + contrato.getProtocolo()
//                    + "\n is scheduled for date " + dataTime.toLocalDate() + " time " + dataTime.toLocalTime().plusHours(-1L)
//                    + "\n the installation of the Water service with the value rate $ " + this.getAgua()
//                    + "   Energy $ " + this.getLuz()
//                    + "\n at your residence located at the address below\n\n - Public place: " + cliente.getLogradouro()
//                    + "\n - Complement: " + cliente.getComplemento()
//                    + "\n - Neighborhood: " + cliente.getBairro()
//                    + "\n - City: " + cliente.getCidade()
//                    + "\n - Zip code: " + cliente.getCep();
//        }

}
