package Repositório.obra;
import model.obra.Obra;


import java.util.List;

public interface RepositorioObra {

    Obra BuscarObra(String Titulo) throws ObraNaoCadastradaException;
    void InserirObra(Obra obra) throws ObraJaCadastradaException;
    void AlterarObra(Obra obra) throws ObraNaoCadastradaException;
    void DeletarObra(Obra obra) throws ObraNaoCadastradaException;
    List<Obra> getAll();
}
