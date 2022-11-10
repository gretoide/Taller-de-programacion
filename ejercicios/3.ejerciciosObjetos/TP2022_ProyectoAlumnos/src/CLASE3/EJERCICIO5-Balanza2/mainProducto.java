/*
5-A- Se dispone de la clase Producto (en la carpeta tema3). Un objeto producto puede
crearse sin valores iniciales o enviando en el mensaje de creación el “peso en kg” y
“descripción” (en ese orden). Un objeto producto responde a los siguientes mensajes:
getDescripcion() retorna la descripción (String) del producto
getPesoEnKg() retorna el peso en kg (double) del producto
setDescripcion(X) modifica la descripción del producto al “String” X
setPesoEnKg(X) modifica el peso del producto al “double” X
Usando la clase Producto. Realice las siguientes modificaciones a la clase del ejercicio 2-A.
Ahora la balanza debe generar un resumen de compra más completo. Agregue a la balanza
la característica resumen (String) y modifique los métodos como se indica a continuación:
- iniciarCompra para que además inicie el resumen en el String vacío.
- registrarProducto para que reciba un objeto Producto y su “precio por kg”. La
operación debe actualizar el monto y cantidad de ítems de la balanza, y concatenar al
resumen la descripción y el monto a pagar por este producto.
- getResumenDeCompra para que retorne un String del siguiente estilo: “Naranja 100$ –
Banana 40$ – Lechuga 50$ – Total a pagar 190 pesos por la compra de 3 productos”
donde la parte subrayada es el contenido de resumen.
B- Realice las modificaciones necesarias en el programa principal solicitado en 2-B para
corroborar el funcionamiento de la balanza. 
 */
package CLASE3.EJERCICIO5;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Greta Piacentini
 */
public class mainProducto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Balanza balanzita;
        balanzita = new Balanza();
        double pesoKg = 0; 
        double precioKg = 0;
        String producto;
        for(int i=0;i<10;i++){
            balanzita.iniciarCompra();
            for(int j=0;j<10;j++){ //para que las compras tengan mas items
                System.out.println("Ingrese nombre del producto: "); producto = GeneradorAleatorio.generarString(10);
                System.out.println("Ingrese peso por KG: "); pesoKg = GeneradorAleatorio.generarDouble(10);
                System.out.println("Ingrese precio por KG: "); precioKg = GeneradorAleatorio.generarDouble(10);
                balanzita.registrarProducto(pesoKg, precioKg, producto);
            }
            System.out.println(balanzita.resumenDeCompra());
            System.out.println("__________________________________________");
        }
    }
}
