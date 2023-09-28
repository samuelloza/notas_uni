package DEQUE;

public class APP {
	public static void main(String[] args) {

		 deque a = new deque(2);
		 a.insertLeft(10);
		 a.insertLeft(320);
		 a.insertLeft(12);
		 a.insertLeft(122);
		
		 while (!a.isEmpty()) {
		 System.out.println(a.removeRight());
		 }

		deque b = new deque(2);
		b.insertRight(10);
		b.insertRight(320);
		while (!b.isEmpty()) {
			System.out.println(b.removeLeft());
		}

		System.out.println();
		System.out.println();

		// deque b2 = new deque(2);
		// b2.insertLeft(10);
		// b2.insertLeft(320);
		// // insertLeft(12);
		//
		// while (!b2.isEmpty()) {
		// System.out.println(b2.removeRight());
		// }

	}

}
