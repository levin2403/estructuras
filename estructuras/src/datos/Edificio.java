/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * Esta clase se encarga de las intacias para los edificios que vamos 
 * a registrar
 * 
 * @author Kevin Jared Sanchez Figueroa
 *         Cuauhtémoc Eliseo Vazquez Salcido
 */
public class Edificio {
    
    private String nombre;
    private double coordenadaX;
    private double coordenadaY;
    
    // Constructor
    public Edificio(String nombre, double coordenadaX, double coordenadaY) {
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
