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
	        grafo.agregarVertice('D');
	        grafo.agregarVertice('E');
	        grafo.agregarVertice('F');
	        grafo.agregarVertice('G');
	        
	        
	        grafo.agregarArista('A', 'B', 5, 10);
	        grafo.agregarArista('B', 'C', 3, 20);
	        grafo.agregarArista('A', 'C', 7, 30);
	        grafo.agregarArista('C', 'D', 8, 25);
	        grafo.agregarArista('D', 'E', 3, 11);
	        grafo.agregarArista('E', 'B', 9, 22);
	        grafo.agregarArista('D', 'G', 6, 34);
	        grafo.agregarArista('E', 'F', 4, 48);
	        
	            
	            boolean terminar= false;
	            
	            Scanner scanner = new Scanner(System.in);
	            
	            while (!terminar) {
	                System.out.println("¿Qué operación deseas realizar?");
	                System.out.println("1- Modificar vértices");
	                System.out.println("2- Modificar aristas");
	                System.out.println("3- Mostrar grafo");
	                System.out.println("4- camino corto (Dijikstra) y Arboles de expension (Prim y Kruskal) ");
	                System.out.println("5- camino corto con el tiempo o la distancia");
	                System.out.println("6- Algoritmo de Floyd-Warshall para el camino más corto");
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
	                    		System.out.println("Ingrese el tiempo: ");
	                    		int tiem = scanner.nextInt();
	                    		
	                    		grafo.agregarArista(org, dest, pes, tiem);
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
	                    	
	                    	 boolean vrai = false;
		                        
		                        while(!vrai) {
	                        System.out.println("1- buscar camino corto entre dos vertices - metodo Dijikstra :");
	                        System.out.println("2- buscar arboles de expension minima - metodo Prim :");
	                        System.out.println("3- buscar arboles de expension minima - metodo Kruskal");
	                        int sel = scanner.nextInt();
	                       
	                        if(sel == 1) {
	                        	 System.out.println("Vertice origen:");
	                        	 char ori = scanner.next().charAt(0);
	                        	 System.out.println(" destino: ");
	                    	      char destin = scanner.next().charAt(0);
	                    	      List<Character> rutaMasCorta = grafo.calcularRutaMasCorta(ori, destin);
	                    	      
	                    	      if (rutaMasCorta.isEmpty()) {
	                    	          System.out.println("No hay ruta disponible entre " + ori + " y " + destin);
	                    	      } else {
	                    	          System.out.println("Ruta más corta desde " + ori + " hasta " + destin + ":");
	                    	          System.out.print( ori + " -> ");
	                    	          for (char vertice : rutaMasCorta) {
	                    	              System.out.print( vertice + " -> ");
	                    	          } 
	                    	      }
	                        }if (sel == 2) {
	                            List<Arista> arbolExpansionMinima = grafo.prim();
	                            
	                            System.out.println("Rutas óptimas del árbol de expansión mínima:");
	                            for (Arista arista : arbolExpansionMinima) {
	                                System.out.println(arista + "->"); // Esto imprimirá el toString() de la clase Arista
	                            }
	                        }if (sel == 3) {
	                            List<Arista> arbolExpansionMinima = grafo.kruskal();
	                            
	                            System.out.println("Árbol de expansión mínima (Kruskal):");
	                            for (Arista arista : arbolExpansionMinima) {
	                                System.out.println(arista.getOrigen() + " - " + arista.getDestino() + " : " + arista.getPeso());
	                            }
	                        }else {
	                        	System.out.println("terminado");
	                        }
	                        System.out.println("1 -terminar o 2- Quedar");
	                        int D = scanner.nextInt();
	                        if(D == 1) {
	                        	vrai= true;
	                        }
	                        }

	                        break;
	                    case 5:
	                    	boolean con = false;
	                    	while(!con) {
	                    		
	                    	System.out.println("1- con el tiempo    2- con la distancia");
	                    	int P = scanner.nextInt();
	                    	System.out.println("Vertice origen:");
                       	     char origenn = scanner.next().charAt(0);
                       	    System.out.println(" destino: ");
                   	         char destinyy = scanner.next().charAt(0);
                   	         
                   	         if (P == 1) {
                   	        	 grafo.imprimirRutaMasCortaConTiempo(origenn, destinyy);
                   	         }else if(P == 2) {
                   	        	 grafo.imprimirRutaMasCortaConPeso(origenn, destinyy);
                   	         }
                   	      System.out.println("1 -terminar o 2- Quedar");
	                        int ter = scanner.nextInt();
	                        if(ter == 1) {
	                        	con = true;
	                        }
	                    	}
	                        
	                    	break;
	                    case 6:
	                    	int[][] distancias = grafo.floydWarshall();
	                        grafo.imprimirDistanciasConRelaciones(distancias);
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

