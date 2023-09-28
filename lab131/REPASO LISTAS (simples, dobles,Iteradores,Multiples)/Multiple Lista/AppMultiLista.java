/**
 * Aplicación de una Lista Multiple
 *
 * @author Jhonny Felipez
 * @version 1.00 09/05/2011
 */
public class AppMultiLista 
{  
	public static void main(String[] args) 
	{
		MultiLista Mlista = new MultiLista(); // nueva lista multiple

		ListaPrimeroUltimo lista_pers= new ListaPrimeroUltimo();
		lista_pers.insertaUltimo("jorge");
		lista_pers.insertaUltimo("carla");
		lista_pers.insertaUltimo("ana");

		ListaPrimeroUltimo lista_pers2= new ListaPrimeroUltimo();
		lista_pers2.insertaUltimo("ramon");
		lista_pers2.insertaUltimo("alberto");
		lista_pers2.insertaUltimo("sofia");

		ListaPrimeroUltimo lista_pers3= new ListaPrimeroUltimo();
		lista_pers3.insertaUltimo("alejandra");
		lista_pers3.insertaUltimo("carlos");
		lista_pers3.insertaUltimo("pepe");

		Mlista.insertaUltimo("La Paz",lista_pers);
		Mlista.insertaUltimo("Oruro",lista_pers2);
		Mlista.insertaUltimo("Cbba",lista_pers3);
		
		Mlista.mostrar();

		System.out.println("\nmuestra la sublista de la ciudad de ORURO");
		Nodo_L actual = Mlista.consultaNodo("Oruro");
		if (actual != null) {
			actual.despliegaNodo(); // imprime dato
			Mlista.despliegaSubLista(actual);
		} 
	}
}