package practica2;

public class Pila {

	public static void main(String[] args) {
		Bicola a = new Bicola(4);
		a.InsertIzq(12);
		a.InsertIzq(121);
		a.InsertIzq(122);
		a.InsertIzq(123);
		System.out.println(a.size());
		a.Mostrar();

	}

}
