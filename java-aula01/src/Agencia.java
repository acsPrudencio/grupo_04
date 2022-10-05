public class Agencia {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente();

        cc.abrirConta("55555", "0001", "Fulano");
        cc.depositarUmValor(100);
        cc.sacarUmValor(50);
    }
}
