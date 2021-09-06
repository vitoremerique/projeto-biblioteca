package Repositório.exemplar;
import java.util.List;

import model.exemplares.Exemplar;


public interface RepositorioExemplaresInterface {
    Exemplar BuscarExemplares(String id ) throws exemplaresNaoCadastradaException;
    void InserirExemplares(Exemplar exemplares) throws exemplaresJaCadastradaException;
    void AlterarExemplares(Exemplar exemplares) throws exemplaresNaoCadastradaException;
    void DeletarExemplares(Exemplar exemplares) throws exemplaresNaoCadastradaException;
    List<Exemplar> getAllE();
    List<Exemplar> getAllExemplar(String Titulo);
}
