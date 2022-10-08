import java.text.DecimalFormat;
//import java.time.LocalDate;

public class ContaCorrente {

    private String numeroDaConta;
    private String numeroDaAgencia;
    private String nomeDoCliente;
    //LocalDate dataDeNascimento;
    private double saldoDaConta;
    private boolean contaAberta;
    String padraoMonetario = "R$###,##0.00";


    DecimalFormat df = new DecimalFormat(padraoMonetario);


    void sacarUmValor(double valor) {
       //TODO realizar saque
       if(this.isContaAberta()) {
            if(valor > getSaldoDaConta())
                System.out.println("Não é possível sacar um valor maior do que o saldo da conta.");
            else if(valor == 0)
                System.out.println("Não é possível sacar "+df.format(valor));
            else {
                setSaldoDaConta(getSaldoDaConta() - valor);
                System.out.println("Você sacou "+df.format(valor)+" da sua conta");
            }
        } else {
            System.out.println("Não é possível sacar dinheiro de uma conta inexistente.");
        }
    }

    void depositarUmValor(double valor) {
        if(this.isContaAberta()) {
            if(valor == 0) {
                System.out.println("Não é possível sacar "+df.format(valor));
            } else {
                setSaldoDaConta(getSaldoDaConta() + valor);
                System.out.println("Você depositou "+df.format(valor)+" em sua conta.");
            }
        } else {
            System.out.println("Não é possível depositar dinheiro em uma conta inexistente.");
        }
    }

    void abrirConta(String numeroDaConta, String numeroDaAgencia, String nomeDoCliente) {
        if(this.isContaAberta()) {
            setNumeroDaConta(numeroDaConta);
            setNumeroDaAgencia(numeroDaAgencia);
            setNomeDoCliente(nomeDoCliente);
            setContaAberta(true);
            System.out.println(getNomeDoCliente()+" a sua conta foi criada com sucesso.");
        } else {
            System.out.println("Sua conta já foi aberta.");
        }
    }

    void transferirValorEntreContas(double valor, ContaCorrente conta) {
       //TODO realizar transferencia
    }

    void cancelarConta(String motivoCancelamento) {
        if(this.isContaAberta())
            System.out.println("Não há nenhuma conta aberta no momento.");
        else {
            setContaAberta(false);
            System.out.println("Sua conta foi fechada com sucesso pelo motivo: "+motivoCancelamento);
        }
    }

    /*String consultarExtratoPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
       //TODO Consultar o extrato no periodo X e retorna o saldo da conta
        return "Extrato";
    }*/

    void consultarSaldo() {
       //TODO Retorna o saldo da conta
        System.out.println("Seu saldo atual é de "+df.format(getSaldoDaConta()));
    }



    public double getSaldoDaConta() {
        return saldoDaConta;
    }

    public void setSaldoDaConta(double saldoDaConta) {
        this.saldoDaConta = saldoDaConta;
    }

    public boolean isContaAberta() {
        return contaAberta;
    }

    public void setContaAberta(boolean contaAberta) {
        this.contaAberta = contaAberta;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public String getNumeroDaAgencia() {
        return numeroDaAgencia;
    }

    public void setNumeroDaAgencia(String numeroDaAgencia) {
        this.numeroDaAgencia = numeroDaAgencia;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

}
