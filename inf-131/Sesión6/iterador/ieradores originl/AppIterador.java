import java.io.*;
/**
 * Aplicación de un iterador de una lista enlazada simple.
 * 
 * @author Jhonny Felipez
 * @version 1.00 13/04/11
 */
class AppIterador {
	public static void main(String[] args) throws IOException {
		ListaEnlazada laLista = new ListaEnlazada(); // nueva lista
		IteradorLista iterador = laLista.getIterador(); // nuevo iterador
		int value;

		iterador.insertaDespues(20); // adicionamos elementos
		iterador.insertaDespues(40);
		iterador.insertaDespues(80);
		iterador.insertaAntes(60);

		while (true) {
			System.out.print("Ingrese primera letra de [m]uestra, [r]eset, ");
			System.out.print("[s]iguiente, [o]btiene, [a]ntes, [d]espues, [e]limina, [f]inaliza: ");
			System.out.flush();
			int opcion = getChar(); // obtiene opción
			switch (opcion) {
			case 'm': // muestra la lista
				if (!laLista.estaVacia())
					laLista.despliegaLista();
				else
					System.out.println("La lista está vacia");
				break;
			case 'r': // reset (actual toma la dirección de primero)
				iterador.reset();
				break;
			case 's': // avanza al siguiente nodo
				if (!laLista.estaVacia() && !iterador.estaAlFinal())
					iterador.sigNodo();
				else
					System.out.println("No puede ir al siguiente nodo");
				break;
			case 'o': // obtiene actual elemento
				if (!laLista.estaVacia()) {
					value = iterador.getActual().dato;
					System.out.println("Retorna " + value);
				} else
					System.out.println("La lista está vacia");
				break;
			case 'a': // inserta antes de actual
				System.out.print("Ingrese valor a insertar: ");
				System.out.flush();
				value = getInt();
				iterador.insertaAntes(value);
				break;
			case 'd': // inserta después de actual
				System.out.print("Ingrese valor a insertar: ");
				System.out.flush();
				value = getInt();
				iterador.insertaDespues(value);
				break;
			case 'e': // elimina elemento donde apunta actual
				if (!laLista.estaVacia()) {
					value = iterador.eliminaActual();
					System.out.println("Elimina " + value);
				} else
					System.out.println("No puede eliminar");
				break;
			case 'f': // Saleelimina elemento donde apunta actual
				return;
			default:
				System.out.println("Entrada no valida");
			} // fin switch
		} // fin while
	} // fin main()
	// --------------------------------------------------------------

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	// -------------------------------------------------------------
	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	// -------------------------------------------------------------
	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
	// -------------------------------------------------------------
} // fin clase AppIterador
