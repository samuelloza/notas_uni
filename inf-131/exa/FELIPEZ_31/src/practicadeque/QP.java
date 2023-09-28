package practicadeque;
class QP {
	private int MAXIMO;
	private long[] arreglo;
	private int nroElementos;

	public QP(int t) { 
		MAXIMO = t;
		arreglo = new long[MAXIMO];
		nroElementos = 0;
	}

	public void inserta(long e) { 
		int j;
		if (!estaLlena()) {
			if (nroElementos == 0) 
				arreglo[nroElementos++] = e; 
			else { 
				for (j = nroElementos - 1; j >= 0; j--) { 
															
					if (e > arreglo[j]) 
						arreglo[j + 1] = arreglo[j]; 
														
					else
						break; 
				}
				arreglo[j + 1] = e; 
				nroElementos++;
			} 
		} else
			System.out.println("No se puede insertar, la cola está llena.");
	} 

	public long elimina() { 
		long valor = Long.MIN_VALUE;
		if (!estaVacia()) {
			valor = arreglo[--nroElementos];
		} else
			System.out.println("No se puede eliminar, la cola está vacia.");
		return valor;
	}

	public long peek() { 
		return arreglo[nroElementos - 1];
	}

	public boolean estaVacia() { 
		return (nroElementos == 0);
	}

	public boolean estaLlena() { 
		return (nroElementos == MAXIMO);
	}
} 
