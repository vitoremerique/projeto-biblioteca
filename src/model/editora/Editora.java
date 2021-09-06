package model.editora;

public class Editora {
    private String cidade; 
    private String nome;
   
    public Editora(String cidade, String nome){
        this.cidade = cidade;
        this.nome = nome;
    }
    
    public String getCidade(){
        return this.cidade;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
