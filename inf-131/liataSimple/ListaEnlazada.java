
public class ListaEnlazada {

	 private Nodo primero; // hace referencia al primer nodo de la lista
     // -------------------------------------------------------------
     public ListaEnlazada() { // constructor
             primero = null; // la lista no tiene nodos
     }
     // -------------------------------------------------------------
     public boolean estaVacia() { // verdadero, si la lista est vaca
             return (primero == null);
     }
     // -------------------------------------------------------------
     public void insertaPrimero(int dc, String dn) { // inserta al principio de la lista
             Nodo nuevo = new Nodo(dc, dn); // nuevo nodo
             nuevo.sig = primero; // nuevo --> primero
             primero = nuevo; // primero --> nuevo
     }
     // -------------------------------------------------------------
     public Nodo eliminaPrimero() { // elimina el primer nodo de la lista (se asume que la lista no est vacia)
             Nodo temp = primero; // guarda la referencia del primero
             primero = primero.sig; // elimina ste: avanza primero al siguiente nodo
             return temp; // retorna nodo eliminado
     }
     // -------------------------------------------------------------
     public void despliegaLista() {
             System.out.print("Lista (primero-->a ultimo): ");
             Nodo actual = primero; // inicia al principio de la lista
             while (actual != null) { // hasta que sea fin de la lista,
                     actual.despliegaNodo(); // imprime dato
                     actual = actual.sig; // avanza al siguiente nodo
             }
             System.out.println("");
     }
     public int busca(Nodo z,int dc1){
    	 int aux=0;
    	 while(z.sig!=null){
    		 if(z.sig.equals(String.valueOf(dc1)))
    			 return z.getDatoClave();
    	 }
    	 return aux;
     }
     public void insertadespues(int dc,int dc1, String dn1){
    	 Nodo nodoaux=new Nodo(dc1,dn1);
    	 Nodo nuevo = primero;
    	 Nodo aux=primero;
    	 while(nuevo!=null){
    		 aux=nuevo;
    		 nuevo=nuevo.sig;
    		 if(aux.datoClave==dc){
    			 nodoaux.sig=nuevo;
    			 aux.sig=nodoaux;
    		 }
    	 }
     }
}
