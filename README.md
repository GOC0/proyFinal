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

los vertices de ese grafo son programados para ser characteres. para agrager un nuevo vertice, se llama la funcion agregarVertice () que toma un character y crea tambien una nueva Arraylist de arista.

para agregar un arista, se utilisa la funcion agregarArista () que toma como entrada el vertice origen, el vertice destino, su peso y el tiempo recorido.

para el algoritmo de camino corto de Dijikstra, se utilisa la funcion calcularRutaMasCorta() que toma como entrada el vertice origen y el vertice destino.ese algortimo buscara el camino con menor peso que conecta el vertice origen con el vertice destino.   

para el algoritmo prim, se utiliza la funcion llamada Prim () que no toma ningun entrada. ese algoritmo disena arboles de expension minima con los datos del grafo. seleciona la arista mas corta que conecta una vertice del arbol de expension con otro vertice fuera. en fin retorna un arbol que conecta todo los vetices con el menor costo total posible.

para el algoritmo Kruskal,  se utiliza la funcion llamada Kruskal(). esa funcion tambien no toma ningun entrada. para esa funcion se utilizo la clase UnionF para implementarla. esa clase verifica si agregar un arista a un arbol de expension minima crearqa un ciclo. es fundamental para implementar ese algoritmo

Para el algorimo de floyd warshall, se utilisa la funcion del mimso nombre. ese algoritmo crea una matriz de distancia que calcula la distancia mas corta entre los vertice. en caso de que de sean conectado, el algortimo pondra un zero para la conexion. se imprime el resultado mediante otra funcion llamada ImprimirDistanciaConRelaciones()

