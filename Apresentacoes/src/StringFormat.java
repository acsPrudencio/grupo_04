public class StringFormat {
    
    public static void main(String[] args){
        
        //Declarando as variáveis.

            String nome = "Junior";
            double salario = 10562d;
            String str1 = "";
            String str2 = "";

        //Usando o método format.
            
            str1 = String.format("Meu nome é %s", nome);   
            str2 = String.format(" e meu salário é R$ %,.2f", salario);

            StringBuilder sb = new StringBuilder(str1);
            
            System.out.println(sb.append(str2));
       
    }
}
