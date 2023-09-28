/**
 * Metodos para manejar una lista con dos extremos extremos primero y último.
 * 
 * @author Jhonny Felipez
 * @version 1.00 25/09/2011
 */
public class ListaPrimeroUltimo {
	private Nodo primero; // hace referencia al primer nodo
	private Nodo ultimo; // hace referencia al último nodo
	// -------------------------------------------------------------
	public ListaPrimeroUltimo() { // constructor
		primero = null; // no hay elementos en la lista
		ultimo = null;
	}
	// -------------------------------------------------------------
	public boolean estaVacia() { // verdad, si la lista está vacía
		return primero == null;
	}
	// -------------------------------------------------------------
	public void insertaPrimero(int d) { // inserta al principio de la lista
		Nodo nuevo = new Nodo(d); // nuevo nodo
		if (estaVacia()) // si la lista está vacía
			ultimo = nuevo; // nuevo <-- ultimo 
		nuevo.sig = primero; // enlaza a la lista nuevo nodo
		primero = nuevo; // primero --> nuevo
	}
	// -------------------------------------------------------------
	public void insertaUltimo(int d) { // inserta al final de la lista
		Nodo nuevo = new Nodo(d); // crea un nuevo nodo
		if (estaVacia()) // si la lista está vacia,
			primero = nuevo; // primero --> nuevo
		else
			ultimo.sig = nuevo; // enlaza a la lista el nuevo
		ultimo = nuevo; // nuevo <-- ultimo
	}
	// -------------------------------------------------------------
	public int eliminaPrimero() { // elimina el primer nodo de la lista (se asume que la lista no está vacia)
		int temp = primero.dato; // guarda la referencia del primero
		if (primero.sig == null) // si hay un elemento
			ultimo = null; // nulo <-- ultimo
		primero = primero.sig; // elimina éste, avanzando primero al siguiente nodo
		return temp; // retorna nodo eliminado
	}
	// -------------------------------------------------------------
	public void despliegaLista() {
		System.out.print("Lista (primero-->último): ");
		Nodo actual = primero; // inicia al principio de la lista
		while (actual != null) { // hasta que sea fin de la lista,
			actual.despliegaNodo(); // imprime dato
			actual = actual.sig; // avanza al siguiente nodo
		}
		System.out.println("");
	}
	// -------------------------------------------------------------
} // fin clase ListaPrimeroUltimo