/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASE4.EJERCICIO5;

/**
 *
 * @author Greta Piacentini
 */
public class Flota {
    private Micro flota[];
    private int cantMicros;
    private int microsActuales;
    
    //constructor
    public Flota(){
        this.cantMicros = 15;
        this.microsActuales = 0;
        this.flota = new Micro[cantMicros];
    }
    
    //metodos
    public boolean flotaCompleta(){
        boolean ok = false;
        if(cantMicros == microsActuales){
            ok=true;
        }
        return ok;
    }
    
    public void agregarMicro(Micro unMicro){
        if(this.microsActuales<=this.cantMicros){
            this.flota[microsActuales]=unMicro;
            this.microsActuales++;
        }
    }
    
    public Micro buscarMicro(String unDestino){
        Micro micrito = null;
        int i = 0;
        while((i<microsActuales)&&(!(flota[i].getDestino().equals(unDestino)))){
            i++;
        }
        if(i<microsActuales){
            micrito = flota[i];
        }
        return micrito;
    }
    
    public void imprimirFlota(){
        for(int i=0;i<microsActuales;i++){
            System.out.println("--------------------------");
            System.out.println(flota[i].toString());
        }
    }
}
