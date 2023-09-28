package grafos;

import java.util.LinkedList;
import java.util.Stack;

class Grafo {
	private final int MAX_VERT = 20;
	private Vertice vertices[]; // lista de vertices
	private int matrizdeadyacencias[][]; // matriz de adyacencias
	private int numvertices; // número de vertices
	// ------------------------------------------------------------
	public Grafo() { // constructor
		vertices = new Vertice[MAX_VERT];
		// matriz de adyacencias
		matrizdeadyacencias = new int[MAX_VERT][MAX_VERT];
		numvertices = 0;
		// coloca la matriz de adyacencias a cero
		for (int j = 0; j < MAX_VERT; j++)
			for (int k = 0; k < MAX_VERT; k++)
				matrizdeadyacencias[j][k] = 0;
	} // fin constructor
	// -------------------------------------------------------------
	public void adiVertice(char e) {
		vertices[numvertices++] = new Vertice(e);
	}
	// -------------------------------------------------------------
	public void adiArco(int x, int y) {
		matrizdeadyacencias[x-1][y-1] = 1;
	}	
	// -------------------------------------------------------------
	public void despliegaVertice(int v) {
		System.out.print(vertices[v].dato + " ");
	}
	// -------------------------------------------------------------
	public void bfs() { // búsqueda en anchura
		LinkedList<Integer> cola = new LinkedList<Integer>();
		vertices[0].visitado = true;
		despliegaVertice(0);
		cola.add(0);
		int v2;
		while (!cola.isEmpty()) {
			int v1 = cola.remove();
			while ((v2 = obtVerticeAdyNoVisitado(v1)) != -1) { 
				vertices[v2].visitado = true;
				despliegaVertice(v2);
				cola.add(v2);
			}
		}
		for (int j = 0; j < numvertices; j++)
			vertices[j].visitado = false;
	} // fin bfs()
	// -------------------------------------------------------------
	public void dfs() { // búsqueda en profundidad 
		Stack <Integer> pila = new Stack<Integer>();
		vertices[0].visitado = true;
		despliegaVertice(0);
		pila.push(0);
		while (!pila.isEmpty()) {
		    int v = obtVerticeAdyNoVisitado(pila.peek());
	        if(v == -1)
		        pila.pop();
		    else {
				vertices[v].visitado = true;
				despliegaVertice(v);
				pila.push(v);
		    }
		}
		for (int j = 0; j < numvertices; j++)
			vertices[j].visitado = false;
	} // fin dfs()
	// -------------------------------------------------------------
	// retorna un vertice adyacente no visitado a v
	public int obtVerticeAdyNoVisitado(int v) {
		for (int j = 0; j < numvertices; j++)
			if (matrizdeadyacencias[v][j] == 1 && vertices[j].visitado == false)
				return j;
		return -1;
	} // fin obtVerticeAdyNoVisitado()
	// -------------------------------------------------------------
} // fin de la clase Grafo