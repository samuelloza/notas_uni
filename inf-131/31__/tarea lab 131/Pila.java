/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 *
 * @author Familia
 */
class Pila {
	private int MAXIMO; // tamaño de la pila
	private char[] arreglo;
	private int tope; // tope de la pila
	// --------------------------------------------------------------
	public Pila(int t) { // constructor
		MAXIMO = t; // asigna el tamaño del arreglo
		arreglo = new char[MAXIMO]; // crea arreglo
		tope = -1; // todavia no tiene elementos
	}
        public Pila() { // constructor
		MAXIMO = 0; // asigna el tamaño del arreglo
		arreglo = new char[MAXIMO]; // crea arreglo
		tope = -1; // todavia no tiene elementos
	}
	// --------------------------------------------------------------
	public void inserta(char e) { // inserta un elemento en la cima de la pila
		if (!estaLlena())
			arreglo[++tope] = e; // incrementa tope, inserta elemento
		else
			System.out.println("No puede insertar, la pila está llena.");
	}
	// --------------------------------------------------------------
	public long elimina() { // elimina un elemento de la cima de la pila
		long valor = Long.MIN_VALUE;
		if (!estaVacia())
			valor = arreglo[tope--]; // retorna el elemento, decrementa el tope
		else
			System.out.println("No puede eliminar, la pila está vacia.");
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
