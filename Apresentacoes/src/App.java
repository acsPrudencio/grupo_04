import java.util.Locale;

public class App {
    public static void main(String[] args){
        System.out.printf("%s\n\n", toString("José", "144.763.951-22", 'M', 59, 189326256));
        System.out.printf("%s\n", toString("Maria Joaquina", "961.457.202-17", 'F', 29, 4523552));

    }

    public static String toString(String nome, String cpf, char sexo, int idade, double salario){

        String formulario;
        
        formulario = String.format("Nome.....: %s\n", nome) +              
        String.format("CPF......: %s \n", cpf) +
        String.format("Sexo.....: %c \n", sexo) +
        String.format("Idade....: %d anos\n", idade) +
        String.format(Locale.US, "Salario..: %,.2f reais", salario);

    return(formulario);

    }
}

