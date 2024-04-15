import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) {
		
		 Matrice grafo = new Matrice();
	        
	        grafo.agregarVertice('A');
	        grafo.agregarVertice('B');
	        grafo.agregarVertice('C');
	        
	        grafo.agregarArista('A', 'B', 5);
	        grafo.agregarArista('B', 'C', 3);
	        grafo.agregarArista('A', 'C', 7);
	        
	        /*List<Arista> aristasDeA = grafo.obtenerAristas('A');
	        for (Arista arista : aristasDeA) {
	            System.out.println("Peso de la arista: " + arista.peso); */
	            
	            boolean terminar= false;
	            
	            Scanner scanner = new Scanner(System.in);
	            
	            while (!terminar) {
	                System.out.println("¿Qué operación deseas realizar?");
	                System.out.println("1- Modificar vértices");
	                System.out.println("2- Modificar aristas");
	                System.out.println("3- Mostrar grafo");
	                System.out.println("4- Buscar camino corto");
	                System.out.println("7- Terminar");
	                
	                int seleccion = scanner.nextInt();
	                
	                switch (seleccion) {
	                    case 1:
	                    	System.out.println("1- agregar vértices");
	                    	System.out.println("2- eliminar vertices");
	                    	
	                    	int tom = scanner.nextInt();
	                    	 if (tom == 1) {
	                    		 
	                    	        System.out.println("Ingrese el vértice: ");
	                    	        char ver = scanner.next().charAt(0); // Read a string and get the first character
	                    	        grafo.agregarVertice(ver);
	                    	        
	                    	    } else if (tom == 2) {
	                    	    	
	                    	    	char ver = scanner.next().charAt(0);
	                    	         grafo.eliminarVertice(ver);
	                    	        System.out.println("eliminado exitosamente ");
	                    	        
	                    	    } else { 
	                    	        System.out.println("Opción inválida.");
	                    	    }
	                        break;
	                    case 2:
	                    	System.out.println("1- agregar arista");
	                    	System.out.println("2- eliminar arista");
	                    	
	                    	int dan = scanner.nextInt();
	                    	if(dan == 1) {
	                    		
	                    		
	                    		System.out.println("Ingrese el origen: ");
	                    		char org= scanner.next().charAt(0);
	                    		System.out.println("Ingrese el destino: ");
	                    		char dest= scanner.next().charAt(0);
	                    		System.out.println("Ingrese el peso: ");
	                    		int pes= scanner.nextInt();
	                    		
	                    		grafo.agregarArista(org, dest, pes);
	                    	} else if (dan == 2) {
	                    		
	                    		
	                    		 System.out.println("Ingrese el origen: ");
	                    	        char origen = scanner.next().charAt(0);
	                    	        System.out.println("Ingrese el destino: ");
	                    	        char destino = scanner.next().charAt(0);
	                    	        grafo.eliminarArista(origen, destino);
	                    	        System.out.println("Arista eliminada exitosamente.");
	                    	        
	                    	        
	                    	        } else {
	                    	        
	                            System.out.println("Opción inválida.");
	                        }
	                    	 
	                        break;
	                    case 3:
	                    	 System.out.println(grafo); 
	                        break;
	                    case 4:
	                        System.out.println("1- buscar camino corto entre dos vertices - metodo Dijikstra :");
	                        System.out.println("2- buscar arboles de expension minima - metodo Prim :");
	                        System.out.println("3- buscar arboles de expension minima - metodo Kruskal");
	                        
	                        
	                        break;
	                    case 7:
	                        terminar = true;
	                        break;
	                    default:
	                        System.out.println("Selección inválida, por favor ingrese un número válido.");
	                }
	               
	            }
	            
	            scanner.close();

	}
  }

