
/**
 * Metodos relacionados a vectores.
 * 
 * @author Jhonny Felipez 
 * 
 */
public class Vector {
	/*
	 * @ requires a != null;
	 * @ ensures \result == (\max int i; 0 <= i && i < a.length; a[i]);
	 * @ ensures (\forall int i; 0 <= i && i< a.length; a[i] == \old(a[i]));
	 * @ ensures (\old (a) == a);
	 */
	static int maximo(int[] a) {
		int max = a[0];
		// @ loop_invariant 1 <=i && i < a.length;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}
	
	/*
	 * @ requires a != null;
	 * @ ensures \result == (\min int i; 0 <= i && i < a.length; a[i]);
	 * @ ensures (\forall int i; 0 <= i && i< a.length; a[i] == \old(a[i]));
	 * @ ensures (\old (a) == a);
	 */
	static int minimo(int[] a) {
		int min = a[0];
		// @ loop_invariant 1 <=i && i < a.length;
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min)
				min = a[i];
		}
		return min;
	}
	
	/*
	 * @ requires a != null;
	 * @ ensures \result == (\exists int i; 0 <= i && i < a.length; a[i] == x)
	 * @ && a == \old(a)
	 * @ && (\forall int i; 0 <= i && i< a.length; a[i] == \old(a[i]));
	 */
	static boolean busca(int[] a, int x) {
		boolean esta = false;
		// @ loop_invariant i < a.length && esta = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x)
				esta = true;
		}
		return esta;
	}
	
	/*
	 * @ requires a != null;
	 * @ ensures \result == (\sum int i; 0 <= i && i < a.length; a[i])
	 * @ && a == \old(a)
	 * @ && (\forall int i; 0 <= i && i< a.length; a[i] == \old(a[i]));
	 */
	static int suma(int[] a) {
		int suma = 0;
		// @ loop_invariant suma == (\sum int j; 0 <=j && j < i; a[j]);
		for (int i = 0; i < a.length; i++) 
			suma += a[i];
		return suma;
	}
	
	/*
	 * @ requires a != null;
	 * @ ensures \result == (\num_of int i; 0 <= i && i < a.length; a[i]%3 == 0)
	 * @ && a == \old(a)
	 * @ && (\forall int i; 0 <= i && i< a.length; a[i] == \old(a[i]));
	 */
	static int multiplo3(int[] a) {
		int cuantos = 0;
		// @ loop_invariant cuantos == (\num_of int j; 0 <=j && j < i; a[j]%3 == 0);
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 3 == 0)
				cuantos ++;
		}
		return cuantos;
	}
	
	/*
	 * @ requires n > 0;
	 * @ ensures (\forall int k; 0 <= k && k < n; \old(E[k]) == x ==> E[k] = y
	 * && \old(E[k]) != x ==> E[k] = \old(E[k]));
	 */
	public static void sustituyeDato(int[] E, int n, int x, int y) {
		// @ loop_invariant 0 <= j && j <= i && \old(E[j]) == x ==> E[j] = y;
		for (int i = 0; i < n; i++) {
			if (E[i] == x)
				E[i] = y;
		}
	}

	public static void imprime(int[] v) {
		for (int i = 0; i < v.length; i++)
			System.out.println(v[i]);
	}

	public static void main(String[] args) {
		int[] a = { 6, 2, 5 };
		System.out.println("Maximo = " + maximo(a));
		System.out.println("Minimo = " + minimo(a));
		if (Vector.busca(a, 2) == true)
			System.out.println("Existe");
		System.out.println(suma(a));
		System.out.println(Vector.multiplo3(a));
		sustituyeDato(a, a.length, 2, 3);
		imprime(a);
	}
}
