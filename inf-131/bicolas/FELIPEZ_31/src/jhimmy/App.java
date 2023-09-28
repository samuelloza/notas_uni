package jhimmy;

import java.util.Scanner;

public class App {
	
	public static void sacar_auto(ColaCircularDobleA p, String placa){
		placa = placa.trim();
		placa = placa.toUpperCase();
		Auto au;
		for (int i = 1; i <= p.nroElems(); i++) {
			au = p.eliminar_derecha();
			if (!(au.getPlaca().equals(placa))) {
				p.adicionar_izquierda(au);
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("----------- Bienvenido al Parqueo -------------");
		System.out.println();
		System.out.println("Usted Puede Parquear Maximo 20 Autos");
		System.out.println("Para Registrar Su Auto Solo Ingrese La Placa");
		System.out.println();
		ColaCircularDobleA cca = new ColaCircularDobleA();
		cca.leer(20);
		cca.mostrar();
		System.out.print("Introduzca Placa Del Auto A Sacar => ");
		String cad = in.nextLine();
		sacar_auto(cca, cad);
		cca.mostrar();
		// TODO Auto-generated method stub

	}

}
