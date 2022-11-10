package CLASE1;

import PaqueteLectura.Lector;

/*
 5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen
(con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad
de la comida (2) Precio (3) Ambiente.
Escriba un programa que lea desde teclado las calificaciones de los cinco clientes
para cada uno de los aspectos y almacene la información en una estructura. Luego
imprima la calificación promedio obtenida por cada aspecto.
        
---------------------- MATRIZ --------------------
|CLIENTE 1| - [atencion][calidad][precio][ambiente] |
|CLIENTE 2| - [atencion][calidad][precio][ambiente] |
|CLIENTE 3| - [atencion][calidad][precio][ambiente] | Promediamos por columna
|CLIENTE 4| - [atencion][calidad][precio][ambiente] |
|CLIENTE 5| - [atencion][calidad][precio][ambiente] V
        
 */

/**
 *
 * @author Adrián Sambido
 */
public class Ejercicio5_Matriz{
   
    public static void main(String[] args) {
        int fila = 5; int columna = 4;
        int matriz[][] = new int[fila][columna]; // matriz de 5x4
        int dato, total = 0; 
        double promedio;
        
        for(int i=0; i<fila; i++){          // inicializao la matriz en cero
            for(int j=0; j<columna; j++){
                matriz[i][j] = 0;   
            }            
        }                
        for(int i =0; i<fila; i++){  // carga la informacion de los clientes
            System.out.println("Cliente n° " + "  "+ i);
            System.out.println("-----------------------------------------------------");
            
            System.out.println("Ingrese su calificación por la ATENCION de 1 a 10" );
            dato = Lector.leerInt();
            matriz[i][0] = matriz[i][0] + dato; //carga por columna
            
            System.out.println("Ingrese su calificación por la CALIDAD de la comida 1 a 10" );
            dato = Lector.leerInt();
            matriz[i][1] = matriz[i][1] + dato;
            
            System.out.println("Ingrese su calificación por el PRECIO 1 a 10");
            dato = Lector.leerInt();                              
            matriz[i][2] = matriz[i][2] + dato;
            
            System.out.println("Ingrese su calificación por el AMBIENTE 1 a 10");
            dato = Lector.leerInt();   
            matriz[i][3] = matriz[i][3] + dato;                                                                      
        }
        for(int i=0; i<fila; i++){
            for(int j=0; j<columna; j++){
                total = total + matriz [j][i]; //cambia los indices para buscar por columna                                      
            }
            promedio = total/5; /*sacamos el promedio dentro del for, en la siguiente iteracion  va a ser
            otro especto*/
            System.out.println("El prodedio por el aspecto " + i +  "  " + "  es: " + promedio);
            total =0; //reiniciamos la variable para el                                     
        }
    }
}
