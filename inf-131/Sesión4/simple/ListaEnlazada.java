/**
 * M�todos para manejar una lista enlazada simple.
 * 
 * @author Jhonny Felipez
 * @version 1.00 10/09/2011
 */
class ListaEnlazada {
	private Nodo primero; // hace referencia al primer nodo de la lista
	// -------------------------------------------------------------
	public ListaEnlazada() { // constructor
		primero = null; // la lista no tiene nodos
	}
	// -------------------------------------------------------------
	public boolean estaVacia() { // verdadero, si la lista est� vac�a
		return (primero == null);
	}
	// -------------------------------------------------------------
	public void insertaPrimero(int dc, String dn) { // inserta al principio de la lista
		Nodo nuevo = new Nodo(dc, dn); // nuevo nodo
		nuevo.sig = primero; // nuevo --> primero
		primero = nuevo; // primero --> nuevo
	}
	// -------------------------------------------------------------
	public Nodo eliminaPrimero() { // elimina el primer nodo de la lista (se asume que la lista no est� vacia)
		Nodo temp = primero; // guarda la referencia del primero
		primero = primero.sig; // elimina �ste: avanza primero al siguiente nodo
		return temp; // retorna nodo eliminado
	}
	// -------------------------------------------------------------
	public void despliegaLista() {
		System.out.print("Lista (primero-->�ltimo): ");
		Nodo actual = primero; // inicia al principio de la lista
		while (actual != null) { // hasta que sea fin de la lista,
			actual.despliegaNodo(); // imprime dato
			actual = actual.sig; // avanza al siguiente nodo
		}
		System.out.println("");
	}
	// -------------------------------------------------------------
} // fin clase ListaEnlazada
