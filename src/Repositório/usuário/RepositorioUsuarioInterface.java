package Repositório.usuário;
import java.util.List;

import Repositório.usuário.UsuarioJaCadastradaException;
import Repositório.usuário.UsuarioNaoCadastradaException;
import model.usuario.Usuario;


public interface RepositorioUsuarioInterface {
    Usuario BuscarUsuario(String nome) throws UsuarioNaoCadastradaException;
    void InserirUsuario(Usuario usuarioes) throws UsuarioJaCadastradaException;
    void AlterarUsuario(Usuario usuarioes) throws UsuarioNaoCadastradaException;
    void DeletarUsuario(Usuario usuarioes) throws UsuarioNaoCadastradaException;
    List<Usuario> getAll();
}
