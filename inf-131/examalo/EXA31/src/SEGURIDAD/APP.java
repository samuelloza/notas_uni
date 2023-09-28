package SEGURIDAD;

public class APP {
	public static void main(String[] args) {
		P a = new P(4);
		a.inserta(12);
		System.out.println(a.peek());
		a.inserta(13);
		System.out.println(a.peek());
		a.inserta(14);
		System.out.println(a.peek());
		a.inserta(15);
		System.out.println(a.peek());

//		while (!a.estaVacia()) {
//			System.out.println(a.elimina2());
//		}
	//	while (!a.estaVacia()) {
	//		System.out.println(a.elimina());
	//	}

	}
}
