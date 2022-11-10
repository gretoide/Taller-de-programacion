/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASE1;

import PaqueteLectura.Lector;

/*4- Un edificio de oficinas está conformado por 8 pisos y 4 oficinas por piso. Realice
un programa que permita informar la cantidad de personas que concurrieron a
cada oficina de cada piso. Para esto, simule la llegada de personas al edificio de la
siguiente manera: a cada persona se le pide el nro. de piso y nro. de oficina a la cual
quiere concurrir. La llegada de personas finaliza al indicar un nro. de piso 9. Al
finalizar la llegada de personas, informe lo pedido. 
*/

/**
 *
 * @author Greta Piacentini
 */
public class Ejercicio4_Matriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i=0; int j=0;
        int fila = 8; int columna = 4;
        int[][] matriz = new int[fila][columna];
        
        int piso = 0; int oficina = 0; //variables para inciso [A]
        
        //INICIALIZAMOS LA MATRIZ
        for(i=0; i<fila; i++){
            for(j=0; j<columna; j++){
                matriz[i][j] = 0;
            }
        }
        
        //LEEMOS PISO Y OFICINA Y AGREGAMOS
        System.out.println("INGRESE NRO. DE PISO: "); piso = Lector.leerInt();
        if(piso!=9){
            System.out.println("INGRESE NRO. DE OFICINA: "); oficina = Lector.leerInt();
            
        }
        while(piso != 9){
            matriz[piso][oficina] = matriz[piso][oficina] + 1;
            System.out.println("INGRESE NRO. DE PISO: "); piso = Lector.leerInt();
            if(piso!=9){
                System.out.println("INGRESE NRO. DE OFICINA: "); oficina = Lector.leerInt();
            }
        }
        
        //IMPRIMIMOS LOS RESULTADOS
        for(i=0; i<fila; i++){
            for(j=0; j<columna; j++){
                System.out.println("CANT PERSONAS ["+i+","+j+"]: " + matriz[i][j]);
            }
        }
    }
    
}
