/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Greta Piacentini
 */
public class Proyecto {
    private String nombre;
    private String codigo;
    private String apellidoDirector;
    private Investigador investigadores[];
    private int dimf;
    private int diml;
    
    public Proyecto(String unNombre, String unCodigo){
        this.nombre = unNombre;
        this.codigo = unCodigo;
        this.apellidoDirector = "fulanito";
        this.dimf = 50;
        this.diml = 0;
        this.investigadores = new Investigador[dimf];
    }
    
    public double dineroTotalOtorgado(){
        double total = 0;
        int i = 0;
        for(i=0;i<diml;i++){
            total = total + investigadores[i].dineroOtorgado();
        }
        return total;
    }
    
    public int cantSubsidios(String nombre){
        int cantSubsidios = 0;
        int i = 0;
        boolean ok = false;
        while((i<diml)&&(!ok)){
            if(investigadores[i].getNombre().equals(nombre)){
                cantSubsidios = investigadores[i].getDiml();
            }
            i++;
        }
        return cantSubsidios;
    }
    
    public void agregarInvestigador(Investigador unInvestigador){
        if(diml<dimf){
            this.investigadores[diml] = unInvestigador;
            this.diml++;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getApellidoDirector() {
        return apellidoDirector;
    }

    public void setApellidoDirector(String apellidoDirector) {
        this.apellidoDirector = apellidoDirector;
    }

    @Override
    public String toString() {
        String aux;
        aux = "Nombre del proyecto: " + this.nombre + "\n" +
                "Director del proyecto: " + this.apellidoDirector + "\n";
        for(int i = 0;i<diml;i++){
            aux = aux + investigadores[i].toString() + "\n";
        }
        return aux;
    }
    
    
    
    
}
