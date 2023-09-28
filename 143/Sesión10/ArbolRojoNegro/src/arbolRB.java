import javax.swing.*;
import java.awt.*;

/**
 *	Clase que nos permite efectuar las operaciones de eliminacion en un arbol Red-Black.
 *  Para cada caso de eliminacion, se detalla los pasos que sigue el proceso en sí.
 *  Los componentes swing permiten una interfaz mas "amigable" para comprender la eliminacion
 *  de un nodo en el arbol.
 */

public class arbolRB extends JPanel implements colorNodo
{
    protected nodoRB raiz;// todo arbol posee raiz 	
    
    //Nodo auxliares utilizados en el dibijo del arbol Red-Black
    static nodoRB nodox = null;
    static nodoRB nodoy = null;
    static nodoRB nodoz = null;
    static nodoRB nodow = null; 
    
	/**
	 * Constructor  por defecto. Inicializa el arbol Red-Black con raiz nula.
	 *
	 */
	 
	public arbolRB()
	{  
		raiz = null;				
	} 
	 
	/**
	 * Metodo publico que retorna true si el arbol se encuentra vacio y false en caso contrario.
	 * @return boolean - si arbol esta vacio (true). Si arbol no esta vacio (false).
	 */
	 
	public boolean arbolVacio() 
	{
		return ( raiz == null ? true : false );
	}
	
	/** 
	 * Metodo protegido que inserta el nodo z primeramente como en un arbol ABB.
	 * @param nodoRB  nodo que se insertará en el arbol.
	 */
	 
	protected void insertarABB(nodoRB z)
	{
		nodoRB y = null;
		// Creamos un nodo x = raiz, para hacer el recorrido por el arbol para insertar nodo z
		nodoRB x = raiz; 
		while (x != null) 
		{
			y = x;
			// Comparamos si elem de z es menor a elem de x 
			if (z.elem.compareTo(x.elem) < 0) 
				x = x.izq;	// buscar la posicion de insercion en el sub arbol izq
			else			// en caso contrario. elem de z es mayor a elem de x 						 
				x = x.der;  // buscar la posicion de insercion en el sub arbol der						 
		}//fin while
					
		z.padre = y;
		if (y == null) 		// si z no tiene padre, entonces lo asignamos a la raiz
			raiz = z;
		else 
			if (z.elem.compareTo(y.elem) < 0)
			    y.izq = z;	// insertamos el nodo a la izq de y
			else  
				y.der = z;	// insertamos el nodo a la der de y					         
										
	}
	
	/**
	 * Metodo privado que retorna true si elem. ya encuentra en el arbol y false en caso contrario.
	 * @param nodoRB  nodo donde se busca el elemento.
	 * @param Comparable  elemento a buscar en el arbol.	
	 * @return boolean -  si elem. está en el arbol (true). Si elem. no esta en el arbol (false). 	 	 
	 */
	 
	private boolean estaEnArbol(nodoRB a,Comparable elem)
	{
		if (a == null)
			return false;
		else 		
		if (elem.compareTo(a.elem) == 0)
		    return true;
		else 
			return estaEnArbol(a.izq,elem) || estaEnArbol(a.der,elem);				
	}
	
	/** 
	* Metodo publico que inserta un elem en el arbol Red-Black
	* @param Comparable elem - elemento a insertar
	*/
	
