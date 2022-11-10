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
public class Coristas {
    private String nombre;
    private int dni;
    private int edad;
    private int tonoFundamental;

    public Coristas(String nombre, int dni, int edad, int tonoFundamental) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.tonoFundamental = tonoFundamental;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public int getTonoFundamental() {
        return tonoFundamental;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTonoFundamental(int tonoFundamental) {
        this.tonoFundamental = tonoFundamental;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre +"\n"+ "dni=" + dni +"\n"+ "edad=" + edad +"\n"+ "tonoFundamental=" + tonoFundamental;
    }
    
    
}
