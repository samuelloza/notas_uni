class ListaEnlazada 
{
	private Nodo primero;

	public ListaEnlazada() 
	{
		primero = null;
	}

	public Nodo getPrimero() 
	{ 
	    return primero; 
	}
	
	public void setPrimero(Nodo p) 
	{
	    primero = p;
	}
	
	public boolean estaVacia() 
	{
		return (primero == null);
	}
	
	public void despliegaLista() 
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

	public IteradorLista getIterador() 
	{  
	      return new IteradorLista(this);
	}                               

}