	public void insertarRB(Comparable elem)
	{
		if (estaEnArbol(raiz,elem)) // si elem ya se encuenra en el arbol, no se vuelv6 a insertar
		{ 
			JOptionPane.showMessageDialog(null,""+(elem)+" ya se encuentra en el arbol Red-Black.","Proyecto DAA 2004.",
			JOptionPane.PLAIN_MESSAGE);
			return;
		}						
		
		eliminarCentinelas(raiz); // Los nodos centinelas no deben intervenir en la insercion
		
		
		nodoRB x = new nodoRB(elem); //Se crea un nuevo nodo para insertarlo en el arbol		
		insertarABB(x); 						 //Insertamos el nuevo nodo al arbol primeramente como en un arbol ABB
		
		while (x != raiz && x.padre.color == rojo) //mientras el arbol no cumpla con las condiciones de RB-tree
		{
			boolean colorYrojo = false;					// variable booleana que almacena true si y es rojo y false si y es negro
			
			if (x.padre == x.padre.padre.izq) 	// si el padre de x es igual al abuelo de x que apunta al hijo izq.        						 
			{
				 nodoRB y = x.padre.padre.der;		// aplicamos los casos para esta situacion 																
				 if (y != null) 
				 { 
				 		if (y.color == rojo)
						{             
							x.padre.color = negro;      // caso 1: de recoloracion
							y.color = negro;            // caso 1: de recoloracion
							x.padre.padre.color = rojo; // caso 1: de recoloracion
							x = x.padre.padre;          // caso 1: de recoloracion
							colorYrojo = true;          // caso 1: de recoloracion
						 }
					} 
					if ( !colorYrojo)
					{ 
						  if (x == x.padre.der )
							{            
								  x = x.padre;            // caso 2: realizar una rotacion a la izq sobre x
									rotarLeft(x);           // caso 2: realizar una rotacion a la izq sobre x
							}
							x.padre.color = negro;          // caso 3: de realizar una rotacion a la der sobre el abuelo de  x
							x.padre.padre.color = rojo;     // caso 3: de realizar una rotacion a la der sobre el abuelo de  x
							rotarRight(x.padre.padre);		  // caso 3: de realizar una rotacion a la der sobre el abuelo de  x								
						}
			}	
			else
			{ 
				if (x.padre == x.padre.padre.der ) 	// si el padre de x es igual al abuelo de x que apunta al hijo der.        
				{
		       nodoRB y = x.padre.padre.izq;		// aplicamos los casos para esta situacion 																								
				  if (y != null)
					{ 
          	if (y.color == rojo)
						{      
						   x.padre.color = negro;     	// caso 1: de recoloracion
							 y.color = negro;           	// caso 1: de recoloracion
							 x.padre.padre.color = rojo;	// caso 1: de recoloracion
							 x = x.padre.padre;         	// caso 1: de recoloracion
							 colorYrojo = true;         	// caso 1: de recoloracion
						 }		
					} 
					
					if (! colorYrojo)
					{   
						if (x == x.padre.izq)
						{
							x = x.padre;           // caso 2: de realizar una rotacion a la der sobre x
							rotarRight(x);         // caso 2: de realizar una rotacion a la der sobre x
						}
						x.padre.color = negro;     	// caso 3: de realizar una rotacion a la izq sobre el abuelo de  x
						x.padre.padre.color = rojo;	// caso 3: de realizar una rotacion a la izq sobre el abuelo de  x
						rotarLeft(x.padre.padre);	 	// caso 3: de realizar una rotacion a la izq sobre el abuelo de  x											
					}
        }
			}
		}// fin while
				
			raiz.color = negro;		// siempre la raiz del arbol es negra						
			crearCentinela(raiz);
	}

	/** 
	* Metodo privado que realiza una rotacion simple a la izquierda sobre el nodo x
	* @param NodoRB x - Nodo sobre el cual se realiza la rotacion simple a la izquierda.
	*/
	
	private void rotarLeft(nodoRB x)
	{
		nodoRB y = x.der;
		x.der = y.izq;		
		if( y.izq != null )
			y.izq.padre = x;
			y.padre = x.padre;
		if( x.padre == null )
			raiz = y;
		else 
				if( x == x.padre.izq )
				    x.padre.izq = y;
				else
				    x.padre.der = y;
						
			y.izq = x;
			x.padre = y;
	}		
	
	/** 
	* Metodo privado que realiza una rotacion simple a la derecha sobre el nodo x
	* @param NodoRB x - Nodo sobre el cual se realiza la rotacion simple a la derecha.
	*/
	
