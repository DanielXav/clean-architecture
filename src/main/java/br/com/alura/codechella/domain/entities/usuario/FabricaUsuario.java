package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;

import java.time.LocalDate;

public class FabricaUsuario {

    private Usuario usuario;

    public Usuario comNomeCpfNascimento(String nome, String cpf, LocalDate nascimento) {
        usuario = new Usuario(nome, cpf, nascimento, "");
        return usuario;
    }

    public Usuario incluiEndereco(String cep, Integer numero, String complemento) {
        usuario.setEndereco(new Endereco(cep, numero, complemento));
        return usuario;
    }
}