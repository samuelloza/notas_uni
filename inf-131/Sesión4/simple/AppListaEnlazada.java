/**
 * Aplicación de una lista enlazada simple.
 * 
 * @author Jhonny Felipez
 * @version 1.00 10/09/2011
 */
class AppListaEnlazada {
	public static void main(String[] args) {
		ListaEnlazada laLista = new ListaEnlazada(); // crea nueva lista

		laLista.insertaPrimero(22, "Maria"); // inserta cuatro nodos
		laLista.insertaPrimero(44, "Jose");
		laLista.insertaPrimero(66, "Ana");
		laLista.insertaPrimero(88, "Juan");

		laLista.despliegaLista(); // despliega la lista

		while (!laLista.estaVacia()) { // hasta que esté vacía,
			Nodo temp = laLista.eliminaPrimero(); // elimina nodo
			System.out.print("Eliminado "); // despliega éste
			temp.despliegaNodo();
			System.out.println("");
		}
		laLista.despliegaLista(); // despliega la lista
	} // fin main()
} // fin clase AppListaEnlazada
