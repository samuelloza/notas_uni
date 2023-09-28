package pila.numerico.mejorado;
/**
 * Métodos para manejar una pila.
 * 
 * @author Jhonny Felipez
 * @version 1.00 15/08/11
 */
class Pila {
	private int MAXIMO; // tamaño de la pila
	private long[] arreglo;
	private int tope; // tope de la pila
	// --------------------------------------------------------------
	public Pila(int s) { // constructor
		MAXIMO = s; // asigna el tamaño del arreglo
		arreglo = new long[MAXIMO]; // crea arreglo
		tope = -1; // todavia no tiene elementos
	}
	// --------------------------------------------------------------
	public void inserta(long j) { // inserta un elemento en la cima de la pila
		try {
			arreglo[++tope] = j; // incrementa tope, inserta elemento
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("No puede insertar, la pila está llena.");
		}
	}
	// --------------------------------------------------------------
	public long elimina() { // elimina un elemento de la cima de la pila
		long valor = Long.MIN_VALUE;
		try {
			valor = arreglo[tope--]; // retorna el elemento, decrementa el tope
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("No puede eliminar, la pila está vacia.");
		}
		return valor;
	}
	// --------------------------------------------------------------
	public long peek() { // obtiene el elemento de la cima de la pila
		return arreglo[tope];
	}
	// --------------------------------------------------------------
	public boolean estaVacia() { // verdad si la pila está vacia
		return (tope == -1);
	}
	// --------------------------------------------------------------
	public boolean estaLlena() { // verdad si la pila está llena
		return (tope == MAXIMO - 1);
	}
	// --------------------------------------------------------------
} // fin de la clase Pila
