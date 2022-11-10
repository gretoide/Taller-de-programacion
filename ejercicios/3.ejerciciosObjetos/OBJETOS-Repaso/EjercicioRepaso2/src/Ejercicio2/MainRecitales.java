/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import PaqueteLectura.Lector;

/**
 *
 * @author Greta Piacentini
 */
public class MainRecitales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("INGRESE DATOS DE LA GIRA");
        System.out.println("-------------------------");
        System.out.println("Nombre de la banda: "); String nombreBanda = Lector.leerString();
        System.out.println("Nombre de la Gira; "); String nombreGira = Lector.leerString();
        System.out.println("Nombre contratista: "); String nombreContratista = Lector.leerString();
        
        String tema1 = "You Say Run";
        String tema2 = "My Hero Academia";
        String tema3 = "Snow";
        
        Fecha fechita1 = new Fecha("La Plata",1);
        Fecha fechita2 = new Fecha("Tandil",2);
        Fecha fechita3 = new Fecha("Rio Gallegos",3);
        
        Giras girita = new Giras(nombreBanda,3,nombreContratista,"show beneficio",3,nombreGira,3);
        girita.agregarFecha(fechita1);
        girita.agregarFecha(fechita2);
        girita.agregarFecha(fechita3);
        
        girita.agregarTema(tema1);
        girita.agregarTema(tema2);
        girita.agregarTema(tema3);
        
        System.out.println("---------------------------");
        System.out.println("Costo de la Gira: " + girita.calcularCosto());
        System.out.println("Actuacion" + "\n" + girita.actuar());
        System.out.println("---------------------------");
    }
    
}
