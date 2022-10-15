package br.com.mjv;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class EntradaSaida {

    public static void CarregarArquivo() {
        Cadastro cadastro = new Cadastro();
        StringBuilder sb = new StringBuilder();
        String nomeArquivo = String.format("teste.txt");
        File diretorio = new File("C:\\Users\\lcruz\\Downloads");
        File arquivo = new File(diretorio, nomeArquivo);
        Path path = arquivo.toPath();
        try {
            System.out.println(Files.readString(path));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
