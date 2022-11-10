/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASE4.EJERCICIO3;

import CLASE4.EJERCICIO2.*;

/**
 *
 * @author Greta Piacentini
 */
public class Autor {
    private String nombre;
    private String biografia;
    private String origen;
    
    //constructor

    public Autor(String nombre, String biografia, String origen ) {
        this.nombre = nombre;
        this.biografia = biografia;
        this.origen = origen;
    }
    
    public Autor(){}
    
    //setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    
    //getters

    public String getNombre() {
        return nombre;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getOrigen() {
        return origen;
    }

    @Override
    public String toString() {
        return "Autor" + "\n" + "Nombre: " + nombre + "\n" + "Biografia: " + biografia +"\n"+ "Origen: " + origen;
    }
     
    
    
    
}
