package CLASE1;
/*2- Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
básquet y las almacene en un vector. Luego informe:
- la altura promedio
- la cantidad de jugadores con altura por encima del promedio
NOTA: Dispone de un esqueleto para este programa en Ej02Jugadores.java
*/

import PaqueteLectura.GeneradorAleatorio;
public class Ejercicio2_Jugadores {

    public static void main(String[] args) {
        double vector[] = new double[15];
        double promedio;
        double cantAlturas = 0;
        double cantSuperan = 0;
        GeneradorAleatorio.iniciar();
        
        for(int i=0; i<=14; i++){ //for cargador
            vector[i] = GeneradorAleatorio.generarDouble(20);
        }
        
        for(int i=0; i<=14; i++){ //for imprimidor
            System.out.println("JUGADOR " + (i+1) + ": " + vector[i]);
        }
     
        for(int i=0; i<=14; i++){ //for recorredor calculando promedio
            cantAlturas = cantAlturas + vector[i];
        }
        promedio = cantAlturas/15; //calculador promedio
        System.out.println("ALTURA PROMEDIO: " + promedio);
        
        for(int i=0; i<=14; i++){ //for recorredor calculando promedio
          if(vector[i] > promedio){
             cantSuperan++;
          }
        }
        System.out.println("CANT JUGADORES QUE SUPERAN PROMEDIO: " + cantSuperan);
    }
    
}
