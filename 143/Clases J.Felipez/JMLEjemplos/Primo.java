
public class Primo {
	/*
	 * @ requires x > 0;
	 * @ ensures (\result == true || \result == false);
	 */

	static boolean es_primo(int x) {
		int i = 2;
		boolean es = true;

		if (x == 1)
			return false;

		// @ loop_invariant x == \old(x);
		while (i <= (int) (Math.sqrt(x))) {
			if (x % i == 0)
				es = false;
			i++;
		}
		return es;
	}

	public static void main(String[] args) {
		System.out.println(es_primo(10));
	}
}
