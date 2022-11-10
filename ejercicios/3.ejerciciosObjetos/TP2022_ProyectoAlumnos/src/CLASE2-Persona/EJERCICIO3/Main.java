/*
4- Realice un programa que cargue un vector con 10 Strings leídos desde teclado. El vector
generado tiene un mensaje escondido que se forma a partir de la primera letra de cada
string. Genere un nuevo string con el mensaje escondido y muéstrelo en consola.
 */
package CLASE2.EJERCICIO3;

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
        int dimf = 10;
        String vector[] = new String[dimf]; //vector de Strings
        String stringVector; //string que se va a guardar en elvector
        String aux = ""; //String aux para descifrar el mensaje
        GeneradorAleatorio.iniciar();
        
        for(int i=0;i<dimf;i++){ //cargamos vector
            stringVector = GeneradorAleatorio.generarString(10);
            vector[i] = stringVector;
        }
        
        for(int i=0;i<dimf;i++){ //imprimimos vector
            System.out.println("STRING " + i + ": " + vector[i]);
        }
        
        for(int i=0;i<dimf;i++){ //recopilamos las iniciales
            aux = aux + " "+ vector[i].charAt(0); //concatenamos
        }
        
        System.out.println("MENSAJE OCULTO: " + aux);
    }
    
}
