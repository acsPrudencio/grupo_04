

public class StringFormat {
    
    public static void main(String[] args){
        
        //Declarando as variáveis.

            String nome = "Junior";
            double salario = 10562d;

        //Usando o método format.
            
            System.out.print(String.format("Meu nome é %s e ", nome));
            System.out.println(String.format("meu salário é R$ %,.2f", salario));
            

    }

}
