package model.obra;

import model.autor.Autor;
import model.editora.Editora;


public class Obra {


    private int isbn;
    private String isbn_;
    private String titulo;
    private String ano;
    private String edicao;
    private String sessao;
    private Autor autor;
    private Editora editora;


    public Obra(int isbn, String titulo, String ano, String edicao, String sessao,Autor autor, Editora editora ){

        this.titulo = titulo;
        this.isbn_ = String.valueOf(isbn);

        this.ano = ano;
        this.edicao = edicao;
        this.sessao = sessao;
        this.autor = autor;


        this.editora = editora;



    }
    public Editora getEditora(){
        return editora;
    }
    public String getIsbn(){
        return isbn_;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public String getAno(){
        return this.ano;
    }
    public String getEdicao(){
        return this.edicao;
    }
    public String getSessao(){
        return this.sessao;
    }

    public Autor getAutor(){
        return this.autor;
    }



    public void setIsbn(int isbn){
        this.isbn = isbn;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAno(String ano){
        this.titulo = titulo;
    }
    public void setEdicao(String edicao){
        this.edicao = edicao;
    }
    public void setSessao(String sessao){
        this.sessao = sessao;
    }




    public String toString(){
        return "Titulo: " + this.getTitulo() +
                "\nAno: " + this.getAno() +
                "\nEdição: " + this.getEdicao() +
                "\nSessão: " + this.getSessao() +
                "\nAutor: " + autor.getNome() +
                "\nNascionalidade: " + autor.getNascionalidade();
    }
}
