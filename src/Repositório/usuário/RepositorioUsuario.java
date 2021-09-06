package Repositório.usuário;

import model.usuario.Usuario;


import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario implements RepositorioUsuarioInterface {

    List<Usuario> usuarios;
    public RepositorioUsuario(){
        usuarios = new ArrayList<>();
    }

    public Usuario BuscarUsuario(String nome) throws UsuarioNaoCadastradaException {
        for (Usuario usuario: usuarios) {
          if(usuario.getNome().equals(nome)){
            return usuario;
          } 
        }
        throw new UsuarioNaoCadastradaException();
    }

    public void InserirUsuario(Usuario usuario) throws UsuarioJaCadastradaException {
        try{
            BuscarUsuario(usuario.getNome());
            throw new UsuarioJaCadastradaException();
        }catch(UsuarioNaoCadastradaException ex){
          usuarios.add(usuario);
        }
    }

    public void AlterarUsuario(Usuario usuario) throws UsuarioNaoCadastradaException {

    }

    public void DeletarUsuario(Usuario usuario) throws UsuarioNaoCadastradaException{
      if(!usuarios.remove(usuario)){
          throw new UsuarioNaoCadastradaException();
      }
    }

    @Override
    public List<Usuario> getAll() {
      return new ArrayList<>(usuarios);
    }
}
