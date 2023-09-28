class Nodo 
{
	public int dato;
	public Nodo sig;
	
	public Nodo(int d) 
	{ 
		dato = d;
	}

	public void despliegaNodo() 
	{
		System.out.print(dato + " ");
	}
}

