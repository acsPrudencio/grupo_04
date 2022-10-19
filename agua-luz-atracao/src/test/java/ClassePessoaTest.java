import br.com.mjv.dominio.model.Endereco;
import br.com.mjv.dominio.model.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClassePessoaTest {

    @DisplayName("Testando inserção e recuperação de número de celular")
    @Test

    public void InserirNumeroCelularTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        p.setNumeroCelular("011966382266");
        Assertions.assertEquals("011966382266", p.getCelular());
    }

    @DisplayName("Testando inserção e recuperação de endereço")
    @Test

    public void RecuperarEnderecoTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        Assertions.assertEquals(e, p.getEndereco());
    }

    @DisplayName("Testando inserção e recuperação de CPF")
    @Test

    public void RecuperarcpfTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        Assertions.assertEquals("123456789", p.getCpf());
    }

    @DisplayName("Testando inserção e recuperação de RG")
    @Test

    public void RecuperarRgTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        Assertions.assertEquals("123456", p.getRg());
    }

    @DisplayName("Testando inserção e recuperação de nome")
    @Test

    public void RecuperarNomeTest(){
        Endereco e = new Endereco();
        Pessoa p = new Pessoa("123456789", "123456", "Antoin", e);
        Assertions.assertEquals("Antoin", p.getNome());
    }

}
