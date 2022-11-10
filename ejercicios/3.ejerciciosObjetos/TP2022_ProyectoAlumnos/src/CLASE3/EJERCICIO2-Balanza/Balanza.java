/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASE3.EJERCICIO2;

/**
 *
 * @author Greta Piacentini
 */
public class Balanza {
    private double monto;
    private int item;
    
    
    public double getMonto() {
        return monto;
    }

    public int getItem() {
        return item;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setItem(int item) {
        this.item = item;
    }
    
    public void iniciarCompra(){ //inicializa las variables en 0
        this.monto = 0;
        this.item = 0;
    }
    
    public void registrarProducto(double pesoKg,double precioKg){
        this.monto = this.monto + (pesoKg * precioKg); //
        this.item++;
    }

    public String resumenDeCompra() {
        return "RESUMEN DE COMRPRA" + "\n" + "Monto: " + monto + ", Cantidad de productos: " + item;
    }
        
    
}
