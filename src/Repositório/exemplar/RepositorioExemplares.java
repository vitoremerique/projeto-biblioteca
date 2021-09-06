
package Repositório.exemplar;

import java.util.ArrayList;
import java.util.List;

import Repositório.emprestimo.RepositorioEmprestimo;
import model.emprestimo.Emprestimo;
import model.exemplares.Exemplar;


public  class RepositorioExemplares implements RepositorioExemplaresInterface {
    List<Exemplar> exemplares;
    public RepositorioExemplares(){
        exemplares = new ArrayList<>();
    }

    public Exemplar BuscarExemplares(String id) throws exemplaresNaoCadastradaException {
        for (Exemplar exemplar:exemplares) {
            if(exemplar.getId().equals(id)){
                    return exemplar;

            } }
        throw new exemplaresNaoCadastradaException();
    }


    public void InserirExemplares(Exemplar exemplar) throws exemplaresJaCadastradaException {
        try{

            BuscarExemplares(exemplar.getId());
            throw new exemplaresJaCadastradaException();
        }catch(exemplaresNaoCadastradaException ex){
           exemplares.add(exemplar);
        }
    }


    public void AlterarExemplares(Exemplar exemplar) throws exemplaresNaoCadastradaException {

    }

    public void DeletarExemplares(Exemplar exemplar) throws exemplaresNaoCadastradaException{
    if(!exemplares.remove(exemplar)){
        throw new exemplaresNaoCadastradaException();
    }

    }

    @Override
    public List<Exemplar> getAllE() {
    return new ArrayList<>(exemplares);
    }


    public List<Exemplar> getAllExemplar(String Titulo) {
    List<Exemplar>lista = new ArrayList<>();
        for (Exemplar exemplar:exemplares) {
            if(exemplar.getObra().getTitulo().equals(Titulo)){
                    lista.add(exemplar);
            }
        }
        return lista;
    }


}
