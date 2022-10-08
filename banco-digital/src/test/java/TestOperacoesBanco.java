import br.com.mjv.modelo.*;
import br.com.mjv.modelo.validations.ContaInexistente;
import br.com.mjv.modelo.validations.SaldoInsuficiente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestOperacoesBanco {
    @Test
    public void testarInclusaoDeContaComum() throws ContaInexistente {
        Banco bancoMJV = new Banco();
        Cliente cliente1 = new Cliente("Antonio");
        Conta contaComum1 = new ContaCorrente(cliente1);
        Conta contaComum2 = new ContaCorrente(cliente1);

        bancoMJV.incluir(contaComum1);
        bancoMJV.incluir(contaComum2);
        assertEquals(0, bancoMJV.saldo(contaComum1), 0.001);
        assertEquals(0, bancoMJV.saldo(contaComum2), 0.001);

        // Teste inclusao de conta null
        try {
            bancoMJV.incluir(null);
            fail();
        } catch (Exception e) {
            // TODO: handle exception
            assertTrue(true);
        }

    }

    @Test
    public void testarInclusaoDeContaPoupanca() throws ContaInexistente {
        Banco bancoMJV = new Banco();
        Cliente cliente1 = new Cliente("Antonio");
        Conta poupanca1 = new ContaCorrente(cliente1);
        Conta poupanca2 = new ContaCorrente(cliente1);

        bancoMJV.incluir(poupanca1);
        bancoMJV.incluir(poupanca2);
        assertEquals(0, bancoMJV.saldo(poupanca1), 0.001);
        assertEquals(0, bancoMJV.saldo(poupanca2), 0.001);

        // Teste inclusao de conta null
        try {
            bancoMJV.incluir(null);
            fail();
        } catch (Exception e) {
            // TODO: handle exception
            assertTrue(true);
        }
    }


    @Test
    public void testarDepositoDeContaPoupanca() throws ContaInexistente {
        Banco bancoMJV = new Banco();
        Cliente cliente1 = new Cliente("Antonio");
        Conta poupanca1 = new ContaCorrente(cliente1);
        Conta poupanca2 = new ContaCorrente(cliente1);

        bancoMJV.incluir(poupanca1);
        bancoMJV.deposito(poupanca1, 2000);
        bancoMJV.deposito(poupanca1, 1000);
        bancoMJV.deposito(poupanca1, 1000);
        bancoMJV.incluir(poupanca2);
        bancoMJV.deposito(poupanca2, 2000);
        bancoMJV.deposito(poupanca2, 1000);
        bancoMJV.deposito(poupanca2, 1000);
        assertEquals(4000, bancoMJV.saldo(poupanca1), 0.001);
        assertEquals(4000, bancoMJV.saldo(poupanca2), 0.001);
    }

    @Test
    public void testarDepositoDeContaComum() throws ContaInexistente {
        Banco bancoMJV = new Banco();
        Cliente cliente1 = new Cliente("Antonio");
        Conta contaComum1 = new ContaCorrente(cliente1);
        Conta contaComum2 = new ContaCorrente(cliente1);

        bancoMJV.incluir(contaComum1);
        bancoMJV.deposito(contaComum1, 2000);
        bancoMJV.deposito(contaComum1, 1000);
        bancoMJV.deposito(contaComum1, 1000);
        bancoMJV.incluir(contaComum2);
        bancoMJV.deposito(contaComum2, 2000);
        bancoMJV.deposito(contaComum2, 1000);
        bancoMJV.deposito(contaComum2, 1000);
        assertEquals(4000, bancoMJV.saldo(contaComum1), 0.001);
        assertEquals(4000, bancoMJV.saldo(contaComum2), 0.001);
    }

    @Test
    public void testarSaqueDeContaPoupanca() throws ContaInexistente, SaldoInsuficiente {
        Banco bancoMJV = new Banco();
        Cliente cliente1 = new Cliente("Antonio");
        Conta poupanca1 = new ContaCorrente(cliente1);
        Conta poupanca2 = new ContaCorrente(cliente1);

        bancoMJV.incluir(poupanca1);
        bancoMJV.deposito(poupanca1, 2000);
        bancoMJV.saque(poupanca1, 1000);
        bancoMJV.saque(poupanca1, 500);
        bancoMJV.incluir(poupanca2);
        bancoMJV.deposito(poupanca2, 2000);
        bancoMJV.saque(poupanca2, 1000);
        bancoMJV.saque(poupanca2, 500);
        assertEquals(500, bancoMJV.saldo(poupanca1), 0.001);
        assertEquals(500, bancoMJV.saldo(poupanca2), 0.001);

        // Teste saque com valor maior que o disponivel em conta
        try {
            bancoMJV.saque(poupanca2, 10000);
            fail();
        } catch (Exception e) {

            assertTrue(true);
        }
    }

    @Test
    public void testarSaqueDeContaComum() throws ContaInexistente, SaldoInsuficiente {
        Banco bancoMJV = new Banco();
        Cliente cliente1 = new Cliente("Antonio");
        Conta contaComum1 = new ContaCorrente(cliente1);
        Conta contaComum2 = new ContaCorrente(cliente1);

        bancoMJV.incluir(contaComum1);
        bancoMJV.deposito(contaComum1, 2000);
        bancoMJV.saque(contaComum1, 1000);
        bancoMJV.saque(contaComum1, 500);
        bancoMJV.incluir(contaComum2);
        bancoMJV.deposito(contaComum2, 2000);
        bancoMJV.saque(contaComum2, 1000);
        bancoMJV.saque(contaComum2, 600);
        assertEquals(500, bancoMJV.saldo(contaComum1), 0.001);
        assertEquals(400, bancoMJV.saldo(contaComum2), 0.001);

        // Teste saque com valor maior que o disponivel em conta
        try {
            bancoMJV.saque(contaComum2, 10000);
            fail();
        } catch (Exception e) {

            assertTrue(true);
        }
    }

    @Test
    public void testarTranferencia() throws ContaInexistente, SaldoInsuficiente {
        Banco bancoMJV = new Banco();
        Cliente cliente1 = new Cliente("Antonio");
        Conta poupanca1 = new ContaPoupanca(cliente1);
        Conta contaComum2 = new ContaCorrente(cliente1);

        bancoMJV.incluir(poupanca1);
        bancoMJV.deposito(poupanca1, 2000);

        bancoMJV.incluir(contaComum2);
        bancoMJV.deposito(contaComum2, 2000);

        bancoMJV.transferir(poupanca1, contaComum2, 1000);

        assertEquals(3000, bancoMJV.saldo(contaComum2), 0.001);
        assertEquals(1000, bancoMJV.saldo(poupanca1), 0.001);

        // Teste tranferir valor maior que o disponivel em conta
        try {
            bancoMJV.saque(contaComum2, 10000);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

}
