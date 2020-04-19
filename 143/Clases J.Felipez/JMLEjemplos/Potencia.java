
public class Potencia {
	/*
	 * @ requires b >= 0;
	 * @ ensures \result == (\product int x; 0 <= x && x < b; a);
	 * @
	 */

	public static int elevado(int a, int b) {
		int x = 0, p = 1;

		// @ loop_invariant p == (\product int j; 0 <= j && j < x; a);
		while (x < b) {
			p = p * a;
			x = x + 1;
		}
		return p;
	}

	public static void main(String[] args) {
		System.out.println(Potencia.elevado(2, 3));
	}
}
