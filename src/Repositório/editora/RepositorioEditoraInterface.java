package Repositório.editora;
import Repositório.editora.editoraJaCadastradaException;
import Repositório.editora.editoraNaoCadastradaException;
import model.editora.Editora;

import java.util.List;

public interface RepositorioEditoraInterface {

    Editora BuscarEditora(String nome) throws editoraNaoCadastradaException;
    void InserirEditora(Editora editora) throws editoraJaCadastradaException;
    void AlterarEditora(Editora editora) throws editoraNaoCadastradaException;
    void DeletarEditora(Editora editora) throws editoraNaoCadastradaException;
    List<Editora> getAll();
}
