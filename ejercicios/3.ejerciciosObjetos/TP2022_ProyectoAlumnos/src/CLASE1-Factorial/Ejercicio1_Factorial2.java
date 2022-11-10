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
public class Ejercicio1_Factorial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       int aux = 1, i = 9, j ;
       for(i=1; i<=9 ; i++){ //for para que sea de 1 a 9
           if(i % 2 != 0){
               for(j=1; j<i; j++){    //for del factorial
                   aux = aux*(j+1);                                                     
            }
            System.out.println("FACTORIAL DE " + i + " es : "  +  aux);
            aux = 1; //reseteamos para que no guarde el resultado anterior
            }
       }
    }
    
}
