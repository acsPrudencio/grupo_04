package br.com.mjv.controllers;

import br.com.mjv.model.Cliente;
import br.com.mjv.model.Contrato;
import br.com.mjv.model.Paises;
import br.com.mjv.services.ContratoService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {


        // System.out.println(s.gerarContratoDeServico(cl, "us"));
        // Passando o caminho e o nome do arquivo
        String stringPath = "C:\\Users\\User\\Documents\\NetBeansProjects\\agua-luz-contratos.txt";
        Path path = Path.of(stringPath);
        //  List<Cliente> contratos = new ArrayList<>();
        //contratos.add(cl);

        readerFile(path);
        
        // String path = "C:\\Users\\Evandro\\Documents\\files\\contrato.txt";
        // File fileName = new File(path, "contrato.txt");
        // writeFile(fileName, contratos);

        //writeFile(fileName, bancoEvandro.getContas());
    }
    // Escrever uma lista de arquivos passando o nome e a lista de arquivos

//    public static void writeFile(File fileName, List<Cliente> contratos) {
//
//        // verificando se a lista de controtos não está vazia
//        if (contratos.isEmpty()) {
//            System.out.println("The list is empty! ");
//            return;
//        }
//        // verificando se o arquivo existe!
//        if (!fileName.exists()) {
//            System.out.println("file not found! ");
//            return;
//        }
//
//        // Passando o Cherset por nome // tem outras forma como StandardCharsets.UTF_8
//        try ( FileWriter fw = new FileWriter(fileName,
//                Charset.forName("UTF-8"));  BufferedWriter br = new BufferedWriter(fw)) {
//
//            for (Cliente cotrato : contratos) {
//
//                // passando a lista de contas pelo método append() e retornando o toString() dos contratos
//                br.append(cotrato.getNome());
//                br.newLine();
//            }
//            System.out.println("Arquivo escrito! ");
//
//        } catch (IOException e) {
//            System.out.println("Errot: file not found! " + e.getMessage());
//        }

//    }
    // Ler arquivo passando o caminho(Path)
    public static void readerFile(Path path) throws ParseException {
        Cliente cliente = new Cliente();
        Contrato contrato = new Contrato();
        ContratoService servico = new ContratoService();
        try {
            // PASANSO O PATH E O O TIPO DO CHARSET = UTF-8
            String reader = Files.readString(path, StandardCharsets.UTF_8);
            String cpf = reader.substring(0, 14);
            String rg = reader.substring(14, 21);

            String nome = reader.substring(21, 60).toUpperCase();
            String celular = reader.substring(60, 75);
            String rua = reader.substring(75, 96);
            String numero = reader.substring(96, 99);
            String complemento = reader.substring(99, 117);
            String bairro = reader.substring(117, 130);
            String cidade = reader.substring(130, 149);
            String sp = reader.substring(149, 151);
            String cep = reader.substring(151, 161);
            String br = reader.substring(161, 163);
            String protocolo = reader.substring(163, 170);
            String data = reader.substring(170, 180);
            String hora = reader.substring(180, 185);
            String agua = reader.substring(185, 189);
            String valoraAgua = reader.substring(189, 195);
            String wawhatsap = reader.substring(195, 200);

            
            

            
           
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            contrato.setProtocolo(protocolo);
            contrato.setDate(data);
            contrato.setHora(hora);
            servico.setAgua(valoraAgua);
            cliente.setLogradouro(rua);
            cliente.setComplemento(complemento);
            cliente.setBairro(bairro);
            cliente.setBairro(bairro);
            cliente.setCidade(cidade);
            cliente.setCep(cep);
            cliente.setPais(Paises.BRASIL);
            contrato.setCliente(cliente);
           System.out.println(wawhatsap);
            System.out.println(servico.gerarContratoDeServico(contrato,cliente));
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }
//    public static String formatarString(String ) throws ParseException {
//        MaskFormatter mf = new MaskFormatter("(##)#####-####");
//        mf.setValueContainsLiteralCharacters(false);
//        return 
//    }
}
