import br.com.mjv.dominio.enums.PaisEnum;
import br.com.mjv.dominio.enums.UfEnum;
import br.com.mjv.dominio.model.Endereco;
import br.com.mjv.dominio.model.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClasseEnderecoTest {

    @DisplayName("Testanto cadastro e recuperação de bairro")
    @Test

    public void InsercaoBairroTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        p.getEndereco().setBairro("Caixa d'água");
        Assertions.assertEquals("Caixa d'água", p.getEndereco().getBairro());
    }

    @DisplayName("Testando cadastro e recuperação de CEP")
    @Test

    public void insercaoCepTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        p.getEndereco().setCep("05858000");
        Assertions.assertEquals("05858000", p.getEndereco().getCep());
    }

    @DisplayName("Testando cadastro e recuperação de cidade")
    @Test

    public void insercaoCidadeTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        p.getEndereco().setCidade("Roraima");
        Assertions.assertEquals("Roraima", p.getEndereco().getCidade());
    }

    @DisplayName("Testando cadastro e recuperação de complemento")
    @Test

    public void insercaoComplementoTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        p.getEndereco().setComplemento("do lado do vizinho");
        Assertions.assertEquals("do lado do vizinho", p.getEndereco().getComplemento());
    }

    @DisplayName("Testando cadastro e recuperação de logradouro")
    @Test

    public void insercaoLogradouroTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        p.getEndereco().setLogradouro("R. Miguel Pereira dos Santos");
        Assertions.assertEquals("R. Miguel Pereira dos Santos", p.getEndereco().getLogradouro());
    }

    @DisplayName("Testando cadastro e recuperação de numero")
    @Test

    public void insercaoNumeroTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        p.getEndereco().setNumero("12345");
        Assertions.assertEquals("12345", p.getEndereco().getNumero());
    }

    @DisplayName("Testando cadastro e recuperação de país")
    @Test

    public void insercaoPaisTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        p.getEndereco().setPais(PaisEnum.BR);
        Assertions.assertEquals(PaisEnum.BR, p.getEndereco().getPais());
    }

    @DisplayName("Testando cadastro e recuperação de UF")
    @Test

    public void insercaoUfTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        p.getEndereco().setUF(UfEnum.RR);
        Assertions.assertEquals(UfEnum.RR, p.getEndereco().getUF());
    }
}


