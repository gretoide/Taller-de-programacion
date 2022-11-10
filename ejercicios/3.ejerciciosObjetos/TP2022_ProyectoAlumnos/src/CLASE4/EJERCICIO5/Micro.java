/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASE4.EJERCICIO5;

import CLASE4.EJERCICIO4.*;

/**
 *
 * @author Greta Piacentini
 */
public class Micro {
    private String destino;
    private String patente;
    private int horaSalida;
    private boolean asientos[];
    private int dimf;
    private int diml;
    
    //constructor
    public Micro(String destino, String patente, int horaSalida) {
        this.destino = destino;
        this.patente = patente;
        this.horaSalida = horaSalida;
        this.dimf = 20;
        this.diml = 0;
        this.asientos = new boolean[dimf];
        for(int i=0;i<dimf;i++){
            asientos[i] = false;
        }
    }
    
    //setters

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    //getters

    public String getDestino() {
        return destino;
    }

    public String getPatente() {
        return patente;
    }

    public int getHoraSalida() {
        return horaSalida;
    }
    
    
    //metodos
    
    public int cantOcupados(){ //.ii
        return diml;
    }
    
    public boolean microLleno(){ //iii
        boolean ok = false;
        if(diml == dimf){
            ok = true;
        }
     return ok;
    }
    
    public boolean validarAsiento(int asiento){ //iv
        boolean aux = false;
        if(asiento>=0 && asiento<= dimf){
            aux = true;
        }
        return aux;
    }
    
    public boolean estadoAsiento(int nro){ //v
        boolean ok = asientos[nro];
        return ok;
    }
    
    public void ocuparAsiento(int nro){ //vii
        if(nro<=dimf){
         asientos[nro]=true;
         this.diml++; //aumentamos la dimension logica porque ocupamos un asiento
        }
    }
        
    public void desocuparAsiento(int nro){ //vi
        if(nro<=dimf){
         asientos[nro]=false;
         this.diml--; //descendemos la diml
        }
    }
    
    public int primerAsientoLibre(){
        int i=0;
        while((i<=dimf)&&(asientos[i]==true)){
            i++;
        }
        if(i==dimf){
        i = -1;
        }
        return i;
    }

    @Override
    public String toString() {
        return "Micro" + "\n" + "Destino: " + destino +"\n"+ "Patente: " + patente +"\n"+ "HoraSalida: " + horaSalida;
    }
    
    
    
    
    
}
