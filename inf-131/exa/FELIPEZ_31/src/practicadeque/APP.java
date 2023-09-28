package practicadeque;

public class APP {
	public static void main(String[] args) {

		prioridad a = new prioridad(5);
		a.adiciona(1);
		System.out.print(a.peek() + " ");
		a.adiciona(20);
		System.out.print(a.peek() + " ");
		a.adiciona(25);
		System.out.print(a.peek() + " ");
		a.adiciona(0);
		System.out.print(a.peek() + " ");
		a.adiciona(12);
		System.out.print(a.peek() + " ");

		System.out.println("\n\nMOSTRANDO LA COLA DE PRIORIDAD \n");
		while (!a.estaVacia()) {
			System.out.println(a.elimina());
		}

	}
}