	private void rotarRight(nodoRB x)
	{
		nodoRB y = x.izq;
		x.izq = y.der;
		if( y.der != null )
			y.der.padre = x;
			y.padre = x.padre;
		if( x.padre == null )
			raiz = y;
		else 
				if( x == x.padre.der )
						x.padre.der = y;
				else
				    x.padre.izq = y;
		y.der = x;
		x.padre = y;
	}		
		
	/**
 	* Metodo privado que retorna el nodo con valor minimo del arbol con raiz x +
	*
	* @param nodoRB 
	* @return nodoRB 
	*/
	
	private nodoRB nodoMin(nodoRB x)
	{
		while (!x.izq.esCentinela)
			x = x.izq;
			return x; //retorna minimo				
	}
	
	/** 
	* Metodo privado que retorna el sucesor del nodo x
	*
	* @param nodoRB - 
	* @return nodoRB - sucesor del nodo x
	*/
	
	private nodoRB Sucesor(nodoRB x)
	{
  	if( !x.der.esCentinela )		
			return nodoMin(x.der);
			nodoRB y = x.padre;
	 while( y != null && x == y.der )
	 {
	 		x = y;
			y = y.padre;
	 }		
	return y;		
	}
	
	/** 
	* Metodo privado que retorna el nodo cuyo dato es elem y si no se encuentra retorna null
	* @param nodoRB - nodo donde se compara
	* @param Comparable - elem es el valor buscado
	* @return boolean - si encuentra el elem retorna el nodo. Si no es encontrado se retorna null 
	*/
	
	private nodoRB buscarNodo(nodoRB x , Comparable elem)
	{
		while( x != null  && elem.compareTo(x.elem) != 0 )
			if (elem.compareTo(x.elem) < 0 )
				x = x.izq;
			else  
			  x = x.der;
		return x;				
	} 
		
	/** 
	* Metodo publico que nos permite eliminar del arbol red-black el dato elem
	* @param Comparable - elem. es elemto a eliminar
	*/
	
	public void eliminarRB(Comparable elem)
	{
		if( arbolVacio() ) // si Arbol esta vacio, se imprime mensaje
		{ 
			JOptionPane.showMessageDialog(this,"Arbol Red-Black vacio.","Proyecto DAA 2004.",JOptionPane.PLAIN_MESSAGE);
			return;
		}		 
		
		nodoRB z = buscarNodo(raiz,elem);

		if( z == null )		// si el dato no se encuentra imprime error 
		{
			JOptionPane.showMessageDialog(this,"El elemento a eliminar no se encuentra en el Arbol Red-Black.",
			"Proyecto DAA 2004.",JOptionPane.OK_OPTION);
			return; 
		}				
		
		nodoRB p = eliminarRB(z); // p es el nodo a eliminar
		p = null;									//eliminamos definitivamente el nodo p 
		
		if( raiz.esCentinela ) // si la raiz es centinela, entonces hay que eliminarla para dejar el arbol vacio
		{
			raiz.padre = null;
			raiz = null;
		}	
    eliminarCentinelas(raiz);
    crearCentinela(raiz);
	}		
	
  /** 
	* Metodo privado que elimina todo nodo cuyo atributo esCentinela es true
	* @param nodoRB - nodo donde se comienza al eliminar centinelas
	*/
	
	private void eliminarCentinelas(nodoRB x)
	{
		if (x == null) 
				return;
		if( x.esCentinela )
		{ 
			if( x.padre.izq.esCentinela )
				x.padre.izq = null;
				if( x.padre.der.esCentinela )
				   x.padre.der = null;
		} 
		else 
		{
			eliminarCentinelas(x.izq);						 
			eliminarCentinelas(x.der);
		}   
	}
	
	/**
 	*	Metodo privado que permite que todas las referencias a null del arbol sean asinadas a nodos centinelas que nos ayudan en la eliminacion	
	* @param nodoRB	
	*/
	
