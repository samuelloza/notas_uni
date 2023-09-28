public class ColaPrioridad<E> {
	SortedList<E> aux;

	public ColaPrioridad() {
		aux = new SortedList();
	}

	public void insert(E x) {
	//	aux.insert(x);
	}

	public E remove() {
		return aux.remove();
	}

	public void display() {
		aux.displayList();
	}

	public void insert22(Class<? extends Object> class1) {
		aux.insert(class1);
	}
}
