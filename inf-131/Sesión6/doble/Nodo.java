/**
 * Nodo que es parte de una lista doblemente enlazada.
 * 
 * @author Jhonny Felipez
 * @version 1.00 25/09/2011
 */
class Nodo {
	public int dato; // clave
	public Nodo sig;  // enlace al siguiente nodo
	public Nodo ant;  // enlace al anterior nodo
	// -------------------------------------------------------------
	public Nodo(int d) { // constructor
		dato = d; // inicializa dato ('sig', 'ant' se inicializan con el valor nulo)
	}
	// -------------------------------------------------------------
	public void despliegaNodo() { // despliega este nodo.
		System.out.print("{" + dato + "} ");
	}
	// -------------------------------------------------------------
} // fin clase Nodo
