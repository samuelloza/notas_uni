package grafos;
/**
 * Aplicación de grafos. Búsqueda en anchura y en profundidad
 *
 * @author Jhonny Felipez
 * @version 1.00 22/11/2011
 */
class Aplicacion {
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		grafo.adiVertice('1'); // 0 (empieza)
		grafo.adiVertice('2'); // 1
		grafo.adiVertice('3'); // 2
		grafo.adiVertice('4'); // 3
		grafo.adiVertice('5'); // 4
		grafo.adiVertice('6'); // 5
		grafo.adiVertice('7'); // 6
		grafo.adiVertice('8'); // 7

		grafo.adiArco(1, 2);
		grafo.adiArco(2, 3);
		grafo.adiArco(2, 5);
		grafo.adiArco(3, 1);
		grafo.adiArco(3, 4);
		grafo.adiArco(4, 1);
		grafo.adiArco(5, 3);
		grafo.adiArco(5, 6);
		grafo.adiArco(7, 8);
		
		System.out.print("Vértices visitados (DFS): ");
		grafo.dfs(); // búsqueda en profundidad
		System.out.println();
		//System.out.print("Vértices visitados (BFS): ");
		//grafo.bfs(); // búsqueda en profundidad
		//System.out.println();
	} // fin main()
} // fin de la clase Aplicación
