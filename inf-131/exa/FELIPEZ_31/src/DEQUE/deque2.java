package DEQUE;

class deque2 {
	private int MAXIMO;
	private long[] arreglo;
	private int inicio;
	private int fin;
	private int nroElementos;
	private int aux;

	public deque2(int t) {
		MAXIMO = t;
		arreglo = new long[MAXIMO];
		inicio = 0;
		fin = -1;
		nroElementos = 0;
	}

	public void adiciona(long e) {
		if (!estaLlena()) {
			if (fin == MAXIMO - 1)
				fin = -1;
			arreglo[++fin] = e;
			nroElementos++;
			aux = nroElementos;
		} else
			System.out.println("No se puede insertar, la cola está llena.");
	}

	public void adicionaizq(long e) {
		if (!estaLlena()) {
			if (fin == -1)
				fin = MAXIMO;
			fin = (((fin - 1) + MAXIMO) % MAXIMO);
			arreglo[fin] = e;
			nroElementos++; 
			aux = nroElementos;
		} else
			System.out.println("No se puede insertar, la cola está llena.");

	}

	public long elimina() {
		long valor = Long.MIN_VALUE;
		if (!estaVacia()) {
			valor = arreglo[inicio];
			inicio++;
			if (inicio == MAXIMO)
				inicio = 0;
			nroElementos--;
		} else
			System.out.println("No se puede eliminar, la cola está vacia.");
		return valor;
	}

	public long eliminader() {
		long valor = Long.MIN_VALUE;

		if (!estaVacia()) {
			if (inicio == 0) 
				inicio = MAXIMO;
			valor = arreglo[--inicio];
			inicio = ((inicio) + MAXIMO) % MAXIMO;
			nroElementos--; 
		} else
			System.out.println("No se puede eliminar, la cola está vacia.");
		return valor;

	}

	public long peek() { 
		return arreglo[inicio];
	}

	public boolean estaVacia() {
		return (nroElementos == 0);
	}

	public boolean estaLlena() { 
		return (nroElementos == MAXIMO);
	}

	public int tamanio() { 
		return nroElementos;
	}

	public void mostrar() {
		for (int i = 1; i <= aux; i++) {

			System.out.println(elimina());

		}
	}
}
