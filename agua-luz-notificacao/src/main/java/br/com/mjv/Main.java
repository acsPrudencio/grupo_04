package br.com.mjv;

import br.com.mjv.dominio.enums.PaisEnum;
import br.com.mjv.dominio.enums.TipoNotificaoEnum;
import br.com.mjv.dominio.enums.TipoServicoEnum;
import br.com.mjv.dominio.enums.UfEnum;
import br.com.mjv.dominio.model.Cliente;
import br.com.mjv.dominio.model.Contrato;
import br.com.mjv.dominio.model.Endereco;

import java.io.*;
import java.math.BigDecimal;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        String conteudoArquivo = lerArquivo("../agua-luz-atracao/agua-luz-contratos.txt");
        Endereco endereco = new Endereco();
        endereco.setLogradouro(conteudoArquivo.substring(62,82));
        endereco.setNumero(removerZeroEsquerda(conteudoArquivo.substring(82,88)));
        endereco.setComplemento(conteudoArquivo.substring(88,98));
        endereco.setBairro(conteudoArquivo.substring(98,113));
        endereco.setCidade(conteudoArquivo.substring(113,143).trim());
        endereco.setUF(UfEnum.valueOf(conteudoArquivo.substring(143,145)));
        endereco.setCep(formatarCEP(conteudoArquivo.substring(145,153)));
        endereco.setPais(PaisEnum.valueOf(conteudoArquivo.substring(153,155)));

        Cliente pessoa = new Cliente(formatarCPF(conteudoArquivo.substring(0,11)), conteudoArquivo.substring(11,21), conteudoArquivo.substring(21,51), endereco);
        pessoa.setTelefone(conteudoArquivo.substring(51,62));
        TipoServicoEnum tipoServico;
        if (conteudoArquivo.substring(177,178).equalsIgnoreCase("A")){
            tipoServico = TipoServicoEnum.valueOf("AGUA");
        }else {
            tipoServico = TipoServicoEnum.valueOf("LUZ");
        }


        Contrato contrato = new Contrato(tipoServico, new BigDecimal(formatarValor(conteudoArquivo.substring(178,186))), removerZeroEsquerda(conteudoArquivo.substring(155,165)), conteudoArquivo.substring(165,173), formatarHora(conteudoArquivo.substring(173,177)),pessoa);

        TipoNotificaoEnum tipoNotificao;
        if (conteudoArquivo.substring(186,187).equalsIgnoreCase("S")){
            tipoNotificao = TipoNotificaoEnum.valueOf("SMS");
        }else {
            tipoNotificao = TipoNotificaoEnum.valueOf("WHATS");
        }
        contrato.setTipoNotificao(tipoNotificao);


        String mensagem = "Senhor(a) "
                + contrato.getCliente().getNome() + " cpf de número "
                + contrato.getCliente().getCpf() + ", Informamos que conforme contrato com protocolo de número "
                + contrato.getProtocolo() + " está agendado para a data\\hora "
                + contrato.getHora() + "h a instalação do serviço de "
                + contrato.getTipoServico() + " com taxa de valor R$ "
                + contrato.getValor() + " em sua residência localizada no endereço abaixo:\n";

        String enderecoCliente =
                " - Logradouro: " + contrato.getCliente().getEndereco().getLogradouro() +
                        ", " + contrato.getCliente().getEndereco().getNumero() +
                        "\n - Complemento: " + contrato.getCliente().getEndereco().getComplemento() +
                        "\n - Bairro: " + contrato.getCliente().getEndereco().getBairro() +
                        "\n - Cidade: " + contrato.getCliente().getEndereco().getCidade() +
                        " / " + contrato.getCliente().getEndereco().getUF() +
                        "\n - Cep: " + contrato.getCliente().getEndereco().getCep();

        System.out.println(mensagem + enderecoCliente);

    }

    public static String removerZeroEsquerda(String conteudo){
            int i = 0;
            while (i < conteudo.length() && conteudo.charAt(i) == '0'){
                i++;
            }

            StringBuffer sb = new StringBuffer(conteudo);
            sb.replace(0, i, "");
            return sb.toString();
    }

    public static String lerArquivo(String caminhoArquivo) throws IOException {
        FileInputStream stream = new FileInputStream(caminhoArquivo);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        return br.readLine();
    }

    public static String formatarCEP(String conteudo){
        StringBuffer stringBuffer = new StringBuffer(conteudo);
        stringBuffer.insert(2, ".");
        stringBuffer.insert(6, ".");
        return stringBuffer.toString();
    }

    public static String formatarCPF(String conteudo){
        StringBuffer stringBuffer = new StringBuffer(conteudo);
        stringBuffer.insert(3, ".");
        stringBuffer.insert(7, ".");
        stringBuffer.insert(11, "-");
        return stringBuffer.toString();
    }
    public static String formatarHora(String conteudo){
        StringBuffer stringBuffer = new StringBuffer(conteudo);
        stringBuffer.insert(2, ":");
        return stringBuffer.toString();
    }
    public static String formatarValor(String conteudo){
        StringBuffer stringBuffer = new StringBuffer(conteudo);
        stringBuffer.insert(stringBuffer.length()-2, ".");
        return stringBuffer.toString();
    }
}