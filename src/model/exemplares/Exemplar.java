package model.exemplares;
import model.obra.Obra;

public class Exemplar {
    private static int id=1 ;
    private String id_exemplar;
    private Obra obra;


    public Exemplar(Obra obra){

        this.id_exemplar = String.valueOf(Exemplar.id);
        id++;
        this.obra = obra;



    }
    public  String getId(){
        return this.id_exemplar;
    }





    public Obra getObra(){
        return this.obra;
    }

    public void setObra(Obra obra){
        this.obra= obra;
    }

    @Override
    public String toString() {
        return "exemplar{" +
                "id=" + id +
                ", obra=" + obra +
                '}';
    }
}
