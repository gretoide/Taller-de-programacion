/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASE4.EJERCICIO3;

import PaqueteLectura.Lector;

/**
 *
 * @author Greta Piacentini
 */
public class estanteMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int dimF;
        System.out.println("Ingrese la dimencion que quiere del estante");
        dimF = Lector.leerInt();
        Estante estante = new Estante(dimF);
        Autor autorsito = new Autor();
        Libro libro= new Libro();                   
        autorsito = new Autor("Adrián Sambido", "Otra vez en la facul", "Berisso");
        libro   = new  Libro( "Java: A Beginner's Guide", "Mcgraw-Hill", 2014, autorsito, "978-0071809252", 21.72);           
        estante.agregarLibro(libro);           
        autorsito = new Autor("Greta Piacentini", "Sigo Recursando", "Gonet");
        libro   = new  Libro( "Taller", "Mcgraw-Hill", 2000, autorsito, "978-0071809253", 21.75);
        estante.agregarLibro(libro);           
        autorsito = new Autor("Martín González", "Cargo datos", "Barrio Cementerio");
        libro   = new  Libro( "Java: A Beginner's Guide", "Mcgraw-Hill", 2002, autorsito, "978-0071809254", 21.77);
        estante.agregarLibro(libro);           
        autorsito = new Autor("Anonimo", "Desconocida", "El más allá");
        libro   = new  Libro( "Mujercitas", "Capeluz", 1999, autorsito, "978-0071809255", 21.79);
        estante.agregarLibro(libro);
        autorsito = new Autor("E profe", "Facultad", "Aula 4");
        libro   = new  Libro( "Mujer", "peluza", 1991, autorsito, "978-0071809256", 22.79);
        estante.agregarLibro(libro);
        System.out.println("FALSE = estante incompleto / TRUE estante lleno: "   + estante.estanteLleno());
        Libro libroBuscado = estante.devolverLibro("Mujercitas");
        System.out.println("El autor del libro 'Mujercitas' es: " + libroBuscado.getPrimerAutor().toString());                   
    }  
}
