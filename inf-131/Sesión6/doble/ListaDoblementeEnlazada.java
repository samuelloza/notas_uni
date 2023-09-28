/**
 * M�todos para manejar una lista doblemente enlazada.
 * 
 * @author Jhonny Felipez
 * @version 1.00 25/09/2011
 */
class ListaDoblementeEnlazada {
	private Nodo primero; // hace referencia al primer nodo de la lista
	private Nodo ultimo; // hace referencia al �ltimo nodo de la lista
	// -------------------------------------------------------------

	public ListaDoblementeEnlazada() { // constructor
		primero = null; // la lista no tiene nodos
		ultimo = null;
	}
	// -------------------------------------------------------------
	public boolean estaVacia() { // verdadero, si la lista est� vac�a
		return (primero == null);
	}
	// -------------------------------------------------------------
	public void insertaInicio(int d) { // inserta nodo al principio de la lista	
		Nodo nuevo = new Nodo(d); // nuevo nodo
		if (estaVacia()) // si la lista est� vac�a,
			ultimo = nuevo; // nuevo <-- ultimo
		else
			primero.ant = nuevo; // enlaza nuevo nodo a la lista
		nuevo.sig = primero; // enlaza nuevo nodo a la lista
		primero = nuevo; // primero --> nuevo
	}
	// -------------------------------------------------------------
	public void insertaFinal(int d) { // inserta nodo al final de la lista
		Nodo nuevo = new Nodo(d); // nuevo nodo
		if (estaVacia()) // si la lista est� vacia,
			primero = nuevo; // primero --> nuevo
		else {
			ultimo.sig = nuevo; // enlaza nuevo nodo a la lista
			nuevo.ant = ultimo; 
		}
		ultimo = nuevo; // nuevo <-- ultimo
	}
	// -------------------------------------------------------------
	public Nodo eliminaInicio() { // elimina el primer nodo (se asume que la lista no est� vac�a)
		Nodo temp = primero;
		if (primero.sig == null) // si hay solamente un nodo
			ultimo = null; // null <-- �ltimo
		else
			primero.sig.ant = null; // nulo <-- anterior del siguiente de primero
		primero = primero.sig; // elimina �ste, avanzando primero al siguiente nodo
		return temp;
	}
	// -------------------------------------------------------------
	public Nodo eliminaUltimo() { // elimina el �ltimo nodo (se asume que la lista no est� vac�a)
		Nodo temp = ultimo;
		if (primero.sig == null) // si hay solamente un nodo
			primero = null; // primero --> null
		else
			ultimo.ant.sig = null; // siguiente del anterior del ultimo --> nulo
		ultimo = ultimo.ant; // elimina �ste, avanzando ultimo al anterior nodo
		return temp;
	}
	// -------------------------------------------------------------
	// inserta despu�s del nodo que tiene como dato = 'clave'
	public boolean insertaDespues(int clave, int d) { // (se asume que la lista no est� vac�a)
		Nodo actual = primero; // inicia en el primer nodo
		while (actual.dato != clave) { // hasta que sea encontrado,
			actual = actual.sig; // avanza al siguiente nodo
			if (actual == null)
				return false; // no encontr� �sta clave
		}
		Nodo nuevo = new Nodo(d); // nuevo nodo

		if (actual == ultimo) { // si es el �ltimo nodo,
			nuevo.sig = null; // sig de nuevo --> nulo
			ultimo = nuevo; // nuevo <-- �ltimo
		} else { // no es el �ltimo nodo,
			nuevo.sig = actual.sig; // sig de nuevo --> sig de actual
			actual.sig.ant = nuevo; // nuevo <-- ant del sig de actual
		}
		nuevo.ant = actual; // actual <-- ant de nuevo
		actual.sig = nuevo; // sig de actual --> nuevo
		return true; // encontr� la clave, por tanto se adicion� el nodo
	}
	// -------------------------------------------------------------
	public Nodo eliminaClave(long clave) { // elimina nodo con dato = 'clave' (se asume que la lista no est� vacia)
		Nodo actual = primero; // inicia en el primer nodo
		while (actual.dato != clave) { // hasta que sea encontrado,
			actual = actual.sig; // avanza al siguiente nodo
			if (actual == null)
				return null; // no encontr� �sta clave
		}
		if (actual == primero) // encontr� la clave; �primer nodo?
			primero = actual.sig; // primero --> sig de actual
		else // no es el primer nodo,  sig del ant de actual --> sig de actual
			actual.ant.sig = actual.sig;

		if (actual == ultimo) // ��ltimo nodo?
			ultimo = actual.ant; // ant de actual <-- ultimo
		else // no es el �ltimo, ant de actual <-- ant del sig de actual
			actual.sig.ant = actual.ant;
		return actual; // retorna valor
	}
	// -------------------------------------------------------------
	public void despliegaAdelante() {
		System.out.print("Lista (primero-->�ltimo): ");
		Nodo actual = primero; // inicia desde el primero nodo
		while (actual != null) { // hasta el final de la lista,
			actual.despliegaNodo(); // despliega dato
			actual = actual.sig; // avanza al siguiente nodo
		}
		System.out.println("");
	}
	// -------------------------------------------------------------
	public void despliegaAtras() {
		System.out.print("Lista (�ltimo-->primero): ");
		Nodo actual = ultimo; // inicia desde el ultimo nodo
		while (actual != null) { // hasta el primer nodo de la lista,
			actual.despliegaNodo(); // despliega dato
			actual = actual.ant; // avanza al anterior nodo
		}
		System.out.println("");
	}
	// -------------------------------------------------------------
} // fin clase ListaDoblementeEnlazada
