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
public abstract class Coro {
    private String nombreCoro;
    private Director unDirector;

    public Coro(String nombreCoro, Director unDirector) {
        this.nombreCoro = nombreCoro;
        this.unDirector = unDirector;
    }
    

    public String getNombreCoro() {
        return nombreCoro;
    }

    public void setNombreCoro(String nombreCoro) {
        this.nombreCoro = nombreCoro;
    }

    public Director getUnDirector() {
        return unDirector;
    }

    public void setUnDirector(Director unDirector) {
        this.unDirector = unDirector;
    }
    
    public abstract void agregarCorista(Coristas unCorista);
    
    public abstract boolean estaLleno();
    
    public abstract boolean estaFormado();
}
