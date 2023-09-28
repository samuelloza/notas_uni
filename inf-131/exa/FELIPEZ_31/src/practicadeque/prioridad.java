package practicadeque;

class prioridad {
	private int MAX;
	private long[] Q;
	private int nroElementos;

	public prioridad(int t) {
		MAX = t;
		Q = new long[MAX];
		nroElementos = 0;
	}

	public void adiciona(long e) {
		if (!estaLlena()) {
			Q[nroElementos++] = e;
		} else
			System.out.println("No se puede insertar, la cola esta llena.");
	}

	public long elimina() {
		long valor = Long.MIN_VALUE;
		if (!estaVacia()) {
			if (nroElementos == 1) {
				valor = Q[--nroElementos];
				return valor;
			} else {
				for (int j = 0; j <= nroElementos - 1; j = j + 1) {
					if (j == nroElementos - 1) {
						break;
					} else {
						if (Q[j] > Q[j + 1]) {
							long aux = Q[j];
							Q[j] = Q[j + 1];
							Q[j + 1] = aux;
						}
					}
				}
				valor = Q[--nroElementos];
				return valor;
			}
		} else
			System.out.println("No se puede eliminar, la cola esta vacia.");
		return valor;
	}

	public long peek() {
		return Q[nroElementos - 1];
	
	}
	public long peek2() {
		return Q[0];

	}

	public boolean estaVacia() {
		return (nroElementos == 0);
	}

	public boolean estaLlena() {
		return (nroElementos == MAX);
	}

	public void mostrar() {
		for (int i = 0; i < nroElementos; i++) {
			long x = elimina();
			System.out.print(x + " ");
		}
	}
}
