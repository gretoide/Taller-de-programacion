/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASE3.EJERCICIO4;

/**
 *
 * @author Greta Piacentini
 */
public class mainCirculo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circulo circulito;
        circulito = new Circulo(2,"amarillo","verde");
        
        System.out.println(circulito.toString());
        System.out.println("Area: " + circulito.calcularArea());
        System.out.println("Perimetro: " + circulito.calcularPerimetro());
    }
    
}
