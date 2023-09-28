/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import java.util.Scanner;

/**
 *
 * @author Familia
 */
class AppPila {
	public static void main(String[] args)
        {
		
	
		String entrada, salida;
		Scanner lee = new Scanner(System.in);
		while (true) {
			System.out.print("Ingrese una cadena: ");
			entrada = lee.nextLine(); // lee una cadena del teclado
			if (entrada.equals("")) // sale si es [Enter]
				break;
			if(balanceada(entrada))
			System.out.println("esta balanceado");
                        else 
                            System.out.println("no esta balanceado");
                } // fin while
	} 
        
        
       static public boolean balanceada(String x) 
       {
        
    	Pila pila1 = new Pila (x.length());    
    	String cadena=x;
    	for (int f = 0 ; f < cadena.length() ; f++)
    	{
    	    if (cadena.charAt(f) == '(' || cadena.charAt(f) == '[' || cadena.charAt(f) == '{') {
    	    	pila1.inserta(cadena.charAt(f));
    	    } else {
    	    	if (cadena.charAt(f)==')') {
    	    	    if (pila1.elimina()!='(') {
    	    	        return false;
    	    	    }
    	     	} else {
    	    	    if (cadena.charAt(f)==']') {
    	    	        if (pila1.elimina()!='[') {
    	    	            return false;
    	    	        }
    	    	    } else {
    	    	        if (cadena.charAt(f)=='}') {
    	    	            if (pila1.elimina()!='{') {
    	    	                return false;
    	    	            }
    	    	        }
    	    	    }
    	        }
   	    }   
        }
    	if (pila1.estaVacia()) {
    	    return true;
    	} else {
   	    return false;
    	}
       }
}
        
        // fin main()
 // fin clase AppPila