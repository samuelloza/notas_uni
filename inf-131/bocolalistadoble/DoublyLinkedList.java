package bocolalistadoble;

class DoublyLinkedList {
	private Link F;
	private Link L;

	public DoublyLinkedList() {
		F = null;
		L = null;
	}

	public boolean isEmpty() {
		return F == null;
	}

	public void insertF(long dd) {
		Link aux = new Link(dd);

		if (isEmpty())
			L = aux;
		else
			F.prev = aux;
		aux.next = F;
		F = aux;
	}

	public void insertL(long dd) {
		Link aux = new Link(dd);
		if (isEmpty())
			F = aux;
		else {
			L.next = aux;
			aux.prev = L;
		}
		L = aux;
	}

	public long deleteF() {
		Link aux = F;
		if (F.next == null)
			L = null;
		else
			F.next.prev = null;
		F = F.next;
		return aux.Dato;
	}

	public long deleteL() {
		Link aux = L;
		if (F.next == null)
			F = null;
		else
			L.prev.next = null;
		L = L.prev;
		return aux.Dato;
	}

	public boolean insertAfter(long key, long dd) {
		Link ant = F;
		while (ant.Dato != key) {
			ant = ant.next;

			if (ant == null)
				return false;
		}
		Link aux = new Link(dd);

		if (ant == L) {
			aux.next = null;
			L = aux;
		} else {
			aux.next = ant.next;
			ant.next.prev = aux;
		}
		aux.prev = ant;
		ant.next = aux;
		return true;
	}

	public Link deleteKey(long key) {
		Link ant = F;
		while (ant.Dato != key) {
			ant = ant.next;
			if (ant == null)
				return null;
		}
		if (ant == F)
			F = ant.next;
		else
			ant.prev.next = ant.next;

		if (ant == L)
			L = ant.prev;
		else
			ant.next.prev = ant.prev;
		return ant;
	}

	public void displayForward() {
		Link ant = F;
		while (ant != null) {
			ant.displayLink();
			ant = ant.next;
		}
		System.out.println("");
	}

	public void displayBackward() {
		Link ant = L;
		while (ant != null) {
			ant.displayLink();
			ant = ant.prev;
		}
		System.out.println("");
	}

	public long peek() {
		return F.Dato;
	}
	public long peek2() {
		return L.Dato;
	}
}