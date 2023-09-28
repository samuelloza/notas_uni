/**
 * Aplicación de una lista de dos extremos primero y último.
 * 
 * @author Jhonny Felipez
 * @version 1.00 31/03/11
 */
class AppPrimeroUltimo {
	public static void main(String[] args) 
	{
		
		//Ejemplo de lista de enteros
		/*ListaPrimeroUltimo <Integer>laLista = new ListaPrimeroUltimo <Integer>();
		
		laLista.insertaPrimero(22); 
		laLista.insertaPrimero(44);
		laLista.insertaPrimero(66);
		
		laLista.insertaUltimo(11); 
		laLista.insertaUltimo(33);
		laLista.insertaUltimo(55);

		laLista.despliegaLista(); 

		laLista.eliminaPrimero(); 
		laLista.eliminaPrimero();
		
		laLista.despliegaLista();*/
		
		/*
		//Ejemplo de lista de cadenas
		ListaPrimeroUltimo <String>laLista = new ListaPrimeroUltimo <String>();
		
		laLista.insertaUltimo("cadena1");
		laLista.insertaUltimo("cadena2");
		laLista.insertaUltimo("cadena3");
		laLista.insertaUltimo("cadena4");
		laLista.despliegaLista();*/
		
		/*
		//Ejemplo de listas de Objetos Edificio
		ListaPrimeroUltimo <Edificio>laLista = new ListaPrimeroUltimo <Edificio>();
		
		Edificio A= new Edificio("Roman",9,"verde");
		Edificio B= new Edificio("Esmeralda",12,"Blanco");
		Edificio C= new Edificio("Alameda",13,"Amarillo");
		Edificio D= new Edificio("Hotel Plaza",9,"plomo");
		laLista.insertaUltimo(A);
		laLista.insertaUltimo(B);
		laLista.insertaUltimo(C);
		laLista.insertaUltimo(D);
		laLista.despliegaLista();*/
		
		
		//Ejemplo de lista de cualquiera
		ListaPrimeroUltimo <Object>laLista = new ListaPrimeroUltimo <Object>();
		
		laLista.insertaUltimo("cadena2");
		laLista.insertaUltimo("cadena3");
		laLista.insertaPrimero(22); 
		laLista.insertaPrimero(44);
		Edificio e1= new Edificio("Alameda",13,"Amarillo");
		Edificio e2= new Edificio("Hotel Plaza",9,"plomo");
		laLista.insertaUltimo(e1);
		laLista.insertaUltimo(e2);
		laLista.despliegaLista();
	}
}