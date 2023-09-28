import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
*	Clase que nos permite desplegar por pantalla una ayuda.
*/

/**
* Metodo Constructor
*/

public class ayuda extends JFrame
{
    JTextArea jtexto;
		JScrollPane paneScrol;
		public ayuda(){  
				super("Ayuda Programa");
				String texto = "AYUDA :\n     Este proyecto Swing programado con JAVA trata sobre la eliminacion en arboles Red-Black," +
				             		  "\nA continuacion se detalla los nodos que se utilizan para efectuar el proceso de borrado, asi como"+
									  "\ntambien, en cada uno de los casos de eliminacion."+
									  "\n\n     Los nodos utilizados por este programa se etiquetan de la siguiente manera :"+
									  "\n\n     *     Z = Nodo cuyo elemento es el que deseamos eliminar del árbol."+
                     				  "\n     *     Y = Se representa como Y = Z  en caso de que Z tuviera uno o ningún hijos. Si Z tuviera \n" +
                     				  "                 ambos hijos Y queda representado como el nodo cuyo elemento sucesor de Z."+   
                     				  "\n     *     X = Si el hijo izquierdo de Y no es nodo centinela, entonces X = Y->hijoIzq. \n"+
                     				  "                 En caso contrario, es decir, el hijo izquierdo de Y es nodo centinela, entonces X = Y->hijoDer."+
                     				  "\n     *     W = Este Nodo se representa en caso de que el método eliminarRB_Fixup(x) sea llamado. Ya sea "+
                     				  "\n               x es hijo derecho o izquierdo.En ambos escenarios W es representado como el hermano del nodo X."+
                     				  "\n\n	  Nota : Un nodo centinela es aquel que se reemplaza en el arbol por aquellas referencias a null.";	      
		
		  jtexto = new JTextArea(5,10);
	      jtexto.setBackground(Color.CYAN);
		  jtexto.setMargin(new Insets(10,10,10,10));
	      jtexto.setText(texto);
	      jtexto.setEditable(false);
	      paneScrol = new JScrollPane(jtexto);  
	      getContentPane().add(paneScrol);
	      setSize(700,350);
	      setVisible(false);
	      setLocation(380,50);   
	      this.setResizable(false);	      
		}
											
}

