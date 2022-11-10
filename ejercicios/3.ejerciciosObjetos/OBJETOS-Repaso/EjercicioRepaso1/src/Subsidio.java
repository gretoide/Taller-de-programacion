/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Greta Piacentini
 */
public class Subsidio {
    private double montoPedido;
    private String motivo;
    private boolean estado;
    
    public Subsidio(double unMonto, String unMotivo){
        this.montoPedido = unMonto;
        this.motivo = unMotivo;
        this.estado = false;
    }

    public double getMontoPedido() {
        return montoPedido;
    }
    
    public void setMontoPedido(double montoPedido) {
        this.montoPedido = montoPedido;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
