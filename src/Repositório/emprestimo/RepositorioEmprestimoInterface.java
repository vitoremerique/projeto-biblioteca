package Repositório.emprestimo;
import Repositório.emprestimo.EmprestimoJaCadastradaException;
import Repositório.emprestimo.EmprestimoNaoCadastradaException;
import model.emprestimo.Emprestimo;


import java.util.List;

public interface RepositorioEmprestimoInterface {
    Emprestimo BuscarEmprestimo(String id) throws EmprestimoNaoCadastradaException;
    void InserirEmprestimo(Emprestimo emprestimo) throws EmprestimoJaCadastradaException;
    void AlterarEmprestimo(Emprestimo emprestimo) throws EmprestimoNaoCadastradaException;
    void DeletarEmprestimo(Emprestimo emprestimo) throws EmprestimoNaoCadastradaException;
    List<Emprestimo> getAll();


}
