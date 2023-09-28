/**
 * Sub Nodo que es parte de una Sub Lista.
 * 
 * @author Jhonny Felipez
 * @version 1.00 09/05/2011
 */
class Nodo_SL {
	int dato; // dato entero (clave)
	public Nodo_SL sig; // enlace al siguiente nodo de la sub lista
	
	public Nodo_SL(int e1) { // constructor
		dato = e1; // inicializa dato
		sig = null;
	}
	
	public void despliegaNodo() { // se despliega asímismo
		System.out.print("{" + dato + "} ");
	}
} // fin clase Nodo_SL