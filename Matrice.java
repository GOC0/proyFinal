import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Set;
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
    

    public void agregarArista(char origen, char destino, int peso, int tiempo) {
        if (!grafo.containsKey(origen) || !grafo.containsKey(destino)) {
            throw new IllegalArgumentException("Los vértices especificados no existen en el grafo.");
        }
        grafo.get(origen).add(new Arista(origen, destino, peso, tiempo));
        grafo.get(destino).add(new Arista(destino, origen, peso, tiempo)); 
    }

    	
    public List<Arista> obtenerAristas(char vertice) {
        return grafo.get(vertice);
    }
    
    
    
    public void eliminarVertice(char vertice) {
        grafo.remove(vertice);
        for (char key : grafo.keySet()) {
            List<Arista> aristas = grafo.get(key);
            aristas.removeIf(arista -> arista.getDestino() == vertice);
        }
    }

    
    public void eliminarArista(char origen, char destino) {
        if (!grafo.containsKey(origen)) {
            throw new IllegalArgumentException("El vértice de origen especificado no existe en el grafo.");
        }
        List<Arista> aristas = grafo.get(origen);
        aristas.removeIf(arista -> arista.getDestino() == destino);
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
                char vecino = arista.getDestino();
                int nuevaDistancia = distancias.get(actual) + arista.getPeso();
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
        char SENTINELA = '\0'; // Este es el carácter nulo
        while (nodo != SENTINELA && padres.get(nodo) != null) {
            rutaMasCorta.add(nodo);
            nodo = padres.get(nodo);
        }
        Collections.reverse(rutaMasCorta);


        return rutaMasCorta; 
    }
    
    public List<Character> calcularRutaMasCortaConTiempo(char origen, char destino) {
        // Estructuras de datos auxiliares
        Map<Character, Integer> tiempos = new HashMap<>();
        Map<Character, Character> padres = new HashMap<>();
        Set<Character> visitados = new HashSet<>();
        PriorityQueue<Character> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(tiempos::get));
        
        // Inicializar tiempos y padres
        for (char vertice : grafo.keySet()) {
            tiempos.put(vertice, Integer.MAX_VALUE);
            padres.put(vertice, null);
        }
        tiempos.put(origen, 0);
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
                char vecino = arista.getDestino();
                int nuevoTiempo = tiempos.get(actual) + arista.getTiempo();
                if (nuevoTiempo < tiempos.get(vecino)) {
                    tiempos.put(vecino, nuevoTiempo);
                    padres.put(vecino, actual);
                    colaPrioridad.add(vecino);
                }
            }
        }
        
        // Reconstruir la ruta más corta
        List<Character> rutaMasCorta = new ArrayList<>();
        char nodo = destino;
        char SENTINELA = '\0'; // Este es el carácter nulo
        while (nodo != SENTINELA && padres.get(nodo) != null) {
            rutaMasCorta.add(nodo);
            nodo = padres.get(nodo);
        }
        Collections.reverse(rutaMasCorta);

        return rutaMasCorta;
    }
    
    public void imprimirRutaMasCortaConTiempo(char origen, char destino) {
        List<Character> rutaMasCorta = calcularRutaMasCortaConTiempo(origen, destino);
        
        if (rutaMasCorta.isEmpty()) {
            System.out.println("No hay ruta disponible entre " + origen + " y " + destino);
        } else {
            System.out.println("Ruta más corta desde " + origen + " hasta " + destino + ":");
            int tiempoTotal = 0;
            char origenActual = origen;
            for (char vertice : rutaMasCorta) {
                List<Arista> aristas = grafo.get(origenActual);
                for (Arista arista : aristas) {
                    if (arista.getDestino() == vertice) {
                        tiempoTotal += arista.getTiempo();
                        System.out.println(origenActual + " -> " + vertice + " (Tiempo: " + arista.getTiempo() + ")");
                        break;
                    }
                }
                origenActual = vertice;
            }
            System.out.println("Tiempo total: " + tiempoTotal);
        }
    }
    
    public void imprimirRutaMasCortaConPeso(char origen, char destino) {
        List<Character> rutaMasCorta = calcularRutaMasCorta(origen, destino);
        
        if (rutaMasCorta.isEmpty()) {
            System.out.println("No hay ruta disponible entre " + origen + " y " + destino);
        } else {
            System.out.println("Ruta más corta desde " + origen + " hasta " + destino + ":");
            int pesoTotal = 0;
            char origenActual = origen;
            for (char vertice : rutaMasCorta) {
                List<Arista> aristas = grafo.get(origenActual);
                for (Arista arista : aristas) {
                    if (arista.getDestino() == vertice) {
                        pesoTotal += arista.getPeso();
                        System.out.println(origenActual + " -> " + vertice + " (Peso: " + arista.getPeso() + ")");
                        break;
                    }
                }
                origenActual = vertice;
            }
            System.out.println("Peso total: " + pesoTotal);
        }
    }



    
    public List<Arista> prim() {
        List<Arista> arbolExpansionMinima = new ArrayList<>();
        Set<Character> visitados = new HashSet<>();
        PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(arista -> arista.getPeso()));
        
        // Elegir un vértice inicial aleatorio
        char primerVertice = grafo.keySet().iterator().next();
        visitados.add(primerVertice);
        
        // Agregar las aristas del vértice inicial a la cola de prioridad
        for (Arista arista : grafo.get(primerVertice)) {
            colaPrioridad.add(arista);
        }
        
        // Ejecutar el algoritmo de Prim
        while (!colaPrioridad.isEmpty() && visitados.size() < grafo.size()) {
            Arista arista = colaPrioridad.poll();
            char destino = arista.getDestino();
            
            // Si el destino ya ha sido visitado, continuar
            if (visitados.contains(destino)) {
                continue;
            }
            
            // Agregar la arista al árbol de expansión mínima
            arbolExpansionMinima.add(arista);
            visitados.add(destino);
            
            // Agregar las aristas del nuevo vértice a la cola de prioridad
            for (Arista nuevaArista : grafo.get(destino)) {
                if (!visitados.contains(nuevaArista.getDestino())) {
                    colaPrioridad.add(nuevaArista);
                }
            }
        }
        
        return arbolExpansionMinima;
    }
    
    
    public List<Arista> kruskal() {
        List<Arista> arbolExpansionMinima = new ArrayList<>();
        List<Arista> todasAristas = new ArrayList<>();
        
        // Agregar todas las aristas del grafo a la lista de aristas
        for (List<Arista> listaAristas : grafo.values()) {
            todasAristas.addAll(listaAristas);
        }
        
        // Ordenar todas las aristas por peso
        Collections.sort(todasAristas, Comparator.comparingInt(arista -> arista.getPeso()));

        
        UnionF unionF = new UnionF(grafo.keySet());
        
        // Iterar sobre todas las aristas en orden ascendente de peso
        for (Arista arista : todasAristas) {
            char origen = arista.getOrigen();
            char destino = arista.getDestino();
            int peso = arista.getPeso();

            // Verificar si agregar la arista crea un ciclo en el árbol
            if (!unionF.isConnected(origen, destino)) {
                arbolExpansionMinima.add(arista);
                unionF.union(origen, destino);
            }
        }
        
        return arbolExpansionMinima;
    }
    
    public int[][] floydWarshall() {
        int numVertices = grafo.size();
        int[][] distancias = new int[numVertices][numVertices];

        // Inicializar matriz de distancias
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    distancias[i][j] = 0;
                } else {
                    distancias[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Llenar la matriz de distancias con los pesos de las aristas
        for (char origen : grafo.keySet()) {
            for (Arista arista : grafo.get(origen)) {
                char destino = arista.getDestino();
                int peso = arista.getPeso();
                distancias[origen - 'A'][destino - 'A'] = peso;
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (distancias[i][k] != Integer.MAX_VALUE && distancias[k][j] != Integer.MAX_VALUE
                            && distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                    }
                }
            }
        }

        return distancias;
    }
    
    public void imprimirDistanciasConRelaciones(int[][] distancias) {
        int numVertices = distancias.length;

        System.out.println("Matriz de distancias y relaciones:");
        System.out.print("\t");
        for (int i = 0; i < numVertices; i++) {
            System.out.print((char) ('A' + i) + "\t");
        }
        System.out.println();

        for (int i = 0; i < numVertices; i++) {
            System.out.print((char) ('A' + i) + "\t");
            for (int j = 0; j < numVertices; j++) {
                if (distancias[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(distancias[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }


    
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (char vertice : grafo.keySet()) {
            sb.append(vertice).append(": ");
            List<Arista> aristas = grafo.get(vertice);
            for (Arista arista : aristas) {
                sb.append("(").append(arista.getDestino()).append(", ").append(arista.getPeso()).append(") ");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
}