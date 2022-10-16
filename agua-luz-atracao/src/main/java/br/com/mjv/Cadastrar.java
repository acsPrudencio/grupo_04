package br.com.mjv;

import java.io.*;

public class Cadastrar {
    public static void main(String[] args) {


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