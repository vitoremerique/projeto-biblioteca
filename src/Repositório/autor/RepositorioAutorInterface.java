package Repositório.autor;
import Repositório.autor.autorJaCadastradoException;
import Repositório.autor.autorNaoCadastradaException;
import model.autor.Autor;

import java.util.List;

public interface RepositorioAutorInterface {
    Autor BuscarAutor(String nome) throws autorNaoCadastradaException;
    void InserirAutor(Autor autores) throws autorJaCadastradoException;
    void AlterarAutor(Autor autores) throws autorNaoCadastradaException;
    void DeletarAutor(Autor autores) throws autorNaoCadastradaException;
    List<Autor> getAll();
}
