/**
 * Métodos para manejar una lista doblemente enlazada.
 * 
 * @author Jhonny Felipez
 * @version 1.00 25/09/2011
 */
class ListaDoblementeEnlazada {
	private Nodo primero; // hace referencia al primer nodo de la lista
	private Nodo ultimo; // hace referencia al último nodo de la lista
	// -------------------------------------------------------------

	public ListaDoblementeEnlazada() { // constructor
		primero = null; // la lista no tiene nodos
		ultimo = null;
	}
	// -------------------------------------------------------------
	public boolean estaVacia() { // verdadero, si la lista está vacía
		return (primero == null);
	}
	// -------------------------------------------------------------
	public void insertaInicio(int d) { // inserta nodo al principio de la lista	
		Nodo nuevo = new Nodo(d); // nuevo nodo
		if (estaVacia()) // si la lista está vacía,
			ultimo = nuevo; // nuevo <-- ultimo
		else
			primero.ant = nuevo; // enlaza nuevo nodo a la lista
		nuevo.sig = primero; // enlaza nuevo nodo a la lista
		primero = nuevo; // primero --> nuevo
	}
	// -------------------------------------------------------------
	public void insertaFinal(int d) { // inserta nodo al final de la lista
		Nodo nuevo = new Nodo(d); // nuevo nodo
		if (estaVacia()) // si la lista está vacia,
			primero = nuevo; // primero --> nuevo
		else {
			ultimo.sig = nuevo; // enlaza nuevo nodo a la lista
			nuevo.ant = ultimo; 
		}
		ultimo = nuevo; // nuevo <-- ultimo
	}
	// -------------------------------------------------------------
	public Nodo eliminaInicio() { // elimina el primer nodo (se asume que la lista no está vacía)
		Nodo temp = primero;
		if (primero.sig == null) // si hay solamente un nodo
			ultimo = null; // null <-- último
		else
			primero.sig.ant = null; // nulo <-- anterior del siguiente de primero
		primero = primero.sig; // elimina éste, avanzando primero al siguiente nodo
		return temp;
	}
	// -------------------------------------------------------------
	public Nodo eliminaUltimo() { // elimina el último nodo (se asume que la lista no está vacía)
		Nodo temp = ultimo;
		if (primero.sig == null) // si hay solamente un nodo
			primero = null; // primero --> null
		else
			ultimo.ant.sig = null; // siguiente del anterior del ultimo --> nulo
		ultimo = ultimo.ant; // elimina éste, avanzando ultimo al anterior nodo
		return temp;
	}
	// -------------------------------------------------------------
	// inserta después del nodo que tiene como dato = 'clave'
	public boolean insertaDespues(int clave, int d) { // (se asume que la lista no está vacía)
		Nodo actual = primero; // inicia en el primer nodo
		while (actual.dato != clave) { // hasta que sea encontrado,
			actual = actual.sig; // avanza al siguiente nodo
			if (actual == null)
				return false; // no encontró ésta clave
		}
		Nodo nuevo = new Nodo(d); // nuevo nodo

		if (actual == ultimo) { // si es el último nodo,
			nuevo.sig = null; // sig de nuevo --> nulo
			ultimo = nuevo; // nuevo <-- último
		} else { // no es el último nodo,
			nuevo.sig = actual.sig; // sig de nuevo --> sig de actual
			actual.sig.ant = nuevo; // nuevo <-- ant del sig de actual
		}
		nuevo.ant = actual; // actual <-- ant de nuevo
		actual.sig = nuevo; // sig de actual --> nuevo
		return true; // encontró la clave, por tanto se adicionó el nodo
	}
	// -------------------------------------------------------------
	public Nodo eliminaClave(long clave) { // elimina nodo con dato = 'clave' (se asume que la lista no está vacia)
		Nodo actual = primero; // inicia en el primer nodo
		while (actual.dato != clave) { // hasta que sea encontrado,
			actual = actual.sig; // avanza al siguiente nodo
			if (actual == null)
				return null; // no encontró ésta clave
		}
		if (actual == primero) // encontró la clave; ¿primer nodo?
			primero = actual.sig; // primero --> sig de actual
		else // no es el primer nodo,  sig del ant de actual --> sig de actual
			actual.ant.sig = actual.sig;

		if (actual == ultimo) // ¿último nodo?
			ultimo = actual.ant; // ant de actual <-- ultimo
		else // no es el último, ant de actual <-- ant del sig de actual
			actual.sig.ant = actual.ant;
		return actual; // retorna valor
	}
	// -------------------------------------------------------------
	public void despliegaAdelante() {
		System.out.print("Lista (primero-->último): ");
		Nodo actual = primero; // inicia desde el primero nodo
		while (actual != null) { // hasta el final de la lista,
			actual.despliegaNodo(); // despliega dato
			actual = actual.sig; // avanza al siguiente nodo
		}
		System.out.println("");
	}
	// -------------------------------------------------------------
	public void despliegaAtras() {
		System.out.print("Lista (último-->primero): ");
		Nodo actual = ultimo; // inicia desde el ultimo nodo
		while (actual != null) { // hasta el primer nodo de la lista,
			actual.despliegaNodo(); // despliega dato
			actual = actual.ant; // avanza al anterior nodo
		}
		System.out.println("");
	}
	// -------------------------------------------------------------
} // fin clase ListaDoblementeEnlazada
