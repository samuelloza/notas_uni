
class Link<E> {
	E Dato;
	Link<E> next;

	public Link(E dd) {
		Dato = dd;
	}

	public void displayLink() {
		System.out.print(Dato + " ");
	}
}




