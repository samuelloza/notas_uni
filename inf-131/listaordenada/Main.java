class Main {
	public static void main(String[] args) {
		ColaPrioridad<String> aux = new ColaPrioridad<String>();
		aux.insert("az");
		aux.insert("aez");
		aux.insert("sam");
		aux.insert("casa");
		aux.insert("a");
		aux.display();
		
		Persona xxx=new Persona();
		Persona xxx2=new Persona();
		ColaPrioridad<Persona> aux3=new ColaPrioridad<Persona>();
		xxx.addPerr("a00");
		xxx2.addPerr("a2");
		aux3.insert22(xxx);
		aux3.insert22(xxx2);
		aux3.display();
		
		

		// ColaPrioridad aux = new ColaPrioridad();
		// aux.insert(10);
		// aux.insert(9);
		// aux.insert(12);
		// aux.insert(0);
		// aux.display();
		// System.out.println(aux.remove());
		// aux.display();

	}
}