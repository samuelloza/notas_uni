package jhimmy;

public class ColaCircularDobleA extends ColaD {
	
	public ColaCircularDobleA() {
		super();
	}

	public boolean esVacia() {
		if (ini == fin)
			return true;
		else
			return false;
	}

	public boolean esLlena() {
		if (nroElems() == MAX - 1)
			return true;
		else
			return false;
	}

	public void leer(int n) {
		for (int i = 1; i <= n; i++) {
			Auto e = new Auto();
			System.out.println("Auto " + i + " ");
			e.leer();
			System.out.println();
			adicionar_derecha(e);
		}
	}

	public void vaciar(ColaCircularDobleA C) {
		while (!C.esVacia())
			adicionar_derecha(C.eliminar_izquierda());
	}

	public void mostrar() {
		Auto e;
		for (int i = 1; i <= nroElems(); i++) {
			e = eliminar_izquierda();
			System.out.println("------------------");
			e.mostrar();
			System.out.println("------------------");
			System.out.println();
			adicionar_derecha(e);
		}
	}

	public int nroElems() {
		int nro = (fin - ini + MAX) % MAX;
		return (nro);
	}

	public Auto eliminar_derecha() {
		Auto a = null;
		if (!esVacia()) {
			a = R[fin];
			if (fin == 0)
				fin = MAX - 1;
			else
				fin = (fin - 1) % MAX;
		} else
			System.out.print("error");
		return a;
	}

	public void adicionar_izquierda(Auto au) {
		if (!esLlena()) {
			R[ini] = au;
			if (ini == 0)
				ini = MAX - 1;
			else
				ini = (ini - 1) % MAX;
		} else
			System.out.print("error");
	}

	public void adicionar_derecha(Auto e) {
		if (esLlena())
			System.out.println("Cola Circular Llena");
		else {
			fin = (fin + 1) % MAX;
			R[fin] = e;
		}
	}

	public Auto eliminar_izquierda() {
		Auto e = null;
		if (esVacia())
			System.out.println("Cola Circular Vacia");
		else {
			ini = (ini + 1) % MAX;
			e = R[ini];
		}
		return e;
	}
}
