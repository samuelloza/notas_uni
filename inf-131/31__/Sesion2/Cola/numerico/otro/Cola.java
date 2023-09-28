package cola.numerico.otro;

/**
 * Metodos para manejar una Cola Simple Circular
 * 
 * @author Jhonny Felipez
 * @version 1.00 15/08/11
 * 
 */
class Cola {
	private int MAXIMO;
	private long[] arreglo;
	private int inicio;
	private int fin;
	// --------------------------------------------------------------
	public Cola(int t) { // constructor
		MAXIMO = t+1; // el arreglo es 1 posición más
		arreglo = new long[MAXIMO];
		inicio = 0;
		fin = -1;
	}
	// --------------------------------------------------------------
	public void adiciona(long e) { // adiciona un elemento al final de la Cola
		if (!estaLlena()) {
			if (fin == MAXIMO - 1) // consulta para reiniciar
				fin = -1;
			arreglo[++fin] = e; // incrementa fin y adiciona
		} else 
			System.out.println("No se puede insertar, la cola está llena.");
	}
	// --------------------------------------------------------------
	public long elimina() { // elimina un elemento del principio de la Cola
		long valor = Long.MIN_VALUE;
		if (!estaVacia()) {
			valor = arreglo[inicio++]; // obtiene el valor e incrementa inicio
			if (inicio == MAXIMO) // consulta para reiniciar
				inicio = 0;
		} else
			System.out.println("No se puede eliminar, la cola está vacia.");
		return valor;
	}
	// --------------------------------------------------------------
	public long peek() { // obtiene el elemento del inicio de la Cola
		return arreglo[inicio];
	}
	// --------------------------------------------------------------
	public boolean estaVacia() { // verdad si la Cola esta vacía
		return (fin + 1 == inicio || (inicio + MAXIMO - 1 == fin));
	}
	// --------------------------------------------------------------
	public boolean estaLlena() { // verdad si la Cola esta llena
		return (fin + 2 == inicio || (inicio + MAXIMO - 2 == fin));
	}
	// --------------------------------------------------------------
	public int tamanio() { // número de elementos de la Cola
		if (fin >= inicio)
			return fin + inicio + 1;
		else
			return (MAXIMO - inicio) + (fin + 1);
	}
	// --------------------------------------------------------------
} // fin de la clase Cola

