/**
 * Nodo es parte de una lista enlazada simple.
 * 
 * @author Jhonny Felipez
 * @version 1.00 10/09/2011
 */
class Nodo {
	public int datoClave; // clave
	public String datoNombre; // nombre
	public Nodo sig; // enlace al siguiente nodo
	// -------------------------------------------------------------

	public Nodo(int dc, String dn) { // constructor
		datoClave = dc; // inicializa dato
		datoNombre = dn; // ('sig' tiene automaticamente el valor de nulo)
	}
	// -------------------------------------------------------------

	public void despliegaNodo() { // se despliega asimismo
		System.out.print("{" + datoClave + ", " + datoNombre + "} ");
	}
} // fin clase Nodo

