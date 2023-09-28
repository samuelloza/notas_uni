package practica2;

public class Bicola {
	private int maxSize;
	private long[] Bicola;
	private int front;
	private int rear;
	private int size; // no se donde poner o hacer eso

	public Bicola(int num) {
		maxSize = num;
		Bicola = new long[maxSize];
		front = 0;
		rear = -1;
		num = 0;
	}

	public void InsertDer(long j) {
		if (rear == maxSize - 1)
			rear = -1;
		Bicola[++rear] = j;
		size++;
	}

	public void InsertIzq(long j) {
		if (front == maxSize - 1)
			front = 0;
		Bicola[++front] = j;
		size++;
	}

	public long removeDer() {
		long temp = Bicola[front++];
		if (front == maxSize)
			front = 0;
		size--;
		return temp;
	}

	public long removeIzq() {
		long temp = Bicola[rear++];
		if (rear == maxSize)
			rear = -1;
		size--;
		return temp;
	}

	public long peekDer() {
		return Bicola[front];
	}

	public long peekIzq() {
		return Bicola[rear];
	}

	public boolean isEmpty() {
		return (rear + 1 == front || (front + maxSize - 1 == rear));
	}

	public boolean isFull() {
		return (rear + 2 == front || (front + maxSize - 2 == rear));
	}

	public int size() {
		if (rear >= front)
			return rear - front + 1;
		else
			return (maxSize - front) + (rear + 1);
	}

	public void Mostrar() {
		Bicola aux = new Bicola(maxSize);
		while (!isEmpty()) {
			long a = removeDer();
			aux.InsertIzq(a);
			System.out.println(a);
		}

		while (!aux.isEmpty()) {
			long a = aux.removeDer();
			InsertIzq(a);
		}

	}

}
