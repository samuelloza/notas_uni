
public class SumaNatural {
	/*
	 * @ requires n > 0;
	 * @ ensures \result == n * (n + 1)/2;
	 */

	public static int suma(int n) {
		int s = 0, i = 1;

		// @ loop_invariant s == i * (i-1)/2;
		while (i <= n) {
			s = s + i;
			i = i + 1;
		}
		return s;
	}

	/*
	 * @ requires n > 0;
	 * @ ensures \result == n * (n + 1)/2;
	 */

	public static int suma1(int n) {
		int s = 0, i = 0;

		// @ loop_invariant s == i * (i+1)/2;
		while (i < n) {
			i++;
			s = s + i;
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(SumaNatural.suma(5));
		System.out.println(SumaNatural.suma1(5));
	}
}
