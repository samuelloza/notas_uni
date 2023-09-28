/**
 * Aplicación de una lista de dos extremos primero y último.
 * 
 * @author Jhonny Felipez
 * @version 1.00 31/03/11
 */
class AppPrimeroUltimo {
	public static void main(String[] args) {

		ListaPrimeroUltimo laLista = new ListaPrimeroUltimo();
		
		laLista.insertaPrimero(22); // inserta al principio
		laLista.insertaPrimero(44);
		laLista.insertaPrimero(66);
		
		laLista.insertaUltimo(11); // inserta al final
		laLista.insertaUltimo(33);
		laLista.insertaUltimo(55);

		laLista.despliegaLista(); // despliega la lista

		laLista.eliminaPrimero(); // elimina elementos
		laLista.eliminaPrimero();

		laLista.despliegaLista(); // despliega la lista
	} // fin main()
} // fin clase AppPrimeroUltimo