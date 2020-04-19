
public class Maximo {
	/*
	 * @ requires true;
	 * @ ensures \result >= x && \result >= y && (\result == x || \result == y);
	 */
	public static int maximo(int x, int y) {
		int z;
		z = (x >= y) ? x: y;
		return z;
	}

	public static void main(String[] args) {
		System.out.println(Maximo.maximo(10, 3));
	}
}
