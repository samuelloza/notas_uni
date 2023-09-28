/**
 * Sub Nodo que es parte de una Sub Lista.
 * 
 * @author Jhonny Felipez
 * @version 1.00 09/05/2011
 */
class Nodo_SL {
	String nom_persona; // dato entero (clave)
	public Nodo_SL sig; // enlace al siguiente nodo de la sub lista
	
	public Nodo_SL(String nomp) { // constructor
		nom_persona=nomp; // inicializa dato
		sig = null;
	}
	
	public void despliegaNodo() { // se despliega asímismo
		System.out.print("{" + nom_persona + "} ");
	}
} // fin clase Nodo_SL