package pila.ejemplo1;

public class Invierte {
	private String entrada;	// cadena de entrada
	private String salida;	// cadena de salida
	// --------------------------------------------------------------
	public Invierte(String s) { // constructor
		entrada = s;
	}
	// --------------------------------------------------------------
	public String realizaInversion() { // invierte la cadena
		int tamanio = entrada.length(); // obtiene el tamaño maximo de la pila
		Pila laPila = new Pila(tamanio); // genera la pila
		
		for (int j = 0; j < entrada.length(); j++) {
			char ch = entrada.charAt(j); // obtiene un caracter de la entrada
			laPila.inserta(ch); // inserta éste
		}
		salida = "";
		while (!laPila.estaVacia()) {
			char ch = laPila.elimina(); // elimina un caracter
			salida = salida + ch; // actualiza la salida
		}
		return salida;
	} // fin realizaInversion
	// --------------------------------------------------------------
} // fin de la clase Invierte
