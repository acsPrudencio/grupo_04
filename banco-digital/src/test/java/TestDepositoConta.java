import br.com.mjv.modelo.Banco;
import br.com.mjv.modelo.Cliente;
import br.com.mjv.modelo.Conta;
import br.com.mjv.modelo.ContaCorrente;
import br.com.mjv.modelo.validations.ContaInexistente;
import br.com.mjv.modelo.validations.SaldoInsuficiente;
import br.com.mjv.modelo.validations.ValorDepositarInvalido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDepositoConta {
    @DisplayName("Realizar deposito ")
    @Test
    void testRealizarDeposito() throws ContaInexistente, ValorDepositarInvalido {
        Cliente Lucilaneo = new Cliente("Lucilaneo");
        ContaCorrente cc = new ContaCorrente(Lucilaneo);
        Banco banco = new Banco();
        banco.incluir(cc);
        banco.deposito(cc,100);
        assertEquals(100, banco.saldo(cc), 0.001);
    }

    @DisplayName("ValorDepositarInvalido - Deposito Negativo ")
    @Test
    void testValorDepositarValorNegativo() throws ContaInexistente {

        Cliente Lucilaneo = new Cliente("Lucilaneo");
        ContaCorrente cc = new ContaCorrente(Lucilaneo);
        Banco banco = new Banco();
        banco.incluir(cc);
        ValorDepositarInvalido retorno = Assertions.assertThrows(ValorDepositarInvalido.class, () ->{
           banco.deposito(cc,-1);
               }, "Esperado exceção ValorDepositarInvalido");
        Assertions.assertEquals("O valor de depósito deve ser superior a zero.", retorno.toString());


}
    @DisplayName("ValorDepositarInvalido - Deposito com valor zero")
    @Test
    void testValorDepositarValorZero() throws ContaInexistente {

        Cliente Lucilaneo = new Cliente("Lucilaneo");
        ContaCorrente cc = new ContaCorrente(Lucilaneo);
        Banco banco = new Banco();
        banco.incluir(cc);
        ValorDepositarInvalido retorno = Assertions.assertThrows(ValorDepositarInvalido.class, () ->{
            banco.deposito(cc,0);
        }, "Esperado exceção ValorDepositarInvalido");
        Assertions.assertEquals("O valor de depósito deve ser superior a zero.", retorno.toString());


    }







}
