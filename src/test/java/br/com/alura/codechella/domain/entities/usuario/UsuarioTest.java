package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.12.123-12", "Daniel", LocalDate.parse("2001-05-05"), "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123-99", "Daniel", LocalDate.parse("2001-05-05"), "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "Daniel", LocalDate.parse("2001-05-05"), "email@email.com"));
    }

    @Test
    public void naoDeveCadastrarUsarioMenorDeDezoitoAnos() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.123.123-12", "Daniel", LocalDate.parse("2007-05-05"), "email@email.com"));
    }

    @Test
    public void deveCadastrarUsuarioMaiorDeDezoitoAnos() {
        Assertions.assertDoesNotThrow(() ->
                new Usuario("123.123.123-12", "Daniel", LocalDate.parse("2000-05-05"), "email@email.com"));
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario() {
        FabricaUsuario fabrica = new FabricaUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento("123.123.123-12", "Danielson", LocalDate.parse("2000-01-01"));

        Assertions.assertEquals("Danielson", usuario.getNome());

        usuario = fabrica.incluiEndereco("59220000", 32, "Apartamento");

        Assertions.assertEquals(32, usuario.getEndereco().getNumero());
    }
}
