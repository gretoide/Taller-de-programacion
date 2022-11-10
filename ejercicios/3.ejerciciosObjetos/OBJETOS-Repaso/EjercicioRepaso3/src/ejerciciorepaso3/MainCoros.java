/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciorepaso3;

/**
 *
 * @author Greta Piacentini
 */
public class MainCoros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Director directorsito1 = new Director("Adrian",2133443,34,12);
        Semicirculo corito1 = new Semicirculo(directorsito1,3,"El trio");
        
        Coristas corista1 = new Coristas("Jeje",12,33233,3);
        Coristas corista2 = new Coristas("Jaja",12,33233,2);
        Coristas corista3 = new Coristas("Juju",12,33233,1);
        
        corito1.agregarCorista(corista3);
        corito1.agregarCorista(corista2);
        corito1.agregarCorista(corista1);
        
        System.out.println(corito1.toString());
        
        if(corito1.estaLleno()){
            System.out.println("El coro está bien formado: " + corito1.estaFormado());
        }
        
        //segundo coro
        System.out.println("------------------------------------");
        Director directorsito2 = new Director("Pepito",2133443,34,12);
        Hilera corito2 = new Hilera(directorsito2,4,4,"Los Panas");
        
        Coristas corista4 = new Coristas("Jeje",12,33233,4);
        Coristas corista5 = new Coristas("Jaja",12,33233,4);
        Coristas corista6 = new Coristas("Juju",12,33233,4);
        Coristas corista7 = new Coristas("Jeje",12,33233,4);
        Coristas corista8 = new Coristas("Jaja",12,33233,4);
        Coristas corista9 = new Coristas("Juju",12,33233,4);
        
        corito2.agregarCorista(corista4);
        corito2.agregarCorista(corista5);
        corito2.agregarCorista(corista6);
        corito2.agregarCorista(corista7);
        corito2.agregarCorista(corista8);
        corito2.agregarCorista(corista9);        
        
        System.out.println(corito2.toString());
        
        if(corito2.estaLleno()){
            System.out.println("El coro está bien formado: " + corito2.estaFormado());
        }
    }   
}
