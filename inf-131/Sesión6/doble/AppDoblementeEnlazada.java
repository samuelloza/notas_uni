/**
 * Aplicación de una lista doblemente enlazada.
 * 
 * @author Jhonny Felipez
 * @version 1.00 25/09/2011
 */
class AppDoblementeEnlazada {
	public static void main(String[] args) { 
		ListaDoblementeEnlazada laLista = new ListaDoblementeEnlazada(); // crea una nueva lista

		laLista.insertaInicio(22); // inserta al principio
		laLista.insertaInicio(44);
		laLista.insertaInicio(66);

		laLista.insertaFinal(11); // inserta al final
		laLista.insertaFinal(33);
		laLista.insertaFinal(55);

		laLista.despliegaAdelante(); // despliega la lista hacia adelante
		laLista.despliegaAtras(); // despliega la lista hacia atrás

		laLista.eliminaInicio(); // elimina primer nodo
		laLista.eliminaUltimo(); // elimina último nodo
		laLista.eliminaClave(11); // elimina nodo con la clave 11

		laLista.despliegaAdelante(); // despliega la lista hacia adelante

		laLista.insertaDespues(22, 77); // inserta 77 después del 22
		laLista.insertaDespues(33, 88); // inserta 88 después del 33

		laLista.despliegaAdelante(); // despliega la lista hacia adelante
	} // fin main()
} // fin clase AppDoblementeEnlazada