/*
4-A- Definir una clase para representar micros. Un micro conoce su patente, destino, hora
de salida, el estado de sus 20 asientos (boolean: true ocupado, false libre) y la cantidad de
asientos ocupados al momento. Lea detenidamente a) y b) y luego implemente.
a) Implemente un constructor que permita iniciar el micro con una patente, un destino y
una hora de salida (que se reciben) y con sus asientos libres.
b) Implemente métodos para:
i. devolver/modificar patente, destino y hora de salida
ii. devolver la cantidad de asientos ocupados
iii. devolver si el micro está lleno
iv. validar un nro. de asiento que se recibe (es decir, devolver si está en rango o no)
v. devolver el estado de un nro. de asiento válido que se recibe
vi. ocupar un nro. de asiento válido que se recibe
vii. liberar un nro. de asiento válido que se recibe
viii. devolver el nro. del primer asiento libre

 */
package CLASE4.EJERCICIO4;

import PaqueteLectura.Lector;

/**
 *
 * @author Greta Piacentini
 */
public class mainMicros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numero;
        Micro micrito = new Micro("ABC123","Mar del Plata",5);
        for(int i=0;i<5;i++){
            System.out.println("Ingrese un numero: "); numero = Lector.leerInt();
            if(micrito.validarAsiento(numero)){
                if(micrito.estadoAsiento(numero)==false){
                    micrito.ocuparAsiento(numero);
                    System.out.println("La operacion se realizó con éxito");
                }
                else{
                    System.out.println("El asiento [" + numero +"] está ocupado" + "\n" + "El primer asiento libre es: " + micrito.primerAsientoLibre());
                }
            }   
        }
        System.out.println("Cant asientos ocupados: " + micrito.cantOcupados());
    }
    
}
