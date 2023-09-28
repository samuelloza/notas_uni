/**
 * Nodo es parte de una lista enlazada simple.
 * 
 * @author Jhonny Felipez
 * @version 1.00 25/09/2011
 */
class Nodo <T>
{
	public T dato; 
	public Nodo<T> sig; 
	
	public Nodo(T d) 
	{
		dato = d;
	}

	public void despliegaNodo() 
	{
		System.out.println();
		if(dato instanceof Edificio)
			((Edificio) dato).mostrar();
		else
			System.out.print(dato + " ");

	}
}

