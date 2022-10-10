import br.com.mjv.modelo.Banco;
import br.com.mjv.modelo.Cliente;
import br.com.mjv.modelo.Conta;
import br.com.mjv.modelo.ContaCorrente;
import br.com.mjv.modelo.validations.ContaInexistente;
import br.com.mjv.modelo.validations.SaldoInsuficiente;
import br.com.mjv.modelo.validations.ValorDepositarInvalido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDepositoConta {

    @Test
    void testRealizarDeposito() throws ContaInexistente, ValorDepositarInvalido {
        Cliente Lucilaneo = new Cliente("Lucilaneo");
        ContaCorrente cc = new ContaCorrente(Lucilaneo);
        Banco banco = new Banco();
        banco.incluir(cc);
        banco.deposito(cc,100);
        assertEquals(4000, banco.saldo(cc), 0.001);

    }


    @Test
    void testValorDepositarInvalidoException() throws ContaInexistente {

        Cliente Lucilaneo = new Cliente("Lucilaneo");
        ContaCorrente cc = new ContaCorrente(Lucilaneo);
        Banco banco = new Banco();
        banco.incluir(cc);
        //Valor menor ou igual a zero atende(pass)
        ValorDepositarInvalido retorno = Assertions.assertThrows(ValorDepositarInvalido.class, () ->{
           banco.deposito(cc,0);
               }, "Esperado exceção ValorDepositarInvalido");
        Assertions.assertEquals("O valor de depósito deve ser superior a zero.", retorno.toString());


}







}
