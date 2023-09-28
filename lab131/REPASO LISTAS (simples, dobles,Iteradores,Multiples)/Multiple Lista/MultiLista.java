/**
 * Métodos para manejar una Lista Multiple
 * @author Jhonny Felipez
 * @version 1.00 09/05/2011
 */
class MultiLista 
{
	private Nodo_L primeroM;

	public MultiLista() 
	{
		primeroM = null;
	}

	public boolean estaVacia() 
	{
		return (primeroM == null);
	}

	public void insertaPrimero(String d, ListaPrimeroUltimo L) 
	{ 
		Nodo_L x = new Nodo_L(d); 
		x.enlace_sublista=L.primero;
		x.sig = primeroM;
		primeroM = x;
	}

	public void insertaUltimo (String d,ListaPrimeroUltimo L)
	{
		Nodo_L x = new Nodo_L (d);
		Nodo_L y;
		x.enlace_sublista = L.primero;
		if (estaVacia ())
			primeroM = x;
		else
		{
			y = primeroM;
			while (y.sig != null)
				y = y.sig;
			y.sig = x;
		}
	}


	// Consulta si existe un nodo en la lista.
	public Nodo_L consultaNodo(String e) 
	{
		Nodo_L p = primeroM; // principio de la lista
		boolean existe = false;

		// busca el nodo en la lista con dato = 'e'
		while (p != null && existe== false) 
		{
			if (p.nom_ciudad.equals(e))
				existe = true;
			else
				p = p.sig; // siguiente nodo
		}

		if (existe)
			return (p);
		else
			return (null);
	}

	public void mostrar()
	{
		ListaPrimeroUltimo L = new ListaPrimeroUltimo ();
		Nodo_L x;
		x = primeroM;
		System.out.println ("\nLISTA MULTIPLE");
		while (x != null)
		{
			System.out.println("\nCIUDAD:"+x.nom_ciudad);
			L.primero = x.enlace_sublista;
			L.despliegaLista();
			x = x.sig;
		}
	}
	// Despliega la sub lista
	public void despliegaSubLista(Nodo_L p) 
	{
		System.out.print(": ");
		Nodo_SL actual = p.enlace_sublista; // principio de la sub lista
		while (actual != null) { // mientras no sea fin de la sub lista
			actual.despliegaNodo(); // imprime dato
			actual = actual.sig; // siguiente nodo
		}
		System.out.println();
	}
	
} // fin clase MultiLista