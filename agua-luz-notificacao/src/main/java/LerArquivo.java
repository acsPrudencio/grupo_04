import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LerArquivo {

public static void leituraArquivoPosicional(){
   List<Cadastro> cadastros = new ArrayList<>();
   List<String> teste = new ArrayList<>();
    File file = new File("C:\\Users\\lcruz\\Downloads\\2022-10-15_lancamentos.txt");
    StringBuilder stringBuilder = new StringBuilder();
  try{
   FileReader ler = new FileReader(file);
   BufferedReader br = new BufferedReader(ler);
   String line = br.readLine();
   while(line!=null){
       teste.add(line);
       line = br.readLine();
   }
           }catch (IOException e){
      System.out.println(e);
  }

    System.out.println();
    for(String test:teste){

    }

}

    public static void readFile() {

        String fileName = "C:\\Users\\lcruz\\Downloads\\2022-10-15_lancamentos.txt";
        try (FileInputStream fis = new FileInputStream(new File(fileName))) {

            // remaining bytes that can be read
            System.out.println("Remaining bytes that can be read : " + fis.available());

            int content;
            // reads a byte at a time, if end of the file, returns -1
            while ((content = fis.read()) != -1) {
                System.out.println((char) content);

                System.out.println("Remaining bytes that can be read : " + fis.available());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



}

}
