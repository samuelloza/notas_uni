package cola.numerico;
/**
 * Aplicación de una Cola Circular.
 * 
 * @author Jhonny Felipez
 * @version 1.00 15/08/11
 * 
 */
class AppCola {
	public static void main(String[] args) {
		Cola laCola = new Cola(5); // La cola Contiene 5 elementos

		laCola.adiciona(10); // adiciona 4 elementos
		laCola.adiciona(20);
		laCola.adiciona(30);
		laCola.adiciona(40);

		laCola.elimina(); // elimina 3 elementos
		laCola.elimina(); // (10, 20, 30)
		laCola.elimina();

		laCola.adiciona(50); // adiciona 4 elementos mas
		laCola.adiciona(60); // (al principio del arreglo)
		laCola.adiciona(70);
		laCola.adiciona(80);

		while (!laCola.estaVacia()) { // elimina y despliega todos los elementos
			long valor = laCola.elimina(); // (40, 50, 60, 70, 80)
			System.out.print(valor);
			System.out.print(" ");
		}
		System.out.println("");
	} // fin main()
} // fin de la clase AppCola
