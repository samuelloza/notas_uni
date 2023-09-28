class P {
	private int MAX;
	Q1 aaa = new Q1();
	private int F;

	public P(int s) {
		super();
		MAX = s;
		F = -1;
	}

	public void inserta(long j) {
		if (!estaLlena()) {
			aaa.adicionaQ(j);
			aaa.num++;
			F++;
		} else {
			System.out.println("ESTA LLENA");
		}
	}

	public long elimina() {
		long valor = Long.MIN_VALUE;
		if (!estaVacia()) {
			valor = aaa.eliminaQ2();
			--aaa.num;
		}
		return valor;
	}

	public long elimina2() {
		long valor = Long.MIN_VALUE;
		if (!estaVacia()) {
			valor = aaa.eliminaQ();
			aaa.num--;
			--F;
		} else {
			System.out.println("ERROR");
		}
		return valor;
	}

	public long peek() {
		return aaa.peekQ();
	}

	public boolean estaVacia() {
		return (aaa.num == -1);
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