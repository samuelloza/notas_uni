package grafos;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Programa de lee e imprime un grafo y realiza un busqueda por anchura y por
 * profundidad.
 * 
 * @author Jhonny Felipez
 * 
 */

/*
8 9
1 2
2 3
2 5
3 1
3 4
4 1
5 3
5 6
7 8

 */

public class Main {
	public static int MAXVERT = 100;
	public static int MAXGRADO = 50;
	public static int[][] arcos = new int[MAXVERT + 1][MAXGRADO];
	public static int[] grado = new int[MAXVERT + 1];
	public static int numvertices;
	public static int numarcos;

	public static boolean[] procesado = new boolean[MAXVERT];
	public static boolean[] visitados = new boolean[MAXVERT];
	public static int[] padre = new int[MAXVERT];

	public static void inicializaGrafo() {
		numvertices = 0;
		numarcos = 0;
		for (int i = 1; i <= MAXVERT; i++)
			grado[i] = 0;
	}

	public static void insertaArco(int x, int y, boolean dirigido) {
		if (grado[x] > MAXGRADO)
			System.out.println("ERROR: insercion excede max grado");
		arcos[x][grado[x]] = y;
		grado[x]++;
		if (!dirigido)
			insertaArco(y, x, true);
		else
			numarcos++;
	}

	public static void leeGrafo(boolean dirigido) {
		Scanner in = new Scanner(System.in);
		int numarcos, x, y;
		inicializaGrafo();
		StringTokenizer st = new StringTokenizer(in.nextLine());
		numvertices = Integer.parseInt(st.nextToken());
		numarcos = Integer.parseInt(st.nextToken()); 
		for (int i = 1; i <= numarcos; i++) {
			st = new StringTokenizer(in.nextLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			insertaArco(x, y, dirigido);
		}
	}

	public static void verGrafo() {
		for (int i = 1; i <= numvertices; i++) {
			System.out.format("%d: ", i);
			for (int j = 0; j < grado[i]; j++)
				System.out.format(" %d", arcos[i][j]);
			System.out.println();
		}
	}

	public static void inicializaBusqueda() {
		for (int i = 1; i <= numvertices; i++) {
			procesado[i] = visitados[i] = false;
			padre[i] = -1;
		}
	}

	public static void procesaVertice(int v) {
		System.out.format("vertice procesado %d\n", v);
	}

	public static void arcoProcesado(int x, int y) {
		System.out.format("arco procesado (%d,%d)\n", x, y);
	}

	public static boolean arcoValido(int arco) {
		return true;
	}

	public static void bfs(int inicio) {
		LinkedList<Integer> cola = new LinkedList<Integer>();
		int v;
		cola.add(inicio);
		visitados[inicio] = true;
		while (!cola.isEmpty()) {
			v = cola.remove();
			procesaVertice(v);
			procesado[v] = true;
			for (int i = 0; i < grado[v]; i++) {
				if (arcoValido(arcos[v][i]) == true)
					if (visitados[arcos[v][i]] == false) {
						cola.add(arcos[v][i]);
						visitados[arcos[v][i]] = true;
						padre[arcos[v][i]] = v;
					}
				if (procesado[arcos[v][i]] == false)
					arcoProcesado(v, arcos[v][i]);
			}
		}
	}

	public static void dfs(int inicio) {
		Stack<Integer> pila = new Stack<Integer>();
		int v;
		pila.push(inicio);
		visitados[inicio] = true;
		while (!pila.isEmpty()) {
			v = pila.pop();
			procesaVertice(v);
			procesado[v] = true;
			for (int i = 0; i < grado[v]; i++) {
				if (arcoValido(arcos[v][i]) == true)
					if (visitados[arcos[v][i]] == false) {
						pila.push(arcos[v][i]);
						visitados[arcos[v][i]] = true;
						padre[arcos[v][i]] = v;
					} 
				if (procesado[arcos[v][i]] == false)
					arcoProcesado(v, arcos[v][i]);
			}
		}
	}
	
	/*	DFS(input: Graph G) {
	Stack S; Integer x, t; 
   	while (G has an unvisited node x){
		visit(x); push(x,S); 
		while (S is not empty){ 
			t := peek(S); 
			if (t has an unvisited neighbor y){ visit(y); push(y,S); }
			else 
				pop(S); 
		}
	}
	}*/
	
	public static void dfsr(int v) {
		int y;
		visitados[v] = true;
		procesaVertice(v);
		for (int i = 0; i < grado[v]; i++) {
			y = arcos[v][i];
			if (arcoValido(arcos[v][i]) == true)
				if (visitados[arcos[v][i]] == false) {
					padre[arcos[v][i]] = v;
					dfsr(y);
				} else if (procesado[y] == false)
					arcoProcesado(v, y);
		}
		procesado[v] = true;
	}

	public static void main(String[] args) {
		leeGrafo(true);
		//verGrafo();
		/*inicializaBusqueda();
		bfs(1);
		bfs(7);*/
		inicializaBusqueda();
		dfs(1);
		dfs(7);
	}
}
