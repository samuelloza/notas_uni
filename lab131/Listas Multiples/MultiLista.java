/**
 * Métodos para manejar una Lista Multiple
 * 
 * @author Jhonny Felipez
 * @version 1.00 09/05/2011
 */
class MultiLista {
	private Nodo_L primero;
	private boolean primeraVez = true;
	// inicia la lista enlazada
	public MultiLista() {
		primero = null;
	}

	// determina si la lista esta vacia
	public boolean estaVacia() {
		return (primero == null);
	}

	// adiciona nodo si no existe, ademas adiciona un nodo en la sublista.
	public boolean inserta(int e, int e1) {
		Nodo_L p1, p2;
		Nodo_SL q1, q2;
		// ¿es el primer nodo de la lista?
		if (primeraVez) {
			primero = new Nodo_L(e); // crea nodo de la lista
			q1 = new Nodo_SL(e1); // crea nodo en la sub lista
			primero.enlace_sublista = q1; // enlaza lista a la sublista
			primeraVez = false;
		} else {
			// la lista tiene mas de un nodo entonces busca nodo con dato = 'e'

			boolean existe_nodo = false;
			boolean existe_nodo_SL = false;
			p1 = primero; // principio de la lista
			p2 = primero;

			// busca el nodo en la lista con dato = 'e'
			while (!existe_nodo && p1 != null) {
				if (p1.dato == e)
					existe_nodo = true;
				else {
					p2 = p1;
					p1 = p1.enlace_lista;
				}
			}

			// ¿no existe nodo en la lista con dato = 'e'?
			if (!existe_nodo) {
				p1 = new Nodo_L(e); // crea nodo de la lista
				q1 = new Nodo_SL(e1); // crea nodo en la sublista
				p1.enlace_sublista = q1; // enlaza lista a la sublista
				p2.enlace_lista = p1;
			} else {
				// la lista tiene un nodo con dato = 'e' entonces
				// busca un nodo en la sublista con dato = 'e1'

				q1 = p1.enlace_sublista; // principio de la sublista
				q2 = q1;

				// busca el nodo en la sub lista con dato = 'e1'
				while ((!existe_nodo_SL) && (q1 != null)) {
					if (q1.dato == e1)
						existe_nodo_SL = true;
					else {
						q2 = q1;
						q1 = q1.sig; // siguiente nodo
					}
				}

				// ¿no existe nodo en la sublista con dato = 'e1'?
				if (!existe_nodo_SL) {
					q1 = new Nodo_SL(e1); // crea nodo en la sublista
					q2.sig = q1; // enlaza a la sublista
				} else
					System.out
							.println("El nodo de la sublista ya esta registrado");
			}
		}
		return (true);
	}

	// Consulta si existe un nodo en la lista.
	public Nodo_L consultaNodo(int e) {
		Nodo_L p = primero; // principio de la lista
		boolean existe = false;

		// busca el nodo en la lista con dato = 'e'
		while ((p != null) && (!existe)) {
			if (p.dato == e)
				existe = true;
			else
				p = p.enlace_lista; // siguiente nodo
		}

		if (existe)
			return (p);
		else
			return (null);
	}

	// Consulta si existe un nodo en una sublista.
	public String consultaSubNodo(int e, int e1) {
		Nodo_L p;
		Nodo_SL q;
		String salida;

		p = primero; // principio de la lista
		boolean existe = false;

		// busca el nodo en la lista con dato = 'e'
		while ((p != null) && (!existe)) {
			if (p.dato == e)
				existe = true;
			else
				p = p.enlace_lista; // siguiente nodo
		}

		// ¿existe nodo en la lista con dato = 'e'?
		if (existe) {
			existe = false;
			q = p.enlace_sublista; // principio de la sublista

			// busca el nodo en la sub lista con dato = 'e1'
			while ((q != null) && (!existe)) {
				if (q.dato == e1) {
					salida = "Sub nodo encontrado = " + String.valueOf(q.dato);
					existe = true;
					return (salida);
				} else {
					q = q.sig; // siguiente nodo
				}
			}
			salida = "ERROR. No se encontro el sub nodo";
		} else {
			salida = "ERROR. No se encontro el nodo";
		}
		return (salida);
	}

	// Despliega la sub lista
	public void despliegaSubLista(Nodo_L p) {
		// System.out.print(" Sub Lista (primero -> ultimo): ");
		System.out.print(": ");
		Nodo_SL actual = p.enlace_sublista; // principio de la sub lista
		while (actual != null) { // mientras no sea fin de la sub lista
			actual.despliegaNodo(); // imprime dato
			actual = actual.sig; // siguiente nodo
		}
		System.out.println();
	}
} // fin clase MultiLista