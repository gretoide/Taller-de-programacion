/*
5- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.
a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
40 cupos de casting.
Una vez finalizada la inscripción:
b) Informar para cada día y turno el nombre de la persona a entrevistar.
NOTA: utilizar la clase Persona y pensar en la estructura de datos a utilizar
 */
package CLASE2.EJERCICIO5;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Greta Piacentini
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int fila = 5;
        int columna = 8;
        int i=0; int j=0;
        Persona persona;
        String nombre; int edad; int dni;
        Persona matriz[][] = new Persona[fila][columna];
        
        //CARGAMOS LA MATRIZ
        System.out.print("INGRESE NOMBRE, DNI Y EDAD: - "); 
        nombre = GeneradorAleatorio.generarString(10);
        while((i<fila)&&(!(nombre.equals("ZZZ")))){
            j=0;
            while((j<columna)&&(!(nombre.equals("ZZZ")))){
                dni = GeneradorAleatorio.generarInt(3);
                edad = GeneradorAleatorio.generarInt(10);
                persona = new Persona(nombre,dni,edad);
                matriz[i][j]= persona;
                System.out.print("INGRESE NOMBRE, DNI Y EDAD: - "); 
                nombre = GeneradorAleatorio.generarString(3);
                j++;
            }
            i++;
        }      
       
        //RECORRE MIENTRAS SEA != DE NULL
        i=0;j=0;
        while((i<fila)&&(matriz[i][j] != null)){
            while((j<columna)&&(matriz[i][j] != null)){
                System.out.println("Dia " + (i+1) + ", Turno " + (j+1) + " - " + matriz[i][j].getNombre());
                j++;
            }
         j=0;
         i++;
        }
        
        /*for(i=0; i<fila; i++){
            for(j=0; j<columna; j++){
                System.out.println("Dia " + i + ", Turno " + j + " - " + matriz[i][j].getNombre()); //cambia los indices para buscar por columna                                      
            }
        }*/
 
    }
    
}
