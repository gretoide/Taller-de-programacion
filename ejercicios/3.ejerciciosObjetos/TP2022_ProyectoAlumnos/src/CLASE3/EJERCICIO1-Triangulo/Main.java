/*
1-A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el
tamaño de sus 3 lados (double), el color de relleno (String) y el color de línea (String).
El triángulo debe saber:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el área y devolverla (método calcularArea)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
B- Realizar un programa que instancie un triángulo, le cargue información leída desde
teclado e informe en consola el perímetro y el área.
NOTA: Calcular el área con la fórmula Área = √s(s − a)(s − b)(s − c) , donde a, b y c son
los lados y s =
a+b+c
2
. La función raíz cuadrada es Math.sqrt(#)

 */
package CLASE3.EJERCICIO1;

/**
 *
 * @author Greta Piacentini
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Triangulo triangulito;
        Triangulo triangulito2;
        triangulito = new Triangulo(20,20,20,"Verde","Amarillo");
        triangulito2 = new Triangulo();
        
        //prueba de setters y getters
        triangulito2.setColorRelleno("Verde");
        triangulito2.setColorLinea("Rosa");
        triangulito2.setLado1(30);
        triangulito2.setLado2(30);
        triangulito2.setLado3(30);
        
        System.out.println("TRIANGULO 1");
        System.out.println(triangulito.toString());
        System.out.println("AREA DE TRIANGULO: " + triangulito.calcularArea());
        System.out.println("PERIMETRO TRIANGULO: " + triangulito.calcularPerimetro());
        
        System.out.println("_____________________________________________________________");

        System.out.println("TRIANGULO 2");
        System.out.println(triangulito2.toString());
        System.out.println("AREA DE TRIANGULO: " + triangulito2.calcularArea());
        System.out.println("PERIMETRO TRIANGULO: " + triangulito2.calcularPerimetro());        
    }
    
}
