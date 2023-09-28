package pila.numerico;
/**
 * M�todos para manejar una pila.
 * 
 * @author Jhonny Felipez
 * @version 1.00 15/08/11
 */
class Pila {
	private int MAXIMO; // tama�o de la pila
	private long[] arreglo;
	private int tope; // tope de la pila
	// --------------------------------------------------------------
	public Pila(int t) { // constructor
		MAXIMO = t; // asigna el tama�o del arreglo
		arreglo = new long[MAXIMO]; // crea arreglo
		tope = -1; // todavia no tiene elementos
	}
	// --------------------------------------------------------------
	public void inserta(long e) { // inserta un elemento en la cima de la pila
		if (!estaLlena())
			arreglo[++tope] = e; // incrementa tope, inserta elemento
		else
			System.out.println("No puede insertar, la pila est� llena.");
	}
	// --------------------------------------------------------------
	public long elimina() { // elimina un elemento de la cima de la pila
		long valor = Long.MIN_VALUE;
		if (!estaVacia())
			valor = arreglo[tope--]; // retorna el elemento, decrementa el tope
		else
			System.out.println("No puede eliminar, la pila est� vacia.");
		return valor;
	}
	// --------------------------------------------------------------
	public long peek() { // obtiene el elemento de la cima de la pila
		return arreglo[tope];
	}
	// --------------------------------------------------------------
	public boolean estaVacia() { // verdad si la pila est� vacia
		return (tope == -1);
	}
	// --------------------------------------------------------------
	public boolean estaLlena() { // verdad si la pila est� llena
		return (tope == MAXIMO - 1);
	}
	// --------------------------------------------------------------
} // fin de la clase Pila
