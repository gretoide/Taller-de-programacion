/*
2-A- Modifique la clase Libro (carpeta tema 4) para ahora considerar que el primer autor
es un objeto instancia de la clase Autor. Implemente la clase Autor, sabiendo que éstos se
caracterizan por nombre, biografía y origen y que deben permitir devolver/modificar el
valor de sus atributos y devolver una representación String formada por nombre, biografía
y origen.
B- Modifique el programa Demo01Constructores (carpeta tema 4) para instanciar los
libros con su autor, considerando las modificaciones realizadas. A partir de uno de los
libros, obtenga e imprima la representación del autor de ese libro.
 */
package CLASE4.EJERCICIO2;

/**
 *
 * @author Greta Piacentini
 */
public class mainLibro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Autor autorsito = new Autor("Maximo Cozzeti","Miembro de los simuladores.","Indefinido (?)");
        Libro librito = new Libro("Cronicas de Mario Santos",autorsito,"isbn",4000);
        System.out.println("LIBRO COMPLETO" + "\n" + librito.toString());
        System.out.println("---------------------------");
        System.out.println(librito.getPrimerAutor().toString());
    }
    
}
