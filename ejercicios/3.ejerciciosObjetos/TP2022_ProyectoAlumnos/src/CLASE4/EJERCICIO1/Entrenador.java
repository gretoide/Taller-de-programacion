/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASE4.EJERCICIO1;

import CLASE3.EJERCICIO3.*;

/**
 *
 * @author Greta Piacentini
 */
public class Entrenador {
    private String nombre;
    private double sueldoBasico;
    private int añosAntiguedad;
    private int campeonatosGanados;

    public Entrenador(String nombre, double sueldoBasico, int añosAntiguedad, int campeonatosGanados) {
        this.nombre = nombre;
        this.sueldoBasico = sueldoBasico;
        this.añosAntiguedad = añosAntiguedad;
        this.campeonatosGanados = campeonatosGanados;
    }

    public Entrenador(){}
    
    //getters
    public String getNombre() {
        return nombre;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public int getAntiguedad() {
        return añosAntiguedad;
    }

    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }
    
    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public void setAntiguedad(int antiguedad) {
        this.añosAntiguedad = antiguedad;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }

    public int calcularEfectividad(){
        int antiguedad;
        antiguedad = this.campeonatosGanados/this.añosAntiguedad;
        return antiguedad;
    }
    
    public double calcularSueldoACobrar(){
        double sueldoACobrar = 0;
        double porcentaje = this.añosAntiguedad*10; //10% x por años de antieguedad
        sueldoACobrar = this.sueldoBasico + ((porcentaje*this.sueldoBasico)/100); //calculamos
        if((this.campeonatosGanados>=1)&&(this.campeonatosGanados<=4)){
            sueldoACobrar = sueldoACobrar + 5000;
        }
        else if((this.campeonatosGanados>=5)&&(this.campeonatosGanados<=10)){
            sueldoACobrar = sueldoACobrar + 30000;
        }
        else if(this.campeonatosGanados>10){
            sueldoACobrar = sueldoACobrar + 50000;
        }
        return sueldoACobrar;
    }
    
    @Override
    public String toString() {
        return "Entrenador"+ "\n" + "Nombre: " + nombre + "\n" + "SueldoBasico: " + sueldoBasico +"\n"+ "Antiguedad: " + añosAntiguedad +"\n"+ "CampeonatosGanados: " + campeonatosGanados;
    }
    
    
}
