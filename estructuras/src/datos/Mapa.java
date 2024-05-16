/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Mapa {
    private List<Edificio> edificios;
    private List<Ruta> rutas;
    
    // Constructor
    public Mapa() {
        edificios = new ArrayList<>();
        rutas = new ArrayList<>();  
    }
    
    // Métodos para edificios
    public void agregarEdificio(Edificio edificio) {
        edificios.add(edificio);
    }
    
    public void eliminarEdificio(Edificio edificio) {
        edificios.remove(edificio);
        // Eliminar rutas asociadas a este edificio
        rutas.removeIf(ruta -> ruta.getOrigen().equals(edificio) || ruta.getDestino().equals(edificio));
    }
    
    public List<Edificio> getEdificios() {
        return edificios;
    }
    
    // Métodos para rutas
    public void agregarRuta(Ruta ruta) {
        rutas.add(ruta);
    }
    
    public void eliminarRuta(Ruta ruta) {
        rutas.remove(ruta);
    }
    
    public List<Ruta> getRutas() {
        return rutas;
    }
    
    public List<Ruta> rutaMasCorta(Edificio origen, Edificio destino) {
    // Mapa de distancias mínimas desde el origen a cada edificio
        Map<Edificio, Double> distanciasMinimas = new HashMap<>();
        // Mapa de la ruta más corta desde el origen a cada edificio
        Map<Edificio, List<Ruta>> rutasCortas = new HashMap<>();
        // Cola de prioridad para seleccionar el siguiente nodo a explorar
        PriorityQueue<Edificio> colaPrioridad = new PriorityQueue<>((a, b) -> {
            double diferencia = distanciasMinimas.get(a) - distanciasMinimas.get(b);
            if (diferencia == 0) return 0;
            return diferencia < 0 ? -1 : 1;
        });

        // Inicializar todas las distancias como infinito y el origen como 0
        for (Edificio edificio : edificios) {
            if (edificio.equals(origen)) {
                distanciasMinimas.put(edificio, 0.0);
            } else {
                distanciasMinimas.put(edificio, Double.POSITIVE_INFINITY);
            }
            rutasCortas.put(edificio, new ArrayList<>());
            colaPrioridad.offer(edificio);
        }

        // Algoritmo de Dijkstra
        while (!colaPrioridad.isEmpty()) {
            Edificio actual = colaPrioridad.poll();
            double distanciaActual = distanciasMinimas.get(actual);

            for (Ruta ruta : rutas) {
                if (ruta.getOrigen().equals(actual)) {
                    Edificio vecino = ruta.getDestino();
                    double nuevaDistancia = distanciaActual + ruta.getDistancia();
                    if (nuevaDistancia < distanciasMinimas.get(vecino)) {
                        distanciasMinimas.put(vecino, nuevaDistancia);
                        // Actualizar la ruta más corta al vecino
                        List<Ruta> rutaCortaActualizada = new ArrayList<>(rutasCortas.get(actual));
                        rutaCortaActualizada.add(ruta);
                        rutasCortas.put(vecino, rutaCortaActualizada);
                        colaPrioridad.remove(vecino);
                        colaPrioridad.offer(vecino);
                    }
                }
            }
        }

        // Retornar la ruta más corta al destino
        return rutasCortas.get(destino);
    }
    
    
    public List<Edificio> edificiosDirectos(Edificio origen) {
    List<Edificio> edificiosDirectos = new ArrayList<>();
    for (Ruta ruta : rutas) {
        if (ruta.getOrigen().equals(origen)) {
            edificiosDirectos.add(ruta.getDestino());
        }
    }
    return edificiosDirectos;
    }
    
    public void registrarDistancia(Edificio origen, Edificio destino, double distancia) {
    // Verificar si la ruta ya existe, si es así, actualizar la distancia
    for (Ruta ruta : rutas) {
        if (ruta.getOrigen().equals(origen) && ruta.getDestino().equals(destino)) {
            ruta.setDistancia(distancia);
            return;
        }
    }
    // Si la ruta no existe, agregar una nueva ruta con la distancia especificada
    rutas.add(new Ruta(origen, destino, distancia));
    }

    public void eliminarDistancia(Edificio origen, Edificio destino) {
    // Eliminar la ruta que va desde el origen al destino
    rutas.removeIf(ruta -> ruta.getOrigen().equals(origen) && ruta.getDestino().equals(destino));
    }

    
    public void actualizarDistancia(Edificio origen, Edificio destino, double nuevaDistancia) {
    // Buscar la ruta y actualizar su distancia
    for (Ruta ruta : rutas) {
        if (ruta.getOrigen().equals(origen) && ruta.getDestino().equals(destino)) {
            ruta.setDistancia(nuevaDistancia);
            return;
        }
    }
    }
    
    public void listarEdificios() {
    System.out.println("Edificios existentes:");
    for (Edificio edificio : edificios) {
        System.out.println(edificio.getNombre());
    }
}
}