	private void crearCentinela(nodoRB x)
	{   	
		if( x.izq == null ){
			nodoRB centinela = new nodoRB(x);
			x.izq = centinela;
		}
		else
		{
			crearCentinela(x.izq);				
		}				
		if( x.der == null )
		{
			nodoRB centinela = new nodoRB(x);
			x.der = centinela;							
		}
		else
		{				 
			crearCentinela(x.der);
		}
	}		 
	
	
	/**
 	*	Metodo privado que elimina el nodo z del arbol red-black
	* @param nodoRB
	* @retun nodoRB
	*/
	
	private nodoRB eliminarRB(nodoRB z)
	{
		nodoz = z;  
		nodoRB y; nodoRB x; 				 
		String casoNodoy =""; 
		String casoNodox ="";
		
		if (z.izq.esCentinela || z.der.esCentinela) // si algun hijo de z es centinela
		{
			y = z;
			casoNodoy = "Como el nodo Z posee uno o ningun hijo, entonces, el nodo Y es igual al nodo Z"; 
		}
		else
		{
		  y = Sucesor(z);
			casoNodoy = "Como el nodoZ posee ambos hijos, entonces, el nodo Y queda representado como \nel sucesor de Z";
		}    
		
		nodoy = y;
		
	  if( !y.izq.esCentinela ) //si hio izq. de y es centinela
		{				 
			x = y.izq;
			casoNodox = "Como el hijo izq. del nodo Y no es centinela, entonces, este sera el nodo Y";
		}
		else
		{
		  x = y.der;
			casoNodox ="Como el hijo izq. del nodo Y es centinela, entonces, el nodo X es el hijo der. de Y";
		}	   
    
		nodox=x;
		repaint(); // Es repintado el dibujo del arbol
		JOptionPane.showMessageDialog(this,"El nodo Z representa al elemento que se desea eliminar (Z = "+ z.elem +
                 ")\n"+casoNodoy+"(Y = "+ y.elem+ ")\n "+casoNodox+"(X = arbitrario).","Eliminacion",JOptionPane.OK_OPTION);
									
		String mensaje="El padre de X es ahora el nodo Z";
		repaint(); // Es repintado el dibujo del arbol
		x.padre = y.padre;	
				 				
		if (y.padre == null) // si padre de y es nulo
		{
			raiz = x;
			mensaje+= "\nComo el nodo Y no tiene padre, entonces, el nodo X es ahora la raiz del arbol";
		}
		else
		{ 
			if( y == y.padre.izq ) 
			{
				y.padre.izq = x;
				mensaje += "\nAhora el nodo X pasa a ser el hijo izq. de Z";
			} 
			else
			{
				mensaje += "\n Ahora el nodo X es el hijo der. de Z";
				y.padre.der = x;				 
			}
		}     
		
		nodox = x;
		if( y != z )
		{
			z.elem = y.elem;
			mensaje += "\nComo el nodo Z es igual al nodo Y, ahora la llave del nodo Z\n es igual a la llave del nodo Y";
			repaint(); // Es repintado el dibujo del arbol
		}
		if( y.color == negro )
		{
			mensaje += "\nEl color del nodo Y es negro, entonces. se llama al metodo eliminarRB_Fixup(x).\n"+
					   "eliminarRB_Fixup(x) : metodo que se encarga de devolver las propiedades red-black al arbol";
					   JOptionPane.showMessageDialog(this,mensaje,"Eliminacion",JOptionPane.OK_OPTION);
		  repaint();  // Es repintado el dibujo del arbol
		  eliminarRB_Fixup(x);				 
		}
		else
		{
    		JOptionPane.showMessageDialog(this,mensaje,"Eliminacion",JOptionPane.OK_OPTION);
			repaint(); // Es repintado el dibujo del arbol
		}   
		
		// se asigna null a las variables auxiliares
		nodox = null; 
		nodoy = null;
		nodoz = null;
		nodow = null; 
		return y;// retorno el nodo ha eliminar		 
	}
	
