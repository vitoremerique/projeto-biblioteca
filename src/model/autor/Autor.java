package model.autor;

public class Autor {
    private String nome;
    private String nascionalidade;

    public Autor(String nome, String nascionalidade){
        this.nome = nome;
        this.nascionalidade = nascionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }
    public String getNascionalidade() {
        return nascionalidade;
    }

    public void setNascionalidade(String nascionalidade) {
        this.nascionalidade = nascionalidade;
    }
}
