/*
1-A– Defina constructores para las clases Triángulo, Círculo y Entrenador (en la carpeta
tema3). En los tres casos declare:
- Un primer constructor que reciba todos los datos necesarios para iniciar el objeto.
- Un segundo constructor que no posea parámetros ni código (constructor nulo).
B- Incluya en los programas respectivos (de la carpeta tema3) el código necesario para
instanciar triángulos, círculos y entrenadores usando en cada caso el primer constructor.
 */
package CLASE4.EJERCICIO1;

/**
 *
 * @author Greta Piacentini
 */
public class mainFiguras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circulo circulito = new Circulo(20,"amarillo","azul");
        Triangulo triangulito = new Triangulo(10,10,10,"rojo","azul");
        Entrenador entrenador = new Entrenador("Juan",10000,10,5);
        System.out.println(circulito.toString());
        System.out.println("-----------------------------");
        System.out.println(triangulito.toString());
        System.out.println("-----------------------------");
        System.out.println(entrenador.toString());
    }
    
}
