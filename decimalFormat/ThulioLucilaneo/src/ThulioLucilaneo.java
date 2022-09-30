import java.text.DecimalFormat;

public class ThulioLucilaneo {
    public static void main(String[] args) {
        String padrao = "R$###,###.##";
        DecimalFormat df = new DecimalFormat(padrao);

        //df.applyPattern(padrao);
        System.out.println(df.format(1234567890.123));

        String padrao2 = "R$###,##0.00";
        DecimalFormat dfs = new DecimalFormat(padrao2);

        System.out.println(dfs.format(0.1));
    }
}
