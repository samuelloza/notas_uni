package practicadeque;

public class deque {
	int MAX;
	long[] Q;
	int R;
	int F;
	int nroEle;

	public deque(int n) {
		MAX = n;
		Q = new long[MAX];
		F = 0;
		R = -1;
		nroEle = 0;
	}

	// -----------------------------
	public void adiD(long x) {
		if (!isFull()) {
			if (R == MAX - 1)
				R = -1;
			Q[++R] = x;
			nroEle++;

		} else {
			System.out.println("error");
		}
	}

	public long removeD() {
		long a = Long.MIN_VALUE;
		if (!isEmpty()) {
			if (F == 0) {
				F = MAX;
			}
			a = Q[--F];
			F = ((F) + MAX) % MAX;
			nroEle--;
		} else {
			System.out.println("error");
		}

		return a;
	}

	// -----------------------------
	public void adIz(long x) {
		if (!isFull()) {
			if (R == -1) {
				R = MAX;
			}
			R = (((R - 1) + MAX) % MAX);
			Q[R] = x;
			nroEle++;
		} else {
			System.out.println("error");
		}
	}

	public long removeIzq() {
		long a = Long.MIN_VALUE;
		if (!isEmpty()) {
			a = Q[F];
			F++;
			if (F == MAX) {
				F = 0;
			}
			nroEle--;

		} else {
			System.out.println("error");
		}
		return a;
	}

	// -----------------------------

	public boolean isFull() {
		return nroEle == MAX;
	}

	public boolean isEmpty() {
		return nroEle == 0;
	}

	public long peek() {
		return Q[nroEle];
	}

}
