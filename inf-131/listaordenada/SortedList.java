class SortedList<E> {
	private Link<E> F;

	public SortedList() {
		F = null;
	}

	public boolean isEmpty() {
		return (F == null);
	}

	public void insert(Class<? extends Object> class1) {
		Link<E> aux = new Link(class1);
		Link<E> aux2 = null;
		Link<E> aux3 = F;
		// while (aux3 != null && key > aux3.Dato) {
		while (aux3 != null
				&& class1.toString().compareTo(aux3.Dato.toString()) > 0) {
			aux2 = aux3;
			aux3 = aux3.next;
		}
		if (aux2 == null)
			F = aux;
		else
			aux2.next = aux;
		aux.next = aux3;
	}

	public E remove() {
		Link<E> aux = F;
		F = F.next;
		return aux.Dato;
	}

	public void displayList() {
		Link aux3 = F;
		while (aux3 != null) {
			aux3.displayLink();
			aux3 = aux3.next;
		}
		System.out.println("");
	}
}