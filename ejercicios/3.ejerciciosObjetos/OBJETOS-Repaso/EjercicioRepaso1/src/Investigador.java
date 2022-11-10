/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Greta Piacentini
 */
public class Investigador {
    private String nombre;
    private String apellido;
    private int categoria;
    private String especialidad;
    private Subsidio subsidios[];
    private int diml;
    private int dimf;
    
    public Investigador(String unNombre, String unApellido, int unaCategoria, String unaEspecialidad){
        this.nombre = unNombre;
        this.apellido = unApellido;
        this.categoria = unaCategoria;
        this.especialidad = unaEspecialidad;
        this.diml = 0;
        this.dimf = 5;
        this.subsidios = new Subsidio[dimf];
    }
    
    public void agregarSubsidio(Subsidio unSubsidio){
        if(diml<dimf){
            subsidios[diml]=unSubsidio;
            this.diml++;
        }
    }

    public int getDiml() {
        return diml;
    }
    
    public double dineroOtorgado(){
        double total = 0;
        int i = 0;
        for(i=0;i<diml;i++){
            if(subsidios[i].getEstado() == true){
                total = total + subsidios[i].getMontoPedido();
            }
        }
        return total;
    }
    
    public void otorgarSubsidio(int n){
        subsidios[n].setEstado(true);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public String toString(){
        String aux = "Nombre: " + this.nombre + "\n" + "Apellido: " + this.apellido + "\n"
                + "Categoria: " + this.categoria + "\n" + "Dinero de los subsidios: " + dineroOtorgado();
        return aux;
    }
    
    
}
