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
public class EventosOcasionales extends Recitales {
    private String motivo;
    private String nombreContratista;
    private int diaEvento;
    private boolean realizado;
    
    public EventosOcasionales(String nombreBanda, int nTemas, String unContratista, String unMotivo, int dia){
        super(nombreBanda,nTemas);
        this.motivo = unMotivo;
        this.nombreContratista = unContratista;
        this.diaEvento = dia;
        this.realizado = false;
        
    }
    
    public String actuar(){
        String aux = null;
        if(motivo.equals("show beneficio")){
            aux = "Recuerde colaborar con... " + this.nombreContratista;
        }
        else if(motivo.equals("show tv")){
           aux = "Saludos queridos televidentes...";
        }
        else if(motivo.equals("show privado")){
            aux =  "Un feliz cumpleaños para..." + this.nombreContratista;
        }
        this.realizado = true;
        return aux + super.actuar();
    }
    
    @Override
    public boolean Finalizar(){
        return this.realizado;
    }
    
    @Override
    public double calcularCosto(){
        double total = 0;
        if(motivo.equals("show beneficio")){
            total = 0;
        }
        else if(motivo.equals("show tv")){
           total = 50000;
        }
        else if(motivo.equals("show privado")){
            total =  150000;
        }
        return total;
    }

    public String getMotivo() {
        return motivo;
    }

    public int getDiaEvento() {
        return diaEvento;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setNombreContratista(String nombreContratista) {
        this.nombreContratista = nombreContratista;
    }

    public void setDiaEvento(int diaEvento) {
        this.diaEvento = diaEvento;
    }
    
}
