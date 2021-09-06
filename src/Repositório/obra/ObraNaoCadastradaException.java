package Repositório.obra;

public class ObraNaoCadastradaException extends Exception {
    public ObraNaoCadastradaException(){
        super("Obra não Cadastrada");
    }
}
