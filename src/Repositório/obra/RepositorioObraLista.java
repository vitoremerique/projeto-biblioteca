package Repositório.obra;

import model.obra.Obra;


import java.util.ArrayList;
import java.util.List;


public  class RepositorioObraLista implements RepositorioObra {

List<Obra> obras;
    public RepositorioObraLista(){
        obras = new ArrayList<>();
    }

    public Obra BuscarObra(String Titulo) throws ObraNaoCadastradaException {
        for (Obra obra:obras) {
        if(obra.getTitulo().equals(Titulo)){
                return obra;

        } }
        throw new ObraNaoCadastradaException();
    }


    public void InserirObra(Obra obra) throws ObraJaCadastradaException {
        try{
            BuscarObra(obra.getIsbn());
            throw new ObraJaCadastradaException();
        }catch(ObraNaoCadastradaException ex){
       obras.add(obra);

        }
    }


    public void AlterarObra(Obra obra) throws ObraNaoCadastradaException {

    }

    public void DeletarObra(Obra obra) throws ObraNaoCadastradaException{
    if(!obras.remove(obra)){
        throw new ObraNaoCadastradaException();
    }

    }

    @Override
    public List<Obra> getAll() {
    return new ArrayList<>(obras);
    }
}
