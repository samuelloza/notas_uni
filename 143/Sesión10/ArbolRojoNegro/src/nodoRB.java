/** 
* Clase para crear un nuevo nodo del arbol red black. Posee dos contructores. Uno para un cualquiera
* del arbol. Y otro para crear nodos centinelas.
*/	
public class nodoRB
{ 
    protected nodoRB izq;
	protected nodoRB der;
	protected nodoRB padre;
	public Comparable elem;
	protected byte color;// 0 : negro y 1 : rojo 
	protected boolean esCentinela;

	/**
	* Constructor	
	* @param Comparable - elem es el elemto a insertar
	*/
	public nodoRB(Comparable elem)
	{ 
		    this.elem = elem; 
			izq = null; 
			der = null;
			padre = null; 
			color = 1;//cada nodo que se cree sera inicialmente rojo				
			esCentinela = false;
	}
	/**
	* Constructor	de nodo centinela
	* @param nodoRB 
	*/
	public nodoRB(nodoRB nodo)
	{
		    elem = new Integer(0); 
			izq = der = null;
			padre = nodo;
			color = 0;// negro
			esCentinela = true;
	}
}

