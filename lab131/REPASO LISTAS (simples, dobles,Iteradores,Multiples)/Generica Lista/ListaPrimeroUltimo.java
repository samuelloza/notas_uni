/**
 * Metodos para manejar una lista con dos extremos extremos primero y último.
 * 
 * @author Jhonny Felipez
 * @version 1.00 25/09/2011
 */
public class ListaPrimeroUltimo<T> 
{
	private Nodo<T> primero; 
	private Nodo<T> ultimo; 

	public ListaPrimeroUltimo() 
	{
		primero = null;
		ultimo = null;
	}
	
	public boolean estaVacia() 
	{
		return primero == null;
	}
	
	public void insertaPrimero(T d) 
	{
		Nodo <T>nuevo = new Nodo<T>(d); 
		if (estaVacia()) 
			ultimo = nuevo; 
		nuevo.sig = primero;
		primero = nuevo; 
	}

	public void insertaUltimo(T d) 
	{ 
		Nodo <T>nuevo = new Nodo<T>(d);
		if (estaVacia())
			primero = nuevo;
		else
			ultimo.sig = nuevo;
		ultimo = nuevo; 
	}

	public T eliminaPrimero() 
	{
		T temp =primero.dato;
		if (primero.sig == null)
			ultimo = null; 
		primero = primero.sig; 
		return temp;
	}

	public void despliegaLista() 
	{
		System.out.print("Lista (primero-->último): ");
		Nodo <T> actual = primero; 
		while (actual != null) 
		{
			actual.despliegaNodo();
			actual = actual.sig;
		}
		System.out.println("");
	}
} 