/**
 * Mtodos para manejar una iterador de una lista enlazada simple.
 * 
 * @author Jhonny Felipez
 * @version 1.00 13/04/11
 */
class IteradorLista 
{
	private Nodo actual; 
	private Nodo anterior;
	private ListaEnlazada lista; 

	public IteradorLista(ListaEnlazada l) 
	{ 
		lista = l;
		reset();
	}
	
	public void reset() 
	{
		actual = lista.getPrimero();
		anterior = null;
	}
	
	public boolean estaAlFinal() 
	{
		return (actual.sig == null);
	}

	public void sigNodo() 
	{
		anterior = actual;
		actual = actual.sig;
	}
	
	public Nodo getActual() 
	{
		return actual;
	}
	
	public void insertaDespues(int d) 
	{
		Nodo nuevo = new Nodo(d);

		if (lista.estaVacia()) 
		{ 
			lista.setPrimero(nuevo);
			actual = nuevo;
		} 
		else 
		{
			nuevo.sig = actual.sig;
			actual.sig = nuevo;
			sigNodo();
		}
	}
	public void insertaAntes(int d) 
	{
		Nodo nuevo = new Nodo(d);

		if (anterior == null) 
		{
			nuevo.sig = lista.getPrimero();
			lista.setPrimero(nuevo);
			reset();
		}
		 else 
		{
			nuevo.sig = anterior.sig;
			anterior.sig = nuevo;
			actual = nuevo;
		}
	}

	public int eliminaActual() 
	{
		int valor = actual.dato;
		if (anterior == null) 
		{
			lista.setPrimero(actual.sig);
			reset();
		}
		 else 
		{ 
			anterior.sig = actual.sig;
			if (estaAlFinal())
				reset();
			else
				actual = actual.sig;
		}
		return valor;
	}
	//busca(d), el cual retorna el nodo dada la clave d
	public Nodo busca(int d)
	{
		reset();
		while(actual!= null)
		{
			if(getActual().dato==d)
			{
				Nodo ret= new Nodo(eliminaActual());
				return(ret);
			}
			sigNodo();
		}
		return(null);
	}
	public void Remplaza(int d, int d1)
	{
	    reset();
	    while(actual!=null)
	    {
		if(getActual().dato==d)
		{
		    getActual().dato=d1;
		}
		sigNodo();
	    }
	}
}
