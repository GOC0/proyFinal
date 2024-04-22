bienvenido
a continuacion se hablara del funcionamiento del codigo y del proposito de las diferentes partes

Parte de utilisation
el algoritmo presenta un menu que esta en un bucle. cada numero presentado el menu resprenta un accion
se puede realizar. la unica forma de terminar el programa es presionar el numero correspondiente a 
Terminar en el menu.

Parte explicativo
ese codigo esta dividido en diferentes clases
1- la clase Arista    2- la clase Matriz  3- la clase principal   4- la clase unionF
la mayoria de las funciones importante del algoritmo son colocadas en la clase Matriz. 

los vertices de ese grafo son programados para ser characteres. para agrager un nuevo vertice, se llama la funcion
agregarVertice que toma un character y crea tambien una nueva Arraylist

para agregar un arista, se utilisa la funcion agregarArista que toma como entrada el vertice origen, el vertice destino,
su peso y el tiempo recorido.

para el algoritmo de camino corto de Dijikstra, se utilisa la funcion calcularRutaMasCorta que toma como entrada el vertice origen y el vertice destino.  
