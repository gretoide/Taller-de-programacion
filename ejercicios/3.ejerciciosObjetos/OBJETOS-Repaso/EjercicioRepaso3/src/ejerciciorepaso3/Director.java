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
public class Director {
    private String nombre;
    private int dni;
    private int edad;
    private int antiguedad;

    public Director(String nombre, int dni, int edad, int antiguedad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.antiguedad = antiguedad;
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

    public int getAntiguedad() {
        return antiguedad;
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

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Nombre = " + nombre +"\n"+ "dni = " + dni +"\n"+ "edad = " + edad +"\n"+ "Antiguedad = " + antiguedad;
    }
    
    
}
