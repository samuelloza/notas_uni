class ListaDoblementeEnlazada 
{
	private Nodo primero;
	private Nodo ultimo; 

	public ListaDoblementeEnlazada() 
	{ 
		primero = null;
		ultimo = null;
	}

	public boolean estaVacia() 
	{
		return (primero == null);
	}
	
	public void insertaInicio(int d) 
	{
		Nodo nuevo = new Nodo(d);
		if (estaVacia()) 
			ultimo = nuevo; 
		else
			primero.ant = nuevo; 
		nuevo.sig = primero; 
		primero = nuevo;
	}
	
	public void insertaFinal(int d) 
	{
		Nodo nuevo = new Nodo(d);
		if (estaVacia()) 
			primero = nuevo; 
		else 
		{
			ultimo.sig = nuevo; 
			nuevo.ant = ultimo; 
		}
		ultimo = nuevo;
	}

	public Nodo eliminaInicio() 
	{
		Nodo temp = primero;
		if (primero.sig == null) 
			ultimo = null; 
		else
			primero.sig.ant = null; 
		primero = primero.sig; 
		return temp;
	}
	
	public Nodo eliminaUltimo() 
	{ 
		Nodo temp = ultimo;
		if (primero.sig == null) 
			primero = null;
		else
			ultimo.ant.sig = null;
		ultimo = ultimo.ant;
		return temp;
	}
	public boolean insertaDespues(int clave, int d) 
	{
		Nodo actual = primero;
		while (actual.dato != clave) 
		{
			actual = actual.sig; 
			if (actual == null)
				return false;
		}
		Nodo nuevo = new Nodo(d);

		if (actual == ultimo) 
		{
			nuevo.sig = null; 
			ultimo = nuevo; 
		} 
		else 
		{
			nuevo.sig = actual.sig; 
			actual.sig.ant = nuevo; 
		}
		nuevo.ant = actual;
		actual.sig = nuevo;
		return true;
	}
	public Nodo eliminaClave(long clave) 
	{
		Nodo actual = primero; 
		while (actual.dato != clave) 
		{
			actual = actual.sig; 
			if (actual == null)
				return null;
		}
		if (actual == primero) 
			primero = actual.sig;
		else 
			actual.ant.sig = actual.sig;

		if (actual == ultimo) 
			ultimo = actual.ant; 
		else
			actual.sig.ant = actual.ant;
		return actual;
	}

	public void despliegaAdelante() 
{
		System.out.print("Lista (primero-->último): ");
		Nodo actual = primero;
		while (actual != null) 
		{
			actual.despliegaNodo();
			actual = actual.sig;
		}
		System.out.println("");
	}
	
	public void despliegaAtras() {
		System.out.print("Lista (último-->primero): ");
		Nodo actual = ultimo; 
		while (actual != null) 
		{
			actual.despliegaNodo();
			actual = actual.ant;
		}
		System.out.println("");
	}
	
}
