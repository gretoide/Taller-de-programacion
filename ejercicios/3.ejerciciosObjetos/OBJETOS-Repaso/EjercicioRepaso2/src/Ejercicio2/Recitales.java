/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author Greta Piacentini
 */
public abstract class Recitales{
    private String nombreBanda;
    private String temas[];
    private int dimf;
    private int diml;
    
    public abstract boolean Finalizar();
    
    public abstract double calcularCosto();
    
    public Recitales(String unaBanda, int nTemas){
        this.nombreBanda = unaBanda;
        this.dimf = nTemas;
        this.diml = 0;
        this.temas = new String[dimf];
    }
    
    public void agregarTema(String unTema){
        if(diml<dimf){
            temas[diml]=unTema;
            diml++;
        }
    }
    
    public String actuar(){
        String aux = "";
        for(int i=0;i>diml;i++){
            aux = "Ahora tocaremos..." + temas[i] + "\n";
        }
        return aux;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public void setDimf(int dimf) {
        this.dimf = dimf;
    }

    public void setDiml(int diml) {
        this.diml = diml;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public int getDimf() {
        return dimf;
    }

    public int getDiml() {
        return diml;
    }
}
