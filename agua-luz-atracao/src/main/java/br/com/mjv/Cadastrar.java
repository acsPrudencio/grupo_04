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
import java.util.Random;

public class Cadastrar {
    public static void main(String[] args) {

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



    }
    public void gravarNoArquivo(String conteudo) throws IOException {
        OutputStream os = new FileOutputStream("agua-luz-contratos.txt"); // nome do arquivo que será escrito
        Writer wr = new OutputStreamWriter(os);
        BufferedWriter br = new BufferedWriter(wr);

        br.write(conteudo);
        br.newLine();
        br.close();
    }
}