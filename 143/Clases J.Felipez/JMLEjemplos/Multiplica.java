
public class Multiplica {
	/*
	 * @ requires true;
	 * @ ensures \result == b * a ;
	 */

	public static int Producto(int a, int b) {
		return (a * b);
	}

	public static void main(String[] args) {
		System.out.println(Multiplica.Producto(10, 3));
	}
}
