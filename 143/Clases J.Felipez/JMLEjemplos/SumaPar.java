
public class SumaPar {
	/*
	 * @ requires n > 0;
	 * @ ensures \result == (n+1)*(n-1);
	 */

	public static int suma(int n) {
		int s = 0, i = 1, k = 2;

		// @ loop_invariant s == (i-2) * i + 2;
		while (i <= n) {
			s = s + k;
			k = k + 2;
			i = i + 1;
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(SumaPar.suma(5));
	}
}
