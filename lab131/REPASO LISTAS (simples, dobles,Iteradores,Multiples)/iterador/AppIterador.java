import java.util.*;
/**
 * Aplicacin de un iterador de una lista enlazada simple.
 * 
 * @author Jhonny Felipez
 * @version 1.00 13/04/11
 */
class AppIterador 
{
	public static void main(String args[]) 
	{
		ListaEnlazada laLista = new ListaEnlazada();
		IteradorLista iterador = laLista.getIterador();

		iterador.insertaDespues(20);
		iterador.insertaDespues(40);
		iterador.insertaDespues(80);
		iterador.insertaAntes(60);

		Scanner entrada= new Scanner(System.in);
		int value;

		while (true) 
		{
			System.out.print("Ingrese primera letra de \n[m]uestra, \n[r]eset, ");
			System.out.print("\n[s]iguiente, \n[o]btiene, \n[a]ntes, \n[d]espues, \n[e]limina, \n[f]inaliza, \n[b]usca, \nrempla[z]a:");
			char opcion =entrada.next().charAt(0);
			switch (opcion) 
			{
				case 'm':
					if (!laLista.estaVacia())
						laLista.despliegaLista();
					else
						System.out.println("La lista est vacia");
					break;
				case 'r':
					iterador.reset();
					break;
				case 's':
					if (!laLista.estaVacia() && !iterador.estaAlFinal())
						iterador.sigNodo();
					else
						System.out.println("No puede ir al siguiente nodo");
					break;
				case 'o':
					if (!laLista.estaVacia()) 
					{
						value = iterador.getActual().dato;
						System.out.println("Retorna " + value);
					} else
						System.out.println("La lista est vacia");
					break;
				case 'a': 
					System.out.print("Ingrese valor a insertar: ");
					value = Integer.parseInt(entrada.next());
					iterador.insertaAntes(value);
					break;
				case 'b':
					System.out.print("Ingrese valor a buscar a retornar: ");
					value = Integer.parseInt(entrada.next());
					System.out.print(iterador.busca(value).dato);
					break;
				case 'z':
					System.out.print("Ingrese la clave d: ");
					int d = Integer.parseInt(entrada.next());
					System.out.print("Ingrese la clave d1: ");
					int d1= Integer.parseInt(entrada.next());
					iterador.Remplaza(d, d1);
					break;
				case 'd': 
					System.out.print("Ingrese valor a insertar: ");
					value = Integer.parseInt(entrada.next());
					iterador.insertaDespues(value);
					break;
				case 'e': 
					if (!laLista.estaVacia()) 
					{
						value = iterador.eliminaActual();
						System.out.println("Elimina " + value);
					} else
						System.out.println("No puede eliminar");
					break;
				case 'f': 
					return;
				default:
					System.out.println("Entrada no valida");
			} 
		} 
	}
}
