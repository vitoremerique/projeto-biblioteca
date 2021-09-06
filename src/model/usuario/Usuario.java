package model.usuario;

public class Usuario {
    private static int id_Usuario=1;
    private String id;
    private String nome;
    private String endereco;
    private String curso;
    public Usuario(String nome, String endereco, String curso){
        this.id = String.valueOf(id_Usuario);
        this.nome = nome;
        this.endereco = endereco;
        this.curso = curso;
        id_Usuario++;

    }

    public String getNome() {
        return nome;
    }
    public String getEndereco(){
        return endereco;
    }

    public String getCurso(){
        return curso;
    }
    public String getId_Usuario(){
        return this.id;
    }


    public void setCurso (String curso){
        this.curso = curso;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String toString(){
        return "Nome: " + this.getNome() +
                "\nEndereço: " + this.getEndereco() +
                "\nCurso: " + this.getCurso();
    }



}
