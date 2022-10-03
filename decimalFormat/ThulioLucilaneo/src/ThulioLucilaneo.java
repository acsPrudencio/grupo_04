import java.text.DecimalFormat;

public class ThulioLucilaneo {
    public static void main(String[] args) {

        //padrao utilizando - EN
        String padrao1 = "###,###.##";
        DecimalFormat df = new DecimalFormat(padrao1);
        System.out.println("SAIDA PADRAO 1 = "+df.format(234567890.123));

        //padrao utilizando localizacao - PT
        String padrao2 = "###.###,##";
        df.applyLocalizedPattern(padrao2);
        System.out.println("SAIDA PADRAO 2 = "+ df.format(234567890.123));


        String padrao3 = "R$###.##0,00";
        DecimalFormat dfs = new DecimalFormat();
        dfs.applyLocalizedPattern(padrao3);
        System.out.println(dfs.format(0.1));
    }
}
