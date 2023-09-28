package pila.ejemplo1;

import java.util.Scanner;
/**
 * Aplicación de una pila.
 * Invierte una palabra.
 * 
 * @author Jhonny Felipez
 * @version 1.00 15/08/11
 */
class AppInvierte {
	public static void main(String[] args) {
		String entrada, salida;
		Scanner lee = new Scanner(System.in);
		while (true) {
			System.out.print("Ingrese una cadena: ");
			entrada = lee.nextLine(); // lee una cadena del teclado
			if (entrada.equals("")) // sale si es [Enter]
				break;
			Invierte oInvierte = new Invierte(entrada);
			salida = oInvierte.realizaInversion();
			System.out.println("Invertido: " + salida);
		} // fin while
	} // fin main()
} // fin clase AppInvierte