/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author skevi
 */
public class Ruta {
    
    private Edificio origen;
    private Edificio destino;
    private double distancia;
    
    // Constructor
    public Ruta(Edificio origen, Edificio destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Edificio getOrigen() {
        return origen;
    }

    public void setOrigen(Edificio origen) {
        this.origen = origen;
    }

    public Edificio getDestino() {
        return destino;
    }

    public void setDestino(Edificio destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    

    @Override
    public String toString() {
        return origen.getNombre() + " -> " + destino.getNombre() + ": " + distancia + " metros";
    }
    
}
