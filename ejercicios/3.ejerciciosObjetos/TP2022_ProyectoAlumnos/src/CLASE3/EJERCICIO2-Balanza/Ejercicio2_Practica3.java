/*
2-A- Definir una clase para representar balanzas comerciales (para ser utilizadas en
verdulerías, carnicerías, etc). Una balanza comercial sólo mantiene el monto y la cantidad
de items correspondientes a la compra actual (es decir, no almacena los ítems de la
compra). La balanza debe responder a los siguientes mensajes:
- iniciarCompra(): inicia el monto y la cantidad de ítems para la compra actual.
- registrarProducto(pesoEnKg, precioPorKg): recibe el “peso en kilos” del ítem comprado
y su “precio por kilo”, y actualiza el estado de la balanza.
- getMonto(): retorna el monto a pagar por la compra actual.
- getResumenDeCompra(): retorna un String del siguiente estilo “Total a pagar X por la
compra de Y productos” , donde X es el monto e Y es la cantidad de ítems de la compra.
B- Realizar un programa que instancie una balanza e inicie una compra. Lea desde teclado
información de los ítems comprados (peso en kg y precio por kg) hasta ingresar peso 0.
Registre cada producto en la balanza. Al finalizar, informe el resumen de la compra.
 */
package CLASE3.EJERCICIO2;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Greta Piacentini
 */
public class Ejercicio2_Practica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Balanza balanzita;
        balanzita = new Balanza();
        double pesoKg = 0; 
        double precioKg = 0;
        GeneradorAleatorio.iniciar();
        for(int i=0;i<10;i++){
            balanzita.iniciarCompra();
            for(int j=0;j<20;j++){ //para que las compras tengan mas items
                System.out.println("Ingrese peso por KG: "); pesoKg = GeneradorAleatorio.generarDouble(10);
                System.out.println("Ingrese precio por KG: "); precioKg = GeneradorAleatorio.generarDouble(10);
                balanzita.registrarProducto(pesoKg, precioKg);
            }
            System.out.println(balanzita.resumenDeCompra());
            System.out.println("__________________________________________");
        }
    }
    
}
