package SEGURIDAD;

public class Q2 {
	int MAXIMO;
	long[] Q;
	int F;
	int R;
	int num;

	public Q2(int t) {
		MAXIMO = t;
		Q = new long[MAXIMO];
		F = 0;
		R = -1;
		num = 0;
	}

	public void adiciona(long e) {
		if (!estaLlena()) {
			if (R == MAXIMO - 1)
				R = -1;
			Q[++R] = e;
			num++;
		} else
			System.out.println(":-(");
	}

	public long elimina() {
		long valor = Long.MIN_VALUE;
		if (!estaVacia()) {
			valor = Q[F++];
			if (F == MAXIMO)
				F = 0;
			num--;
		} else
			System.out.println(":-(");
		return valor;
	}

	public long peek() {
		return Q[F];
	}

	public boolean estaVacia() {
		return (num == 0);
	}

	public boolean estaLlena() {
		return (num == MAXIMO);
	}
}
