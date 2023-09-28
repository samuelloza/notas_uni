
public class Nodo {

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
	        public int getDatoClave(){
	        	return datoClave;
	        }
	} // fin clase Nodo



