package bocolalistadoble;

class Link {
	public Link next;
	public long Dato;

	public Link prev;

	public Link(long d) {
		Dato = d;
	}

	public void displayLink() {
		System.out.print(Dato + " ");
	}
}