	/** 
	* Metodo privado que reestablece las propiedades del RedBlack-Tree al arbol, aplicando los distintos Casos de eliminacion
	*@param nodoRB
	*/
	
	private void eliminarRB_Fixup(nodoRB x)
	{
		nodoz = nodoy = null;
		while( x != raiz && x.color == negro ) // mientras el arbol no sea red black				    
		{
			nodox=x;
			if (x == x.padre.izq )     	// Si x esta a la izq. de su padre, entonces aplicamos 4 casos para Hijo izquierdo					    
			{
				nodoRB w = x.padre.der;
				nodow = w;
				repaint();
				JOptionPane.showMessageDialog(this,"Como el nodo X representa al hijo izq, entonces, el nodo W \nrepresenta al hijo der.","Eliminacion",JOptionPane.OK_OPTION);
				
				/** Caso 1 **/
				if (w.color == rojo)
				{
					JOptionPane.showMessageDialog(this,"Como en nodo W es rojo, aplicamos Caso 1 :","Caso 1.",JOptionPane.OK_OPTION);
					repaint();
					JOptionPane.showMessageDialog(this,"1) El color del nodo W cambia a negro.","Caso 1.",JOptionPane.OK_OPTION);
					w.color = negro;      // caso 1									
					repaint();
					JOptionPane.showMessageDialog(this,"2) El color del padre del nodo X cambia a rojo.","Caso 1.",JOptionPane.OK_OPTION);
					repaint();									
					x.padre.color = rojo; // caso 1
					JOptionPane.showMessageDialog(this,"3) Se realiza una rotacion a la izquierda sobre el padre del nodo X.","Caso 1.",JOptionPane.OK_OPTION);
					rotarLeft(x.padre);   // caso 1
					repaint();
					JOptionPane.showMessageDialog(this,"4) El nodo W pasa a ser el hijo der.del padre del nodo x.","Caso 1.",JOptionPane.OK_OPTION);
					w = x.padre.der;      // caso 1
					repaint();
				}
				
				/** Caso 2 **/
				
				if (w.izq.color == negro && w.der.color == negro )
				{
					JOptionPane.showMessageDialog(this,"Como el color de los hijos del nodo W son negro aplicamos Caso 2.","Caso 2.",JOptionPane.OK_OPTION);
					JOptionPane.showMessageDialog(this,"1) El color del nodo W cambia a rojo.","Caso 2.",JOptionPane.OK_OPTION);
					w.color = rojo;       // caso 2
					repaint();
					JOptionPane.showMessageDialog(this,"2) El nodo X pasa a ser su mismo padre.","Caso 2.",JOptionPane.OK_OPTION);
					x = x.padre;          // caso 2
					repaint();
				}
				else
				{
					/** Caso 3 **/			
					
					if( w.der.color == negro )
					{
						JOptionPane.showMessageDialog(this,"Como el color del hijo der. de W es negro aplicamos Caso 3","Caso 3.",JOptionPane.OK_OPTION);
						JOptionPane.showMessageDialog(this,"1) El color del hijo izq. de W cambia a negro.","Caso 3.",JOptionPane.OK_OPTION);
						w.izq.color = negro; // caso 3
						repaint();
						JOptionPane.showMessageDialog(this,"2) El color de W cambia a rojo.","Caso 3.",JOptionPane.OK_OPTION);
						w.color = rojo;      // caso 3
						repaint();
						JOptionPane.showMessageDialog(this,"3) Se realiza una rotacion a la derecha sobre el nodo W.","Caso 3.",JOptionPane.OK_OPTION);
						rotarRight(w);       // caso 3
						repaint();
						JOptionPane.showMessageDialog(this,"4) El nodo W es ahora el hermano derecho del nodo X.","Caso 3.",JOptionPane.OK_OPTION);	
						w = x.padre.der;     // caso 3
						nodow = w;
						repaint();									
					}
					/** Caso 4 **/			
						JOptionPane.showMessageDialog(this,"Como el nodo W es negro y su hijo der. es rojo aplicamos Caso 4.","Caso 4",JOptionPane.OK_OPTION);	
						JOptionPane.showMessageDialog(this,"1) El color del nodo W es ahora el color del padre del nodo X.","Caso 4.",JOptionPane.OK_OPTION);											
						w.color = x.padre.color; // caso 4
						repaint();
						JOptionPane.showMessageDialog(this,"2) El color del padre del nodo X es ahora negro.","Caso 4.",JOptionPane.OK_OPTION);	
						x.padre.color = negro;   // caso 4
						repaint();
						JOptionPane.showMessageDialog(this,"3) El color del hijo der. de W cambia a negro.","Caso 4.",JOptionPane.OK_OPTION);	
						w.der.color = negro;     // caso 4
						repaint();
						JOptionPane.showMessageDialog(this,"4) Se realiza una rotacion a izquierda al padre del nodo X.","Caso 4.",JOptionPane.OK_OPTION);	
						rotarLeft(x.padre);      // caso 4
						repaint();
						JOptionPane.showMessageDialog(this,"5) La raiz del arbol es rotulado como X.","Caso 4",JOptionPane.OK_OPTION);	
						x = raiz;                // caso 4
						nodox = x;
						repaint();
						JOptionPane.showMessageDialog(this,"6) Se reestrablecieron las propiedades de arbol red-black. Fin de eliminarRB_Fixup()","Caso 4",JOptionPane.OK_OPTION);
																			
				}	
					    				
				} 
				else
				{
					if( x == x.padre.der )   // Si x esta a la der. de su padre, entonces aplicamos 4 casos para Hijo derecho
					{
						nodoRB w = x.padre.izq;
						nodow = w; 								
						repaint();
						JOptionPane.showMessageDialog(this,"Como el nodo X representa al hijo der, entonces, el nodo W \nrepresenta al hijo izq.","Eliminacion",JOptionPane.OK_OPTION);
						
						/** Caso 1 **/
						
						if ( w.color == rojo )
						{
							JOptionPane.showMessageDialog(this,"Como en nodo W es rojo, aplicamos Caso 1 :","Caso 1.",JOptionPane.OK_OPTION);
							repaint();
							JOptionPane.showMessageDialog(this,"1) El color del nodo W cambia a negro.","Caso 1.",JOptionPane.OK_OPTION);
							w.color = negro;     // caso 1 
							repaint();
							JOptionPane.showMessageDialog(this,"2) El color del padre del nodo X cambia a rojo.","Caso 1.",JOptionPane.OK_OPTION);								        	
							x.padre.color = rojo;// caso 1
							repaint();		
							JOptionPane.showMessageDialog(this,"3) Se realiza una rotacion a la derecha sobre el padre del nodo X.","Caso 1.",JOptionPane.OK_OPTION);
							rotarRight(x.padre); // caso 1
							repaint();
							JOptionPane.showMessageDialog(this,"4) El nodo W pasa a ser el hijo izq.del padre del nodo x.","Caso 1.",JOptionPane.OK_OPTION);
							w = x.padre.izq;     // caso 1									
							repaint();										    										        
						}
						
						/** Caso 2 **/
						
						if( w.der.color == negro && w.izq.color == negro )
						{    	
							JOptionPane.showMessageDialog(this,"Como el color de los hijos del nodo W son negros aplicamos Caso 2.","Caso 2.",JOptionPane.OK_OPTION);
							JOptionPane.showMessageDialog(this,"1) El color del nodo W cambia a rojo.","Caso 2.",JOptionPane.OK_OPTION);
							w.color = rojo;      // caso 2
							repaint();
							JOptionPane.showMessageDialog(this,"2) El nodo X pasa a ser su mismo padre.","Caso 2.",JOptionPane.OK_OPTION);
							x = x.padre;         // caso 2
							repaint();										    	    									    
						}
						else
						{
						
						/** Caso 3 **/
						
						if( w.izq.color == negro )
						{
							JOptionPane.showMessageDialog(this,"Como el color del hijo izq. de W es negro aplicamos Caso 3","Caso 3.",JOptionPane.OK_OPTION);	
							JOptionPane.showMessageDialog(this,"1) El color del hijo der. de W cambia a negro.","Caso 3.",JOptionPane.OK_OPTION);  
							w.der.color = negro; // caso 3
							repaint();
							JOptionPane.showMessageDialog(this,"2) El color de W cambia a rojo.","Caso 3.",JOptionPane.OK_OPTION);
							w.color = rojo;      // caso 3
							repaint();												    
							JOptionPane.showMessageDialog(this,"3) Se realiza una rotacion a la izquierda sobre el nodo W.","Caso 3.",JOptionPane.OK_OPTION);
							rotarLeft(w);        // caso 3
							repaint();
							JOptionPane.showMessageDialog(this,"4) El nodo W es ahora el hermano izquierdo del nodo X.","Caso 3.",JOptionPane.OK_OPTION);	
							w = x.padre.izq;     // caso 3
							nodow = w;												    
							repaint();												    
						}									   						    
						
						/** Caso 4 **/
						
							JOptionPane.showMessageDialog(this,"Como el nodo W es negro y su hijo izq. es rojo aplicamos Caso 4.","Caso 4",JOptionPane.OK_OPTION);	
							JOptionPane.showMessageDialog(this,"1) El color del nodo W es ahora el color del padre del nodo X.","Caso 4.",JOptionPane.OK_OPTION);																				    
							w.color = x.padre.color; // caso 4
							repaint();
							JOptionPane.showMessageDialog(this,"2) El color del padre del nodo X es ahora negro.","Caso 4.",JOptionPane.OK_OPTION);	
							x.padre.color = negro;   // caso 4
							repaint();
							JOptionPane.showMessageDialog(this,"3) El color del hijo izq. de W cambia a negro.","Caso 4.",JOptionPane.OK_OPTION);	
							w.izq.color = negro;     // caso 4
							repaint();
							JOptionPane.showMessageDialog(this,"4) Se realiza una rotacion derecha al padre del nodo X.","Caso 4.",JOptionPane.OK_OPTION);	
							rotarRight(x.padre);     // caso 4
							repaint();
							JOptionPane.showMessageDialog(this,"5) La raiz del arbol es rotulado como X.","Caso 4",JOptionPane.OK_OPTION);	
							x = raiz;                // caso 4
							nodox=x;
							repaint(); 																
							JOptionPane.showMessageDialog(this,"6) Se reestrablecieron las propiedades de arbol red-black. Fin de eliminarRB_Fixup()","Caso 4",JOptionPane.OK_OPTION);										 		 
				  		} 
						}	
					}				      
		   }// fin while
				
			JOptionPane.showMessageDialog(this,"Finalmente como el nodo X siempre es negro (Termina eliminarRB_Fixup()).","Eliminacion",JOptionPane.OK_OPTION);										 		    
		    x.color = negro;// el nodo x debe ser negro
		    nodox=x;		    
		    repaint();  
	}//fin eliminarRB_Fixup()
	
