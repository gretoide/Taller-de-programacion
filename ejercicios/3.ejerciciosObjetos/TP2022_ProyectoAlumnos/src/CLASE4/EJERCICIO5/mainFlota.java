/*
5-A- Definir una clase para representar flotas de micros. Una flota conoce a los micros que
la componen (a lo sumo 15). Provea un constructor para crear una flota vacía (sin micros).
Implemente métodos para:
i. devolver si la flota está completa (es decir, si tiene 15 micros o no).
ii. agregar a la flota un micro que se recibe.
iii. buscar en la flota un micro con destino igual a uno que se recibe y retornarlo (en
caso de no existir dicho micro, retornar null).
B- Realice un programa que cree una flota vacía. Cargue varios micros (sin pasajeros) a la
flota. Luego, lea un destino e informe si en la flota hay un micro que va a ese destino.
 */
package CLASE4.EJERCICIO5;

/**
 *
 * @author Greta Piacentini
 */
public class mainFlota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Flota flotita = new Flota();
        
        Micro micrito1 = new Micro("Tandil","dfsf123",2);
        Micro micrito2 = new Micro("Mar del Plata","drserf123",17);
        Micro micrito3 = new Micro("Jujuy","d78f123",2);
        Micro micrito4 = new Micro("San Clemente","d44f123",22);
        Micro micrito5 = new Micro("Las Toninas","kllj333",2);
        
        flotita.agregarMicro(micrito1);
        flotita.agregarMicro(micrito2);
        flotita.agregarMicro(micrito3);
        flotita.agregarMicro(micrito4);
        flotita.agregarMicro(micrito5);
        
        flotita.imprimirFlota();
        System.out.println("---------------Enunciados-------------");
        System.out.println("Flota completa: " + flotita.flotaCompleta());
        System.out.println("Micro que va a Tandil: " + flotita.buscarMicro("Tandil"));
    }
    
}
