import java.util.Scanner;

class AppPila {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pila P1 = new Pila(200);
		Pila P2 = new Pila(200);
		System.out.println("DAME DATOS");
		String cad = sc.nextLine();
		for (int i = 0; i < cad.length(); i++) {
			if (cad.substring(i, i + 1).equals("(")
					|| cad.substring(i, i + 1).equals("{")) {

				P1.inserta(cad.substring(i, i + 1));
			}
		}
		for (int i = cad.length(); i >0 ; i--) {
			if (cad.substring(i-1, i ).equals(")")
					|| cad.substring(i-1,i).equals("}")) {
				P2.inserta(cad.substring(i-1,i));
			}
		}
		boolean sw = true;
		if (P1.Tope() != P2.Tope()) {
			 sw = false;
		} else {
			while (!P1.estaVacia() && sw) {
				Object a = P1.elimina();
				Object b = P2.elimina();
				if (a.equals("(")) {
					if (!b.equals(")")) {
						sw = false;
						break;
					}
				}
				if (a.equals("{")) {
					if (!b.equals("}")) {
						sw = false;
						break;
					}
				}

			}
		}
		if (sw) {
			System.out.println("..BALANCEADA..");
		} else {
			System.out.println("..NO.. BALANCEADA..");
		}

	}
}