/*
3-A- Definir una clase para representar entrenadores de un club. Un entrenador se
caracteriza por su nombre, sueldo básico, antigüedad y cantidad de campeonatos ganados.
- Defina métodos para obtener/modificar el valor de cada atributo.
- Defina el método calcularEfectividad que devuelve la efectividad del entrenador, que
es el promedio de campeonatos ganados por año de antigüedad.
- Defina el método calcularSueldoACobrar que devuelve el sueldo a cobrar por el
entrenador. El sueldo a cobrar es el sueldo básico agregando un 10% del básico por
año de antigüedad, y además se adiciona un plus por campeonatos ganados (5000$ si
ha ganado entre 1 y 4 campeonatos; $30.000 si ha ganado entre 5 y 10 campeonatos;
50.000$ si ha ganado más de 10 campeonatos).
B- Realizar un programa que instancie un entrenador, cargándole datos leídos desde
teclado. Informe el sueldo a cobrar y la efectividad del entrenador.
 */
package CLASE3.EJERCICIO3;

/**
 *
 * @author Greta Piacentini
 */
public class MainEntrenador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Entrenador entrenador1;
        Entrenador entrenador2;
        Entrenador entrenador3;
        
        entrenador1 = new Entrenador("Maximo Cozzeti",8,8);
        entrenador2 = new Entrenador("Lampone",11,11);
        entrenador3 = new Entrenador("Medina",1,2);
        System.out.println(entrenador1.toString());
        System.out.println("Sueldo a cobrar: " + entrenador1.calcularSueldoACobrar());
        System.out.println("Efectividad: " + entrenador1.calcularEfectividad());
        System.out.println("________________________________");
        System.out.println(entrenador2.toString());
        System.out.println("Sueldo a cobrar: " + entrenador2.calcularSueldoACobrar());
        System.out.println("Efectividad: " + entrenador2.calcularEfectividad());       
        System.out.println("________________________________");
        System.out.println(entrenador3.toString());
        System.out.println("Sueldo a cobrar: " + entrenador3.calcularSueldoACobrar());
        System.out.println("Efectividad: " + entrenador3.calcularEfectividad());        
        System.out.println("________________________________");
        }
    }   
