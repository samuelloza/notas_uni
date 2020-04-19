
public class Producto {
	/*
	 * @ requires b > 0;
	 * @ ensures \result == a * b;
	 */

	public static int prod(int a, int b) {
		int prod = 0, j = 1;

		// @ loop_invariant prod == (\sum int p; 1 <= p && p <= j-1; a);
		while (j <= b) {
			j = j + 1;
			prod = prod + a;
		}
		return prod;
	}

	public static void main(String[] args) {
		System.out.println(Producto.prod(5, 3));
	}
}
