package CLASE1;
/*3- Escriba un programa que defina una matriz de enteros de tamaño 10x10.
Inicialice la matriz con números aleatorios entre 0 y 200.
Luego realice las siguientes operaciones:
- Mostrar el contenido de la matriz en consola.
- Calcular e informar la suma de todos los elementos almacenados entre las
filas 2 y 9 y las columnas 0 y 3
- Generar un vector de 10 posiciones donde cada posición i contiene la suma
de los elementos de la columna i de la matriz.
- Lea un valor entero e indique si se encuentra o no en la matriz. En caso de
encontrarse indique su ubicación (fila y columna) en caso contrario
imprima “No se encontró el elemento”.*/

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author e-basura
 */
public class Ejercicio3_Matriz {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i,j; //indices
        int fila = 10; //dimF
        int columna = 10; //dimC
        int[][] matriz = new  int[fila][columna]; //creamos la matriz con sus dimensiones
        int total = 0; //variable para inciso 
        int dimf = 10; //dimension fisica del vector
        int [] vector = new int[dimf];
        boolean ok = false;
        
        GeneradorAleatorio.iniciar();
        
        for(i=0; i<fila; i++){
            for(j=0; j<columna; j++){
                matriz[i][j] = GeneradorAleatorio.generarInt(200);
            }
        }
        
        //IMPRIMIR MATRIZ (inciso A)
        for(i=0; i<fila; i++){
            for(j=0; j<columna; j++){
                System.out.println("ELEMENTO [" + i + "][" + j + "] : " + matriz[i][j]);
            }
        }
        
        //SUMAR ELEMENTOS (inciso B)
        for(i=2; i<9; i++){ 
            for(j=0; j<3; j++){ //suma total de los elementos entre las filas 2 y 9 y columnas 0 y 3
                total = total + matriz[i][j];
            }
        }
        System.out.println("SUMA: " + total);
        
        //VECTOR CON LA SUMA DE CADA COLUMNA
        for(i=0; i<fila; i++){ 
            for(j=0; j<columna; j++){ //suma toda una columna y lo agrega a un vector
                vector[i] = vector[i] + matriz[j][i];
            }
        }
        
        /*for(i=0; i<dimf; i++){
            System.out.println("SUMA DE COLUMNA " + (i+1) + ": " + vector[i]);
        }*/
        
        //BUSQUEDA EN MATRIZ
        System.out.println("INGRESE NUM: "); int num = Lector.leerInt();

    }
}
