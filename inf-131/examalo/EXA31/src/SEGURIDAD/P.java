package SEGURIDAD;

class P extends Q1 {
	private int MAX;
	private long[] P;
	private int F;

	public P(int s) {
		super();
		MAX = s;
		P = new long[MAX];
		F = -1;
	}

	public void inserta(long j) {
		if (!estaLlena()) {
			adicionaQ(j);
			num++;
			F++;
		} else {
			System.out.println("ESTA LLENA");
		}
	}

	public long elimina() {
		long valor = Long.MIN_VALUE;
		if (!estaVacia()) {
			valor = eliminaQ2();
			--num;
		}
		return valor;
	}


	public long elimina2() {
		long valor = Long.MIN_VALUE;
		if (!estaVacia()) {
			valor = eliminaQ();
			num--;
			--F;
		} else {
			System.out.println("ERROR");
		}
		return valor;
	}


	public long peek() {
		return peekQ();
	}

	public boolean estaVacia() {
		return (num == -1);
	}

	public boolean estaLlena() {
		return (F == MAX - 1);
	}

	// public void a(long j, Q1 a, Q2 b) {
	// if (!estaLlena()) {
	// if (j % 2 == 0) {
	// a.adiciona(j);
	// } else {
	// b.adiciona(j);
	// }
	// } else {
	// System.out.println("LLENA :-(");
	// }
	//
	// }
	//
	// public void mostrarA(int parametro, Q1 a, Q2 b) {
	// if (!estaVacia()) {
	// if (parametro % 2 == 0) {
	// while (!a.estaVacia()) {
	// System.out.println(a.elimina());
	// }
	// } else {
	// while (!b.estaVacia()) {
	// System.out.println(b.elimina());
	// }
	// }
	// }
	// else {
	// System.out.println("VACIA");
	// }
	// }
}