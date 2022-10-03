import java.util.Locale;

public class StringFormat {
    
    public static void main(String[] args){
        
            double salario = 1056238d;

            System.out.println(String.format(Locale.US, "meu salário é %,.2f", salario));

    }

    /*O método format da classe String existe desde o Java 1.5(Java 5, Tiger). é um método estático usado para formatar textos.

     * O método String.format(), funciona igual ao método printf()
     * 
     * Dentro do método String.format, primeiro se passa uma String format que vai conter o específicador de formato (String format), depois, após a vírgula, são adicionados os argumentos, que são os valores que se quer formatar (variáveis).
     * 
     * Os específicadores de formatação, são compostos do símbolo de "%" e um caracter que indica o tipo da variável, eles indicam o local na String e o tipo de dado que vai ser mostrado na saída:

     * Para double e float: %f, pode-se adicionar a precisão do número (%.2f <= o valor será formatado com precisão de dois números decimais). Pode-se formatar um valor com o método Locale, passando ele dentro do método String.format() antes da String format, separando eles por vírgula. Mas para funciona tem que se adicionar uma vírgula no específicador de formatação entre o símbolo de % e o caractere que identifica o tipo ex: (Locale.US, "... %,f", argumento) 
     * 
     * Para String: %s
     * 
     * Para número inteiro decimal: %d
     * 
     * Para boolean: %b
     * 
     * Para caractere (char): %c
     * 
     * 
     * 
     * 
     */

}
