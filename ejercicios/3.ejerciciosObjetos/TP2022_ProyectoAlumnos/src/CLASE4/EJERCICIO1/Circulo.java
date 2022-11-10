/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASE4.EJERCICIO1;

import CLASE3.EJERCICIO4.*;

/**
 *
 * @author Greta Piacentini
 */
public class Circulo {
    private double radio;
    private String colorRelleno;
    private String colorLinea;
    
    //constructor

public Circulo(double radio, String colorRelleno, String colorLinea){
    this.radio = radio;
    this.colorRelleno = colorRelleno;
    this.colorLinea = colorLinea;
}

public Circulo(){}
    
    //getters

    public double getRadio() {
        return radio;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }
    
    //setters

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }

    @Override
    public String toString() {
        return "Circulo" +"\n"+ "Radio: " + radio +"\n" + "ColorRelleno: " + colorRelleno +"\n"+ "ColorLinea: " + colorLinea;
    }
    
    //metodos
    
    public double calcularPerimetro(){
        double perimetro = (2*Math.PI)*this.radio;
        return perimetro;
    }
    
    public double calcularArea(){
        double area = Math.PI*Math.pow(radio,2);
        return area;
    }
    
    
}
