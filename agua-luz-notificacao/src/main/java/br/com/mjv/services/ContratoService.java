package br.com.mjv.services;

import br.com.mjv.dominio.model.Cliente;
import br.com.mjv.dominio.model.Contrato;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Evandro
 */
public class ContratoService {

    private final Double agua = 137.21;
    private final Double luz = 132.15;
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

    public Double getAgua() {
        return agua;
    }

    public Double getLuz() {
        return luz;
    }

    public String taxaDeSericoPorPais(String siglaPais) {

        String tipo = null;
        if (siglaPais.isEmpty() || siglaPais.isBlank()) {

            tipo = "Error, Country is field empty !";
        }

        if (siglaPais.equalsIgnoreCase("bra") || siglaPais.equalsIgnoreCase("br")) {
            tipo = " Valor da taxa de seviço mas a taxa de instalação e de R$ " + String.format("%.2f", taxBrasileira);
        }
        if (siglaPais.equalsIgnoreCase("usa") || siglaPais.equalsIgnoreCase("us")) {
            tipo = " Service fee plus installation fee is $ " + String.format(Locale.US, "%.2f", (taxExtrageira * 5.33)); //Dollar
        }
        if (siglaPais.equalsIgnoreCase("fra") || siglaPais.equalsIgnoreCase("fr")) {
            tipo = " Montant des frais de service plus les frais d'installation et € " + String.format(Locale.FRANCE, "%.2f", (taxExtrageira * 5.18));//Euro
        }
        return tipo;
    }

    public String gerarContratoDeServico(Cliente cliente, String siglaDoPais) {
        Contrato contrato = new Contrato();
        LocalDateTime dataTime = LocalDateTime.now();
        Double total = 0.0;
        if (siglaDoPais.equalsIgnoreCase("bra") || siglaDoPais.equalsIgnoreCase("br")) {

            String hora = dataTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss "));

            contrato.setHora(hora);
            
            total = ((this.agua + this.luz) + this.taxBrasileira);
            return " -------- Contrato de Serviço para o Pais " + cliente.siglaPais(siglaDoPais) + "\n Senhor(a) " + cliente.getNome()
                    + " CPF: " + cliente.getCpf()
                    + "\n Informamos que conforme contrato com protocolo  de numero " + contrato.gerarProtocolo()
                    + "\n está agendado para a data " + contrato.getDataAgendamento() + " hora " + contrato.getHora()
                    + "\n A instalação do serviço de Agua com a taxa de valor R$ " + this.getAgua()
                    + " Energia R$ " + this.getLuz()
                    + "\n Taxa de instalação R$ " + taxaDeSericoPorPais(siglaDoPais)
                    + "\n Gereando um valor total de R$ " + total
                    + "\n em sua residencia localizada no endereço abaixo \n\n - Logradouro: " + cliente.getEndereco().getLogradouro()
                    + "\n - Complemento: " + cliente.getEndereco().getComplemento()
                    + "\n - Bairro: " + cliente.getEndereco().getBairro()
                    + "\n - Cidade: " + cliente.getEndereco().getCidade()
                    + "\n - Cep: " + cliente.getEndereco().getCep();
        } else {
            total = ((this.agua + this.luz) + this.taxExtrageira);
            return " -------- Contrato de Serviço para o Pais " + cliente.siglaPais(siglaDoPais) + "\n Mr(s) " + cliente.getNome()
                    + " CPF: " + cliente.getCpf()
                    + "\n We inform you that according to the contract with protocol number " + contrato.gerarProtocolo()
                    + "\n is scheduled for date " + dataTime.toLocalDate() + " time " + dataTime.toLocalTime().plusHours(-1L)
                    + "\n the installation of the Water service with the value rate $ " + this.getAgua()
                    + "   Energy $ " + this.getLuz()
                    + "\n installation fee $ " + taxaDeSericoPorPais(siglaDoPais)
                    + "\n generatin total value $ " + total
                    + "\n at your residence located at the address below\n\n - Public place: " + cliente.getEndereco().getLogradouro()
                    + "\n - Complement: " + cliente.getEndereco().getComplemento()
                    + "\n - Neighborhood: " + cliente.getEndereco().getBairro()
                    + "\n - City: " + cliente.getEndereco().getCidade()
                    + "\n - Zip code: " + cliente.getEndereco().getCep();
        }

    }

}
