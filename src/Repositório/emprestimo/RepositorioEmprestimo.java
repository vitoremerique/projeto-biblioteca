
package Repositório.emprestimo;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

import model.emprestimo.Emprestimo;

import model.exemplares.Exemplar;

import java.time.LocalDateTime;

public class RepositorioEmprestimo implements RepositorioEmprestimoInterface {
    List<Emprestimo> emprestimos;

    public RepositorioEmprestimo(){
        emprestimos = new ArrayList<>();
    }

    public Emprestimo BuscarEmprestimo(String id) throws EmprestimoNaoCadastradaException {
        for (Emprestimo emprestimo: emprestimos) {
            if(emprestimo.getId().equals(id)){
                    return emprestimo;
            } }
        throw new EmprestimoNaoCadastradaException();
    }

    public void InserirEmprestimo(Emprestimo emprestimo) throws EmprestimoJaCadastradaException {
        try{

                BuscarEmprestimo(emprestimo.getUsuario().getId_Usuario());



            throw new EmprestimoJaCadastradaException();
        }catch(EmprestimoNaoCadastradaException ex){
           emprestimos.add(emprestimo);
        }
    }

    public void AlterarEmprestimo(Emprestimo emprestimo) throws EmprestimoNaoCadastradaException {

    }

    public void DeletarEmprestimo(Emprestimo emprestimo) throws EmprestimoNaoCadastradaException{
      if(!emprestimos.remove(emprestimo)){
          throw new EmprestimoNaoCadastradaException();
      }
    }

    public List<Emprestimo> getAll() {
      return new ArrayList<>(emprestimos);
    }


}