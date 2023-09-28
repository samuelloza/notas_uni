/**
 * Nodo que es parte de una Lista Multiple.
 * 
 * @author Jhonny Felipez
 * @version 1.00 09/05/2011
 */
class Nodo_L {
	int dato; // dato entero (clave)
	public Nodo_SL enlace_sublista; // enlace al primer nodo de la sub lista
	public Nodo_L enlace_lista; // enlace al siguiente nodo de la lista
	
	public Nodo_L(int e) { // constructor
		dato = e; // inicializa dato
		enlace_sublista = null;
		enlace_lista = null;
	}
	
	public void despliegaNodo() { // se despliega asímismo
		System.out.print("{" + dato + "} ");
	}
} // fin clase Nodo_L