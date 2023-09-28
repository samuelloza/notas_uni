/**
 * Metodos para manejar una lista con dos extremos extremos primero y último.
 * 
 * @author Jhonny Felipez
 * @version 1.00 25/09/2011
 */
public class ListaPrimeroUltimo 
{
	Nodo_SL primero; // hace referencia al primer Nodo_SL
	Nodo_SL ultimo; // hace referencia al último Nodo_SL
	// -------------------------------------------------------------
	public ListaPrimeroUltimo() { // constructor
		primero = null; // no hay elementos en la lista
		ultimo = null;
	}
	// -------------------------------------------------------------
	public boolean estaVacia() { // verdad, si la lista está vacía
		return primero == null;
	}
	// -------------------------------------------------------------
	public void insertaPrimero(String d) { // inserta al principio de la lista
		Nodo_SL nuevo = new Nodo_SL(d); // nuevo Nodo_SL
		if (estaVacia()) // si la lista está vacía
			ultimo = nuevo; // nuevo <-- ultimo 
		nuevo.sig = primero; // enlaza a la lista nuevo Nodo_SL
		primero = nuevo; // primero --> nuevo
	}
	// -------------------------------------------------------------
	public void insertaUltimo(String d) { // inserta al final de la lista
		Nodo_SL nuevo = new Nodo_SL(d); // crea un nuevo Nodo_SL
		if (estaVacia()) // si la lista está vacia,
			primero = nuevo; // primero --> nuevo
		else
			ultimo.sig = nuevo; // enlaza a la lista el nuevo
		ultimo = nuevo; // nuevo <-- ultimo
	}
	// -------------------------------------------------------------
	public String eliminaPrimero() { // elimina el primer Nodo_SL de la lista (se asume que la lista no está vacia)
		String temp = primero.nom_persona; // guarda la referencia del primero
		if (primero.sig == null) // si hay un elemento
			ultimo = null; // nulo <-- ultimo
		primero = primero.sig; // elimina éste, avanzando primero al siguiente Nodo_SL
		return temp; // retorna Nodo_SL eliminado
	}

	public String eliminaUltimo()
	{
		Nodo_SL actual=primero;
		Nodo_SL anterior=null;
		if(!estaVacia())
		{
			while(actual.sig!= null)
			{
				anterior=actual;
				actual=actual.sig;
			}
			String temp = actual.nom_persona;
			ultimo=anterior;
			if(anterior!=null)
				anterior.sig=null;
			return temp;
		}
		else
			return("-----fin-----");
	}
	// -------------------------------------------------------------
	public void despliegaLista() 
	{
		System.out.print("Lista: ");
		Nodo_SL actual = primero; // inicia al principio de la lista
		while (actual != null) { // hasta que sea fin de la lista,
			actual.despliegaNodo(); // imprime dato
			actual = actual.sig; // avanza al siguiente Nodo_SL
		}
		System.out.println("");
	}
	// -------------------------------------------------------------
} // fin clase ListaPrimeroUltimo