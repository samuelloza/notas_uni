package bocolalistadoble;

public class DEQUE {
	DoublyLinkedList aux;

	public DEQUE() {
		aux = new DoublyLinkedList();
	}

	public void insertF(long x) {
		aux.insertF(x);
	}

	public void insertL(long x) {
		aux.insertL(x);
	}

	public long removeF() {
		return aux.deleteF();
	}

	public long removeL() {
		return aux.deleteL();
	}

	public void displayF() {
		aux.displayForward();
	}

	public void displayL() {
		aux.displayBackward();
	}

	public long peek() {
		return aux.peek();
	}

	public long peek2() {
		return aux.peek2();
	}
}
