/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datos;

import java.util.List;

/**
 *
 * @author skevi
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear un mapa
        Mapa mapa = new Mapa();

        // Agregar algunos edificios al mapa
        Edificio aulas = new Edificio("Aulas", 10, 20);
        Edificio biblioteca = new Edificio("Biblioteca", 30, 40);
        Edificio laboratorios = new Edificio("Laboratorios", 50, 60);
        Edificio cafeteria = new Edificio("Cafetería", 70, 80);

        mapa.agregarEdificio(aulas);
        mapa.agregarEdificio(biblioteca);
        mapa.agregarEdificio(laboratorios);
        mapa.agregarEdificio(cafeteria);

        // Registrar algunas rutas entre los edificios
        mapa.registrarDistancia(aulas, biblioteca, 100);
        mapa.registrarDistancia(biblioteca, laboratorios, 200);
        mapa.registrarDistancia(aulas, cafeteria, 150);
        mapa.registrarDistancia(laboratorios, cafeteria, 180);

        // Calcular la ruta más corta entre dos edificios
        Edificio origen = aulas;
        Edificio destino = laboratorios;
        List<Ruta> rutaMasCorta = mapa.rutaMasCorta(origen, destino);
        System.out.println("Ruta más corta desde " + origen.getNombre() + " hasta " + destino.getNombre() + ":");
        for (Ruta ruta : rutaMasCorta) {
            System.out.println(ruta);
        }

        // Listar los edificios a los que se puede llegar directamente desde un edificio dado
        Edificio edificioDeOrigen = aulas;
        List<Edificio> edificiosDirectos = mapa.edificiosDirectos(edificioDeOrigen);
        System.out.println("\nEdificios a los que se puede llegar directamente desde " + edificioDeOrigen.getNombre() + ":");
        for (Edificio edificio : edificiosDirectos) {
            System.out.println(edificio.getNombre());
        }

        // Listar todos los edificios del mapa
        System.out.println("\nLista de todos los edificios:");
        mapa.listarEdificios();
    }
    
    
}
