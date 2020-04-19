
public class Factorial {
	/*
	 * @ requires n >= 0;
	 * @ ensures (\result == (\product int i; 0 < i && i <= n; i)) || (\result == 1 && n == 0);
	 * @
	 */

	public static int fact(int n) {
		int f = 1, i = 0;

		// @ loop_invariant f == (\product int j; 0 < j && j <= i; j);
		while (n > i) {
			i = i + 1;
			f = f * i;
		}
		return f;
	}

	public static void main(String[] args) {
		System.out.println(Factorial.fact(5));
	}
}
