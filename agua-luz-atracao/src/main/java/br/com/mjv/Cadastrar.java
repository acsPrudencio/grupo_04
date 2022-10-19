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
        stringBuilder.append(normalizarNumeros(contrato.getPessoa().getCpf(),11));
        stringBuilder.append(normalizarNumeros(contrato.getPessoa().getRg(),10));
        stringBuilder.append(normalizarNomes(contrato.getPessoa().getNome(), 30));
        stringBuilder.append(normalizarNumeros(contrato.getPessoa().getCelular(),11));
        stringBuilder.append(normalizarNomes(pessoa.getEndereco().getLogradouro(),20));
        stringBuilder.append(normalizarNumeros(pessoa.getEndereco().getNumero(),6));
        stringBuilder.append(normalizarNomes(pessoa.getEndereco().getComplemento(),10));
        stringBuilder.append(normalizarNomes(pessoa.getEndereco().getBairro(),15));
        stringBuilder.append(normalizarNomes(pessoa.getEndereco().getCidade(),30));
        stringBuilder.append(normalizarNomes(pessoa.getEndereco().getUF(),2));
        stringBuilder.append(normalizarNomes(pessoa.getEndereco().getCep(),8));
        stringBuilder.append(normalizarNomes(pessoa.getEndereco().getPais(),2));
        stringBuilder.append(normalizarNumeros(contrato.getProtocolo(),10));
        stringBuilder.append(normalizarNomes(contrato.getDataAgendamento().toString(),8));
        stringBuilder.append(normalizarNomes(contrato.getHora(),4));
        stringBuilder.append(normalizarNomes(contrato.getTipoServico(),1));
        stringBuilder.append(normalizarNumeros(contrato.getValor().setScale(2, RoundingMode.HALF_EVEN).toString(),8));
        stringBuilder.append(normalizarNomes(contrato.getTipoNotificao(),1));

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
    public static String normalizarNumeros(Object conteudo, int tamanho){
        Long textoNormalizado = Long.parseLong(conteudo.toString().replace(".","").replace("(","").replace(")","").replace("-","").replace("/","").replace(",","").replace(" ",""));
        return String.format("%0"+tamanho+"d",new Object[] { textoNormalizado });
    }
    public static String normalizarNomes(Object conteudo, int tamanho){
        int tamConteudo = conteudo.toString().length();
    String textoNormalizado = conteudo.toString().replace(":", "").replace("-", "").replace("/","").toUpperCase();
        if (tamanho > tamConteudo){
            textoNormalizado = textoNormalizado.substring(0,tamConteudo);
            int qtdZero = tamConteudo - tamanho;
            StringBuffer temp = new StringBuffer();
            for (int i = 0; i<qtdZero; i++){
                temp.append(" ");
            }
            return textoNormalizado + temp;
        }
        return textoNormalizado.substring(0,tamanho);
    }
}