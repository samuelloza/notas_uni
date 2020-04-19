/**
 * Metodos relacionados a matrices.
 * 
 * @author Jhonny Felipez
 * 
 */

public class Matriz {

	/*
	 * @ requires matriz != null;
	 * @ requires Posx >= 0 && Posy >= 0;
	 * @ requires Posx < matriz.length && Posy < matriz[0].length;
	 * @ ensures matriz[Posx][Posy] == Dato &&
	 * @ (\forall int I; 0 <=I && I < matriz.length;
	 * @ (\forall int J; 0<=J && J < matriz[0].length;
	 * @ (I!=Posx || J!=Posy) ==> matriz[I][J]==\old(matriz[I][J])
	 * @ ));
	 */
	public static void reemplazaElemento(int matriz[][], int Posx, int Posy,
			int Dato) {
		matriz[Posx][Posy] = Dato;
	}
	
	/*
	 * @ requires matriz != null;
	 * @ ensures (\forall int I; 0 <=I && I < matriz.length;
	 * @ (\forall int J; 0<=J && J < matriz[0].length; matriz[I][J]==\old(matriz[I][J]));
	 * @ ensures (matriz = \old(matriz));
 	 */
	public static void imprimeMatriz(int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++)
				System.out.print(matriz[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

		Matriz.reemplazaElemento(a, 0, 0, 13);
		Matriz.imprimeMatriz(a);
	}
}
