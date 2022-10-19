import br.com.mjv.dominio.enums.TipoNotificaoEnum;
import br.com.mjv.dominio.enums.TipoServicoEnum;
import br.com.mjv.dominio.model.Contrato;
import br.com.mjv.dominio.model.Endereco;
import br.com.mjv.dominio.model.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ClasseContratoTest {

    @DisplayName("Testando cadastro e recuperação de tipo de serviço")
    @Test

    public void InserirTipoServicoTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        Contrato c = new Contrato( TipoServicoEnum.LUZ, new BigDecimal(25050) ,p);
        Assertions.assertEquals(TipoServicoEnum.LUZ, c.getTipoServico());
    }

    @DisplayName("Testando cadastro e recuperação de valor")
    @Test

    public void InserirValorTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        Contrato c = new Contrato( TipoServicoEnum.LUZ, new BigDecimal(25050) ,p);
        Assertions.assertEquals(new BigDecimal(25050), c.getValor());
    }

    @DisplayName("Testando recuperação de pessoa")
    @Test

    public void RecuperarPessoaTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        Contrato c = new Contrato( TipoServicoEnum.LUZ, new BigDecimal(25050) ,p);
        Assertions.assertEquals(p, c.getPessoa());
    }

    @DisplayName("Testando cadastro e recuperação de tipo de notificação")
    @Test

    public void InserirTipoNotificacaoTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        Contrato c = new Contrato( TipoServicoEnum.LUZ, new BigDecimal(25050) ,p);
        c.setTipoNotificao(TipoNotificaoEnum.SMS);
        Assertions.assertEquals(TipoNotificaoEnum.SMS, c.getTipoNotificao());
    }
}
