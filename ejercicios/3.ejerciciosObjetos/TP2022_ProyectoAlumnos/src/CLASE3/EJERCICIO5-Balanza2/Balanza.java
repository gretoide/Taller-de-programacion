/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASE3.EJERCICIO5;

import CLASE3.EJERCICIO2.*;

/**
 *
 * @author Greta Piacentini
 */
public class Balanza {
    private double monto;
    private int item;
    String resumen;
    
    
    public double getMonto() {
        return monto;
    }

    public int getItem() {
        return item;
    }

    private void setMonto(double monto) {
        this.monto = monto;
    }

    private void setItem(int item) {
        this.item = item;
    }
    
    public void iniciarCompra(){ //inicializa las variables en 0
        this.monto = 0;
        this.item = 0;
        this.resumen = "";
    }
    
    public void registrarProducto(double pesoKg,double precioKg,String unProducto){
        this.monto = this.monto + (pesoKg * precioKg); //
        this.resumen = this.resumen + "\n" + "Producto: " + unProducto + ", $" + Math.round(precioKg);
        this.item++;
    }

    public String resumenDeCompra() {
        return "RESUMEN DE COMRPRA" + "\n" + this.resumen + "\n" + "Monto: $" + Math.round(monto) + ", por la cantidad de productos: " + item;
    }    
}
