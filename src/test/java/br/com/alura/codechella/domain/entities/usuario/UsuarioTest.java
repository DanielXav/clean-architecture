package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-99", "Daniel", LocalDate.parse("2001-05-05"), "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123-99", "Daniel", LocalDate.parse("2001-05-05"), "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "Daniel", LocalDate.parse("2001-05-05"), "email@email.com"));
    }
}
