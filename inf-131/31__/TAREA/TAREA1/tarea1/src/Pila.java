class Pila {
	private int MAXIMO;
	private String[] arreglo;
	private int tope;
	public Pila(int t) {
		MAXIMO = t;
		arreglo = new String[MAXIMO];
		tope = -1;
	}
	public void inserta(String e) {
		if (!estaLlena())
			arreglo[++tope] = e;
		else
			System.out.println("No puede insertar, la pila está llena.");
	}

	public String elimina() {
		String valor = "";
		if (!estaVacia())
			valor = arreglo[tope--];
		else
			System.out.println("No puede eliminar, la pila está vacia.");
		return valor;
	}

	public String peek() {
		return arreglo[tope];
	}

	public boolean estaVacia() {
		return (tope == -1);
	}

	public boolean estaLlena() {
		return (tope == MAXIMO - 1);
	}

	public int Tope() {
		return (tope);
	}
}
