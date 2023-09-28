package practica2;

public class Bicola {
	private int maxSize;
	private long[] Bicola;
	private int front;
	private int rear;
	public int size=0;

	public Bicola(int num) {
		maxSize = num;
		Bicola = new long[maxSize];
		front = 0;
		rear = 0;
	}

	public long peekDer() {
		return Bicola[front];
	}

	public long peekIzq() {
		return Bicola[rear];
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public boolean isFull() {
		return size() == maxSize - 1;
	}

	public void InsertDer(long j) {
		rear = (rear + 1) % maxSize;
		Bicola[rear] = j;
		size++;
	}

	public void InsertIzq(long j) {
		Bicola[front] = j;
		if (front == 0)
			front = maxSize - 1;
		else
			front = (front - 1) % maxSize;
		
		size++;
	}

	public long removeDer() {
		long e;
		e = Bicola[rear];
		if (rear == 0)
			rear = maxSize - 1;
		else
			rear = (rear - 1) % maxSize;
		size--;
		return e;
	}

	public long removeIzq() {
		long e;
		if (rear == maxSize)
		rear = (rear + 1) % maxSize;
		e = Bicola[front];
		size--;
		return e;
	}

	public int size() {
		return (size);
	}

	public void Mostrar() {
		long e;
		for (int i = 1; i <= size(); i++) {
			e = removeIzq();
			System.out.println(e);
			InsertDer(e);
		}
	}

}
