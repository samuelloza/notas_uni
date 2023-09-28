package bocolalistadoble;

public class Main {
	public static void main(String[] args) {
		DEQUE aux = new DEQUE();
		aux.insertF(12);
		aux.insertF(13);
		aux.insertF(14);
		aux.insertF(15);
		System.out.println("PEEK --->"+aux.peek());
		aux.displayF();
	}
}
