/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciorepaso3;

/**
 *
 * @author Greta Piacentini
 */
public class Semicirculo extends Coro{
    private Coristas vector[];
    private int dimf;
    private int diml;

    public Semicirculo(Director unDirector, int dimf, String unNombreCoro) {
        super(unNombreCoro,unDirector);
        this.dimf = dimf;
        this.diml = 0;
        this.vector = new Coristas[dimf];   
    }

    public int getDimf() {
        return dimf;
    }

    public int getDiml() {
        return diml;
    }

    //metodos
    
    public void agregarCorista(Coristas unCorista){
        if(diml < dimf){
             vector[diml]=unCorista;
             this.diml++;
        }
    }
    
    public boolean estaLleno(){
        boolean ok = false;
        if(this.diml == this.dimf){
            ok=true;
        }
        return ok;
    }
    
    public boolean estaFormado(){
        boolean ok = true;
        int i=0;
        while((i<(dimf-1))&&(ok)){
            if(vector[i].getTonoFundamental() < vector[i+1].getTonoFundamental()){
                i++;
            }
            else{
                ok = false;
            }
        }
        return ok;
    }
    
    @Override
    public String toString(){
       String aux = "";
       String coristas = "Serie de coristas" + "\n";
       aux = "Nombre del coro: " + super.getNombreCoro() + "\n"
               + "Datos del director: " + super.getUnDirector().toString() + "\n";
       for(int i=0;i<dimf;i++){
           coristas = coristas + this.vector[i].toString() + "\n";
       }
       return aux + coristas;
    }

}
