package br.com.mjv;

import br.com.mjv.dominio.enums.PaisEnum;
import br.com.mjv.dominio.enums.TipoNotificaoEnum;
import br.com.mjv.dominio.enums.TipoServicoEnum;
import br.com.mjv.dominio.enums.UfEnum;
import br.com.mjv.dominio.model.Contrato;
import br.com.mjv.dominio.model.Endereco;
import br.com.mjv.dominio.model.Pessoa;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Cadastrar {
    public static void main(String[] args) throws IOException {

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Sebastião Firmino");
        endereco.setNumero("123");
        endereco.setComplemento("AP 210 BL CENTAURO");
        endereco.setBairro("São Sebastião");
        endereco.setCidade("São Raimundo Nonato");
        endereco.setUF(UfEnum.SP);
        endereco.setCep("07.210.715");
        endereco.setPais(PaisEnum.BR);

        Pessoa pessoa = new Pessoa("007.324.223.21", "33765-5", "Raimundo Nonato Loureiro Castelo Branco", endereco);
        pessoa.setNumeroCelular("(11) 99768-1515");


        Contrato contrato = new Contrato(TipoServicoEnum.AGUA, new BigDecimal(127.35), pessoa);

        Random random = new Random();

        if (random.nextInt() % 2 == 0){
            contrato.setTipoNotificao(TipoNotificaoEnum.SMS);
        }else {
            contrato.setTipoNotificao(TipoNotificaoEnum.WHATS);
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(contrato.getPessoa().getCpf());
        stringBuilder.append(contrato.getPessoa().getRg());
        stringBuilder.append(contrato.getPessoa().getNome());
        stringBuilder.append(contrato.getPessoa().getCelular());
        stringBuilder.append(pessoa.getEndereco().getLogradouro());
        stringBuilder.append(pessoa.getEndereco().getNumero());
        stringBuilder.append(pessoa.getEndereco().getComplemento());
        stringBuilder.append(pessoa.getEndereco().getBairro());
        stringBuilder.append(pessoa.getEndereco().getCidade());
        stringBuilder.append(pessoa.getEndereco().getUF());
        stringBuilder.append(pessoa.getEndereco().getCep());
        stringBuilder.append(pessoa.getEndereco().getPais());
        stringBuilder.append(contrato.getProtocolo());
        stringBuilder.append(contrato.getDataAgendamento().toString().replace("-","/"));
        stringBuilder.append(contrato.getHora());
        stringBuilder.append(contrato.getTipoServico());
        stringBuilder.append(contrato.getValor().setScale(2, RoundingMode.HALF_EVEN));
        stringBuilder.append(contrato.getTipoNotificao());

        String retornoDaGravacao = gravarNoArquivo(stringBuilder.toString());
        System.out.println(retornoDaGravacao);

    }
    public static String gravarNoArquivo(String conteudo) throws IOException {
        OutputStream os = new FileOutputStream("agua-luz-contratos.txt"); // nome do arquivo que será escrito
        Writer wr = new OutputStreamWriter(os);
        BufferedWriter br = new BufferedWriter(wr);

        br.write(conteudo);
        br.newLine();
        br.close();
        return "As informações foram salvas no arquivo com sucesso!";
    }
}