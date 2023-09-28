class AppDoblementeEnlazada 
{
	public static void main(String[] args) 
	{ 
		ListaDoblementeEnlazada laLista = new ListaDoblementeEnlazada();

		laLista.insertaInicio(22);
		laLista.insertaInicio(44);
		laLista.insertaInicio(66);

		laLista.insertaFinal(11);
		laLista.insertaFinal(33);
		laLista.insertaFinal(55);

		laLista.despliegaAdelante(); 
		laLista.despliegaAtras();

		laLista.eliminaInicio();
		laLista.eliminaUltimo();
		laLista.eliminaClave(11);

		laLista.despliegaAdelante();
		laLista.insertaDespues(22, 77);
		laLista.insertaDespues(33, 88);						
		laLista.despliegaAdelante();
	} 
}