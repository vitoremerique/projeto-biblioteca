
package Repositório.editora;

import java.util.ArrayList;
import java.util.List;

import model.editora.Editora;

public  class RepositorioEditora implements RepositorioEditoraInterface {

    List<Editora> editoras;
    public RepositorioEditora(){
        editoras = new ArrayList<>();
    }

    public Editora BuscarEditora(String nome) throws editoraNaoCadastradaException {
        for (Editora editora:editoras) {
            if(editora.getNome().equals(nome)){
                    return editora;
            } }
        throw new editoraNaoCadastradaException();
    }


    public void InserirEditora(Editora editora) throws editoraJaCadastradaException {
        try{
            BuscarEditora(editora.getNome());
            throw new editoraJaCadastradaException();
        }catch(editoraNaoCadastradaException ex){
           editoras.add(editora);
        }
    }


    public void AlterarEditora(Editora editora) throws editoraNaoCadastradaException {

    }

    public void DeletarEditora(Editora editora) throws editoraNaoCadastradaException{
    if(!editoras.remove(editora)){
        throw new editoraNaoCadastradaException();
    }

    }

    @Override
    public List<Editora> getAll() {
    return new ArrayList<>(editoras);
    }
}
