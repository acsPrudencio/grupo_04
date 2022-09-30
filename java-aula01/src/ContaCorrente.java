import java.time.LocalDate;

public class ContaCorrente {

    String numeroDaConta;
    String numeroDaAgencia;
    String nomeDoCliente;
    LocalDate dataDeNascimento;
    double saldoDaConta;

    void sacarUmValor(double valor){
       //TODO realizar saque
    }

    void transferirValorEntreContas(double valor, ContaCorrente conta){
       //TODO realizar transferencia
    }

    boolean cancelarConta(String motivoCancelamento){
        //TODO realizar cancelamento da conta e retorna true se a operação foi realizada com sucesso e false se a operação não pode ser realizada.
        return true;
    }

    String consultarExtratoPorPeriodo(LocalDate dataInicio, LocalDate dataFim){
       //TODO Consultar o extrato no periodo X e retorna o saldo da conta
        return "Extrato";
    }

    double consultarSaldo(){
       //TODO Retorna o saldo da conta
        return 0;
    }
}
