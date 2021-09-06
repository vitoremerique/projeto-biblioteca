package Repositório.usuário;

public class UsuarioJaCadastradaException extends Exception{

    public UsuarioJaCadastradaException(){
        super("Usuario já Cadastrada");
    }
}
