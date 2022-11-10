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
public class Giras extends EventosOcasionales{
    private String nombreGira;
    private Fecha fechas[];
    private int dimf;
    public int diml;
    private int fechaActual;
    
    public Giras(String nombreBanda, int nTemas, String unContratista,
    String unMotivo, int diaEvento, String nombreGira, int cantFechas){
        super(nombreBanda,nTemas,unContratista,unMotivo,diaEvento);
        this.nombreGira = nombreGira;
        this.diml = 0;
        this.dimf = cantFechas;
        this.fechaActual = 0;
        this.fechas = new Fecha[dimf];
    }
    
    public void agregarFecha(Fecha unaFecha){
        if(diml<dimf){
            fechas[diml]=unaFecha;
            diml++;
        }
    }
    
    @Override
    public String actuar(){
        String aux = "";
        for(int i=0;i<diml;i++){
            aux = "Buenas noches " + fechas[fechaActual].getCiudad() + "\n" + super.actuar();
        }
        fechaActual++;
        
        return aux;
    }
    
    public boolean Finalizado(){
        boolean ok = false;
        if(fechaActual==diml){
            ok=true;
        }
        return ok;
    }
    
    @Override
    public double calcularCosto(){
        double total = 0;
        total = 30000*diml;
        return total;
    }

    public String getNombreGira() {
        return nombreGira;
    }

    public int getDimf() {
        return dimf;
    }

    public int getFechaActual() {
        return fechaActual;
    }

    public void setNombreGira(String nombreGira) {
        this.nombreGira = nombreGira;
    }

    public void setDimf(int dimf) {
        this.dimf = dimf;
    }

    public void setFechaActual(int fechaActual) {
        this.fechaActual = fechaActual;
    }
    
    
}
