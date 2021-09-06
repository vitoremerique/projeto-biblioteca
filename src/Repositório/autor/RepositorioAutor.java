
package Repositório.autor;

import java.util.ArrayList;
import java.util.List;

import model.autor.Autor;


public  class RepositorioAutor implements RepositorioAutorInterface {

    List<Autor> autores;
    public RepositorioAutor(){
        autores = new ArrayList<>();
    }

    public Autor BuscarAutor(String nome) throws autorNaoCadastradaException {
        for (Autor autor:autores) {
            if(autor.getNome().equals(nome)){
                    return autor;
            } }
        throw new autorNaoCadastradaException();
    }


    public void InserirAutor(Autor autor) throws autorJaCadastradoException {
        try{
            BuscarAutor(autor.getNome());
            throw new autorJaCadastradoException();
        }catch(autorNaoCadastradaException ex){
           autores.add(autor);
        }
    }


    public void AlterarAutor(Autor autor) throws autorNaoCadastradaException {

    }

    public void DeletarAutor(Autor autor) throws autorNaoCadastradaException{
    if(!autores.remove(autor)){
        throw new autorNaoCadastradaException();
    }

    }

    @Override
    public List<Autor> getAll() {
    return new ArrayList<>(autores);
    }
}
