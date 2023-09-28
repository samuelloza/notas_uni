public class APP {
	public static void main(String[] args) {
		P a = new P(4);
		a.inserta(12);
		System.out.print(a.peek() + " ");
		a.inserta(13);
		System.out.print(a.peek() + " ");
		a.inserta(14);
		System.out.print(a.peek() + " ");
		a.inserta(15);
		System.out.print(a.peek() + " \n");
		System.out.println("\n\t MOSTRANDO \n");
		 while (!a.aaa.estaVaciaQ()) {
		 System.out.println(a.elimina2());
		 }
//		while (!a.aaa.estaVaciaQ()) {
//			System.out.println(a.elimina());
//		}

	}
}
