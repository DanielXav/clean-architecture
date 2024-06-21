package br.com.alura.codechella.application.gateways;



import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RepositorioDeUsuario {

    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}
