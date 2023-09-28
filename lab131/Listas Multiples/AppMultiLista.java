/**
 * Aplicación de una Lista Multiple
 *
 * @author Jhonny Felipez
 * @version 1.00 09/05/2011
 */
public class AppMultiLista {
    
    public static void main(String[] args) 
    {
        MultiLista lista = new MultiLista(); // nueva lista multiple

		lista.inserta(3,31); // insertamos 6 nodos
		lista.inserta(3,32);
		lista.inserta(3,33);
		lista.inserta(4,41);
		lista.inserta(4,42);
		lista.inserta(5,51);
		
		Nodo_L actual = lista.consultaNodo(3);
        if (actual != null) {
        	actual.despliegaNodo(); // imprime dato
        	lista.despliegaSubLista(actual);
        }
        actual = lista.consultaNodo(4);
        if (actual != null) {
        	actual.despliegaNodo(); // imprime dato
        	lista.despliegaSubLista(actual);
        }
        actual = lista.consultaNodo(5);
        if (actual != null) {
        	actual.despliegaNodo(); // imprime dato
        	lista.despliegaSubLista(actual);
        }
        
        System.out.println(lista.consultaSubNodo(3,33));
        System.out.println(lista.consultaSubNodo(5,52));
    }
} // fin clase AppMultiLista
