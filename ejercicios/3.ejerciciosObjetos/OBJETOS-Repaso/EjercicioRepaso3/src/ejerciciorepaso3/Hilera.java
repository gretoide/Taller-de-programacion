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
public class Hilera extends Coro {
    private Coristas hileras[][];
    private int fila;
    private int columna;
    private int dimF;
    private int dimC;
    
    public Hilera(Director unDirector, int fila, int columna, String unNombreCoro) {
        super(unNombreCoro,unDirector);
        this.dimF=0;
        this.dimC=0;
        this.fila = fila;
        this.columna = columna; 
        this.hileras = new Coristas[fila][columna];   
    }
    
    @Override
    public void agregarCorista(Coristas unCorista){
        if(this.dimF < this.fila){
            if(this.dimC < this.columna){
            hileras[dimF][dimC] = unCorista;
            dimF++;
            dimC++;
            }
        }
    }
    
    public boolean estaLleno(){
        boolean ok = false;
        if(((this.dimF+1) == fila)&&((this.dimC+1) == columna)){
            ok=true;
        }
        return ok;
    }
    
    public boolean estaFormado(){
        boolean ok = false;
        int i = 0;
        int j = 0;
        while((i<fila)&&(!ok)){
            j=0;
            if(this.hileras[i][j].getTonoFundamental() > this.hileras[i - 1][j].getTonoFundamental()){
                while((j<columna)&&(!ok)){
                    if (this.hileras[i][j].getTonoFundamental() == this.hileras[i][j + 1].getTonoFundamental()){
                        j++;
                    }
                    else{
                    ok=true;    
                    }
                }
            i++; 
            }
            else{
                ok=true;
            }
       }
       return ok;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public int getDimF() {
        return dimF;
    }

    public int getDimC() {
        return dimC;
    } 

    @Override
    public String toString(){
       String aux = "";
       String coristas = "Serie de coristas" + "\n";
       aux = "Nombre del coro: " + super.getNombreCoro() + "\n"
            + "Datos del director: " + super.getUnDirector().toString() + "\n";
       for(int i=0; i<dimF; i++){
            for(int j=0; j<dimC; j++){
                coristas +=  " Alumno: " + this.hileras[i][j].toString();
            }
        }
        return aux + coristas;
    }    
}
