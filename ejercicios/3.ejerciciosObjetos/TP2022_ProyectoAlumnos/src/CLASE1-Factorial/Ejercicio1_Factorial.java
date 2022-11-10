package CLASE1;
/*1- En el programa Demo08Vector escriba las instrucciones necesarias para:
- generar enteros aleatorios hasta obtener el número 11. Para cada número
muestre el resultado de multiplicarlo por 2 (accediendo al vector).*/


import PaqueteLectura.Lector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Greta Piacentini
 */
public class Ejercicio1_Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int aux = 1, j ;
       System.out.println("INGRESE NUM: ");int i = Lector.leerInt();
       for(j=1; j<i; j++){ //for del factorial
           aux = aux*(j+1);
       }
       System.out.println("FACTORIAL DE " + i + " es : "  +  aux);
    }
    
}
