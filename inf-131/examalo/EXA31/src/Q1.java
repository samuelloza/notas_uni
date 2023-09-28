public class Q1 {
	int MAXIMO;
	long[] Q;
	int F;
	int R;
	int num;

	public Q1() {
		MAXIMO = 12;
		Q = new long[MAXIMO];
		F = 0;
		R = -1;
		num = 0;
	}

	public void adicionaQ(long x) {
		if (!estaLlenaQ()) {
			if (R == MAXIMO - 1)
				R = -1;
			Q[++R] = x;
			num++;
		} else
			System.out.println(":.Error:.");
	}

	public long eliminaQ() {
		long valor = Long.MIN_VALUE;
		if (!estaVaciaQ()) {
			valor = Q[R];
			R = ((R - 1) + MAXIMO) % MAXIMO;
			--num;
		}

		return valor;
	}

	public long eliminaQ2() {
		long valor = Long.MIN_VALUE;
		if (!estaVaciaQ()) {
			F = ((F + MAXIMO) % MAXIMO);
			valor = Q[F];
			F++;
			--num;
		}
		return valor;
	}

	public long peekQ() {
		return Q[R];
	}

	public boolean estaVaciaQ() {
		return (num == 0);
	}

	public boolean estaLlenaQ() {
		return (num == MAXIMO);
	}
}