	/**
	* Metodo publico que imprime un mensaje que indica que se ha destruido el arbol.
	*
	*/

  public void destruirRB()
  {
  	destruirRB(raiz);
    raiz = null;
    repaint();
    JOptionPane.showMessageDialog(this,"El arbol Red-Black ha sido destruido",
    "Trabajo DAA 2004",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("chile.gif"));
  }
  
	/**
	* Metodo privado que detriuye el arbol
	*@param nodoRB - le es asigana la raiz del arbol
	*/
	
  private void destruirRB(nodoRB x)
  {
  	if( x != null ){
    	destruirRB(x.izq);
    	destruirRB(x.der);
    	x = null;
    }
  } 	

	/**
	*	Metodo publico que actualiza el dibujo del arbol
 	* @param Graphics
	*/
	
	public void paintChildren(Graphics g)
	{
		g.setFont(new Font("small",5,10) );	
		dibujo(g,raiz, 130, 3, 7, 0);		
	}	
		
	/**
  * Metodo privado que dibuja el arbol Red-Black por pantalla.
	* @param Graphics g - contiene metodos graficos necesarios para dibujar
	* @param nodoRB cabeza - desde la raiz se dibuja el arbol
	* @param int a - parametro para posicionar nodo
	* @param int b - parametro para posicionar nodo
	* @param int c - parametro para posicionar nodo
	* @param int d - parametro para posicionar nodo
	*/
 
