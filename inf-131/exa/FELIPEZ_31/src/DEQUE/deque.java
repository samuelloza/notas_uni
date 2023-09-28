package DEQUE;

public class deque {
	int MAX;
	public int F;
	public int R;
	long[] Q;
	int nroElementos;

	public deque(int max) {
		MAX = max;
		int F = 0;
		int R = -1;
		Q = new long[MAX];
	}

	public boolean isEmpty() {
		return (nroElementos==0);
	}

	public void insertLeft(long x) { //IZQUIERDA
		if (!isFull()) {
			if (R == -1) 
				R = MAX;
			R = (((R - 1) + MAX) % MAX);
			Q[R] = x;
		} else
			System.out.println("No se puede insertar, la cola está llena.");
		
	nroElementos++;
	}

	public long removeRight() {
		long x = 0;
		if (isEmpty())
			System.out.println("error...");
		else {
			x = Q[R];
			R = ((R - 1) + MAX) % MAX;
		}
		nroElementos--;
		return x;
	}

	public void insertRight(long x) {
		if (!isFull()) {
			if (R == MAX - 1) 
				R = -1;
			Q[++R] = x; 
		} else
			System.out.println("No se puede insertar, la cola está llena.");
		nroElementos++;

	}

	public long removeLeft() {
		long x = 0;
		if (isEmpty())
			System.out.println("Queue is empty");
		else {
			F = (F + 1) % MAX;
			x = Q[F];
		}
		nroElementos--;
		return x;
	}

	public boolean isFull() {
	//	return ((R + 1) % MAX == F);
		return (nroElementos == MAX);
	}
}