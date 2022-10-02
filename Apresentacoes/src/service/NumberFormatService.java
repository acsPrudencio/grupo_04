package service;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatService {
    public static void main(String[] args) throws ParseException {
        double valor1 = 1.1;
        double valor2 = 2.2;
        double valor3 = 0.33;
        // Retorna a instância de um objeto com base no formato da localidade padrão.
        // É utilizado para números
        NumberFormat nf1 = NumberFormat.getNumberInstance();
        String valor1Formatado = nf1.format(valor1);
        System.out.println("Valor númerico: " + valor1Formatado);

        // Formatar um valor monetario para a localidade atual.
        // Recebe um valor monetario como parametro, e tem como retorno uma String.
        String valor2Formatado = NumberFormat.getCurrencyInstance().format(valor2);
        System.out.println("Valor monetario: " + valor2Formatado);

        // Usado para formatar frações pro exemplo 0,15 é formatado e mostrado como 15%
        String valor3Formatado = NumberFormat.getPercentInstance().format(valor3);
        System.out.println("Valor percentual: " + valor3Formatado);

        // Para diminuir a verbosidade do metodo, podemos criar um novo objeto do tipo NumberFormat
        // da seguite maneira
        NumberFormat nf = NumberFormat.getIntegerInstance();
        String valor4Formatado = nf.format(1.4);
        System.out.println("Valor inteiro: " + valor4Formatado);

        NumberFormat instance = NumberFormat.getInstance(Locale.CANADA);

        // Usado para converter números
        // Recebe uma String com valor
        // E retorna uma instância de um objeto Number
        // Esse Number tem varios metodos para conversão de números
        Number valor5Formatado = instance.parse("33");
        System.out.println("Objeto do tipo number: " + valor5Formatado);

    }
}
