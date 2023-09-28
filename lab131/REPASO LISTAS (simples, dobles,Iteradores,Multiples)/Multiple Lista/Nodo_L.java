/**
 * Nodo que es parte de una Lista Multiple.
 * 
 * @author Jhonny Felipez
 * @version 1.00 09/05/2011
 */
class Nodo_L {
	String nom_ciudad; // dato entero (clave)
	public Nodo_SL enlace_sublista; // enlace al primer nodo de la sub lista
	public Nodo_L sig; // enlace al siguiente nodo de la lista
	
	public Nodo_L(String n) { // constructor
		nom_ciudad=n; // inicializa dato
		enlace_sublista = null;
		sig = null;
	}
	
	public void despliegaNodo() { // se despliega asímismo
		System.out.print("{" + nom_ciudad + "} ");
	}
} // fin clase Nodo_L