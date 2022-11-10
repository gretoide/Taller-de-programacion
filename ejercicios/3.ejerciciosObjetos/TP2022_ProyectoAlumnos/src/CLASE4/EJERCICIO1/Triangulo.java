/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASE4.EJERCICIO1;

import CLASE3.EJERCICIO1.*;

/**
 *
 * @author Greta Piacentini
 */
public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String colorRelleno;
    private String colorLinea;
    
    
    //CONSTRUCTOR DE TRIANGULO CON TODOS SUS ATRIBUTOS

    public Triangulo(double lado1, double lado2, double lado3, String colorRelleno, String colorLinea) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
    }
 
    public Triangulo(){}

    //SETTERS
    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }
    
    //GETTERS

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    @Override
    public String toString() {
        return "Lado1: " + lado1 + "\n" + "Lado2: " + lado2 + "\n"+ "Lado3: " + lado3 + "\n"+ "ColorRelleno: " + colorRelleno + "\n"+ "ColorLinea: " + colorLinea;
    }
    
    //enunciado A
    public double calcularArea(){
        double s = (this.lado1 + this.lado2 + this.lado3)/2;
        double area = 0;
        area = Math.sqrt(s*((s-this.lado1)*(s-this.lado2)*(s-this.lado3)));
        
        return area;
        }
        
    //enunciado B
    public double calcularPerimetro(){
        return (this.lado1+this.lado2+this.lado3);
        }
    
    }

    
