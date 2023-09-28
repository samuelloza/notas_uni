import java.awt.event.*;

/**
*  Clase que maneja la salida de la ventana (JFrame) al presionar, en la esquina superior derecha,
*  Cerrar.
*/

public class WindowQuit extends WindowAdapter 
{ 
	/**
	*	Metodo Constructor.
	*/
		public void windowClosing( WindowEvent e ) { 
				System.exit( 0 ); // exit del programa 
	} 
}
