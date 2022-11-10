/*           ----- ESTANTE -----
 3-A- Definir una clase para representar estantes. Un estante almacena a lo sumo 20 libros.
Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:
(i) devolver la cantidad de libros que almacenados (ii) devolver si el estante está lleno
(iii) agregar un libro al estante (iv) devolver el libro con un título particular que se recibe.
B- Realice un programa que instancie un estante. Cargue varios libros. A partir del estante,
busque e informe el autor del libro “Mujercitas”.
C- Piense: ¿Qué modificaría en la clase definida para ahora permitir estantes que
almacenen como máximo N libros? ¿Cómo instanciaría el estante?
 */
package CLASE4.EJERCICIO3;

/**
 *
 * @author Usuario
 */
public class Estante {
    private int dimL = 0;
    private int dimF;
    private Libro []estante;
    
    public Estante(int unValor){  // Le da al estante una dimención por parametro 
        this.dimF = unValor;
        estante = new Libro[dimF];  
    }
    
    public Estante(){}
    
    public int cantidadDeLibros(){  //inciso 1
        return this.dimL;
    }
    
    public boolean estanteLleno(){  // inciso 2
        boolean ok = false;
        if(dimL == dimF){
            ok = true;            
        }
        return ok;
    }
    
    public void agregarLibro(Libro unLibro){ // inciso 3
        if(dimL == 0){
            this.estante[0] = unLibro;               
            }
        else{
            if(dimL <= dimF)
               this.estante[dimL]= unLibro;                                   
            }
        dimL++;               
        }
                
    public Libro devolverLibro(String unTitulo){ // inciso 4
        int i = 0;
        Libro librito = null;
        while((i<= dimF)&&(!this.estante[i].getTitulo().equals(unTitulo))){
            i++;
        }        
        if(i<=dimF){
            librito = this.estante[i];
        }
        return librito;
    }        
}
