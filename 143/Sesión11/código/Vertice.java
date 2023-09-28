package grafos;

class Vertice {
	public char dato; // dato (ej. 'A')
	public boolean visitado;
	// -------------------------------------------------------------
	public Vertice(char e) { // constructor
		dato = e;
		visitado = false;
	}
	// -------------------------------------------------------------
} // fin de la clase Vertice