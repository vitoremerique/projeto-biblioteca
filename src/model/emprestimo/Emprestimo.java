package model.emprestimo;

import java.time.LocalDate;


import model.exemplares.Exemplar;

import model.usuario.Usuario;

public class Emprestimo {
    private String id;


    private LocalDate datainicio;

    private Usuario usuario;
    private Exemplar exemplar;
    private boolean devolveu;
    
    public Emprestimo(

      LocalDate datainicio,

        Usuario usuario,
      Exemplar exemplar,
      boolean devolveu)
    {
        this.id = exemplar.getId();

        this.datainicio = datainicio;

        this.usuario = usuario;
        this.exemplar = exemplar;
        this.devolveu = devolveu;

    }

    public String getId() {
      return this.id;
    }





    @Override
    public String toString() {
        return "emprestimo -->" +
                "id: " + id +
                "| datainicio: " + datainicio +

                "| usuario: " + usuario.getNome() +
                "| exemplar: " + exemplar.getObra().getTitulo() ;

    }

    public LocalDate getLocalDateinicial() {
      return this.datainicio;
    }

    public void setLocalDateTimeinicio(LocalDate dateinicio) {
      this.datainicio = datainicio;
    }


    public LocalDate getDataincial() {
        return this.datainicio;
    }



    public Usuario getUsuario () {
      return this.usuario;
    }

    public void setUsuario (Usuario usuario) {
      this.usuario = usuario;
    }

    public Exemplar getExemplar () {
      return this.exemplar;
    }

    public void setExemplar (Exemplar exemplar ) {
      this.exemplar = exemplar;
    }

    public boolean getDevolveu () {
      return this.devolveu;
    }

    public void setDevolveu (boolean devolveu) {
      this.devolveu = devolveu;
    }
}