  private void dibujo(Graphics g,nodoRB cabeza, int a, int b, int c, int d)
  {

   if ( cabeza != null ) { 	   	// if el arboles distinto de null se dibuja 
		 	if( cabeza.color == 0 ) 
		     g.setColor(Color.black);								
		 	else
			   g.setColor(Color.red);
					
		 	if (!cabeza.esCentinela) {
					g.fillOval( 360 + a , 35 + b , 28 , 28 ); //dibuja nodo		 			 	
		 			g.setColor(Color.white);	   							//color de la informacion del nodo						
						
					/* Ubica la informacion en el centro del nodo*/	
	   	  	String nod = ""+cabeza.elem;  
	   		  int large = nod.length();
	     		if (large==1)
	   	  		g.drawString(nod,372 + a, 53 + b); 
	     		else if(large==2)
	   					  g.drawString(nod,367 + a, 53 + b); 
	   		  		else 	if(large==3)
	   							   	g.drawString(nod,364 + a, 53 + b); 
	    							else 
	   								  g.drawString(nod,360 + a, 53 + b);
		 			
	     	  	
		 	g.setColor(Color.black); //color de las ramas del arbol
		  } 
			else /* se dibujan los centinelas*/
			{				
		  	g.fillRect( 365 + a , 35 + b , 20 , 20 ); 		  	
	     	g.setColor(Color.white);
	     	g.drawString("null", 365 + a, 46 + b); 
		 		g.setColor(Color.black);		  	
	    }
			
		 	if ( d == 1 ) // hijo izquierdo
		     g.drawLine(360 + a + (int)Math.pow( 2, c+1 ), b - 20 , 378 + a,36 + b);
      else if(d==2) // hijo derecho  
	         g.drawLine(387 + a - (int)Math.pow( 2, c+1 ), b - 22, 365 + a,36 + b);    
	     
	     
	     g.setColor(Color.black);    	     
	     
		 /* se etiquetan los nodos X,Y,Z,W*/
		 if(nodox != null)		
	     	if (nodox.elem.compareTo(cabeza.elem)==0 && nodox == cabeza) // Se compara elemento y direccion en memoria
	     		g.drawString("X", 390 + a, 48 + b); 	    
	   if(nodoy != null)		
	     	if (nodoy.elem.compareTo(cabeza.elem)==0  && nodoy == cabeza) // Se compara elemento y direccion en memoria
	     		g.drawString("Y", 390 + a, 48 + b);
		 if (nodow != null)			     		
		 		if (nodow.elem.compareTo(cabeza.elem)==0 && nodow == cabeza) // Se compara elemento y direccion en memoria
	     		g.drawString("W", 390 + a, 56 + b);	     	
		 if(nodoz != null)			     		
	     	if (nodoz.elem.compareTo(cabeza.elem)==0 && nodoz == cabeza) // Se compara elemento y direccion en memoria
	     		g.drawString("Z", 390 + a, 60 + b);	
		 
		dibujo(g,cabeza.izq,a - (int)Math.pow(2,c) - (int)Math.pow(2,d-6), b + 75, c - 1 , 1 );
		dibujo(g,cabeza.der,a + (int)Math.pow(2,c) + (int)Math.pow(2,d-6), b + 75, c - 1 , 2 );
	}
	
	}// fin dibujo	

}// fin arbolRB

/** 
 * Interface que nos permite manejar las ctes. de color
 */
interface colorNodo {
    public static byte negro = 0;
	public static byte rojo  = 1;
}




