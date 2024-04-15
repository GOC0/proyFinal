import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matrice {

    private Map<Character, List<Arista>> grafo;

    public Matrice() {
        grafo = new HashMap<>();
    }

    public void agregarVertice(char vertice) {
        grafo.put(vertice, new ArrayList<>());
    }
    

    	public void agregarArista(char origen, char destino, int peso) {
    	    if (!grafo.containsKey(origen) || !grafo.containsKey(destino)) {
    	        throw new IllegalArgumentException("Los vértices especificados no existen en el grafo.");
    	    }
    	    grafo.get(origen).add(new Arista(destino, peso));
    	    grafo.get(destino).add(new Arista(origen, peso)); // Añadir arista en la dirección opuesta
    	}

    	
    public List<Arista> obtenerAristas(char vertice) {
        return grafo.get(vertice);
    }
    
    
    
    public void eliminarVertice(char vertice) {
        
        grafo.remove(vertice);
        for (char key : grafo.keySet()) {
            List<Arista> aristas = grafo.get(key);
            aristas.removeIf(arista -> arista.destino == vertice);
        }
    }
    
    
    public void eliminarArista(char origen, char destino) {
        if (!grafo.containsKey(origen)) {
            throw new IllegalArgumentException("El vértice de origen especificado no existe en el grafo.");
        }
        List<Arista> aristas = grafo.get(origen);
        aristas.removeIf(arista -> arista.destino == destino);
    }
    
    public List<Character> calcularRutaMasCorta(char origen, char destino) {
        // Estructuras de datos auxiliares
        Map<Character, Integer> distancias = new HashMap<>();
        Map<Character, Character> padres = new HashMap<>();
        Set<Character> visitados = new HashSet<>();
        PriorityQueue<Character> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(distancias::get));
        
        // Inicializar distancias y padres
        for (char vertice : grafo.keySet()) {
            distancias.put(vertice, Integer.MAX_VALUE);
            padres.put(vertice, null);
        }
        distancias.put(origen, 0);
        colaPrioridad.add(origen);
        
        // Ejecutar el algoritmo de Dijkstra
        while (!colaPrioridad.isEmpty()) {
            char actual = colaPrioridad.poll();
            if (actual == destino) {
                break; // Hemos llegado al destino, no necesitamos seguir explorando
            }
            if (visitados.contains(actual)) {
                continue; // Ya hemos procesado este nodo
            }
            visitados.add(actual);
            
            // Explorar los vecinos del nodo actual
            for (Arista arista : grafo.get(actual)) {
                char vecino = arista.destino;
                int nuevaDistancia = distancias.get(actual) + arista.peso;
                if (nuevaDistancia < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDistancia);
                    padres.put(vecino, actual);
                    colaPrioridad.add(vecino);
                }
            }
        }
        
        // Reconstruir la ruta más corta
        List<Character> rutaMasCorta = new ArrayList<>();
        char nodo = destino;
        while (nodo != null) {
            rutaMasCorta.add(nodo);
            nodo = padres.get(nodo);
        }
        Collections.reverse(rutaMasCorta);
        
        return rutaMasCorta;
    }
    
    
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (char vertice : grafo.keySet()) {
            sb.append(vertice).append(": ");
            List<Arista> aristas = grafo.get(vertice);
            for (Arista arista : aristas) {
                sb.append("(").append(arista.destino).append(", ").append(arista.peso).append(") ");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
}