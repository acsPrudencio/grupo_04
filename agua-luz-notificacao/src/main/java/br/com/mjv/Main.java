package br.com.mjv;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Cadastro cc = new Cadastro();
        cc.getCliente().setNome("Lucilaneo");
        cc.getCliente().setCpf("099.598.445-68");
        cc.getEndereco().setLogradouro("Rua das Marias, 243");
        cc.getEndereco().setComplemento("Ap 207, Bloco C");
        cc.getEndereco().setBairro("Santo Antonio");
        cc.getEndereco().setCidade("São Paulo / SP");
        cc.getEndereco().setCep("27.310-657");
        cc.setProtocolo("2022025687 ");
        cc.setDataHora(LocalDateTime.now());
        cc.setServico(Servico.AGUA);
        System.out.println(cc.exibir());
        EntradaSaida.CarregarArquivo();
    }
}