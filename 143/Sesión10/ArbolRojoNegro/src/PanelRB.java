
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder; 
 
/**
* Clase que permite la interfaz para el manejo de las operaciones insertar y "Eliminar" en un Arbol
* Red - Black.
* @author joel hugo salinas
* fecha 15/6/2011
*/


public class PanelRB extends JFrame implements ActionListener 
{
	// Componentes swing a utilizar
	JButton insertar; 
	JButton eliminar;
	JButton destruirRB;
	JButton mostrarAyuda;
	JButton about;
	JTextField text;
	static arbolRB a;
		
	ayuda ayudaProg;
	JScrollPane paneScrol;  

	/**
	*  Metodo Constructor.
	*/		
	public PanelRB()
	{
		    super("Operaciones en Arboles Red-Black - ( DAA - I Semestre 2004)");
			a = new arbolRB();
			paneScrol = new JScrollPane(a);  
			JPanel panel2 = new JPanel();				
			mostrarAyuda = new JButton("Ayuda");
			insertar = new JButton("Insertar");
			eliminar = new JButton("Eliminar");
			destruirRB = new JButton("Destruir RB");				
			about = new JButton("Acerca de..");				
			destruirRB.setEnabled(false);
			text = new JTextField("",10);

			ayudaProg = new ayuda();
			panel2.add(about);
			panel2.add(mostrarAyuda);
			panel2.add(insertar);
			panel2.add(eliminar);
			panel2.add(destruirRB);
			panel2.add(text);

			about.addActionListener(this);
			mostrarAyuda.addActionListener(this);
			insertar.addActionListener(this);
			eliminar.addActionListener(this);
			destruirRB.addActionListener(this);
			panel2.setBorder(new TitledBorder("Eliga una opcion para el Arbol ROJO-NEGRO"));
			a.setBorder(new TitledBorder("ARBOL ROJO-NEGRO...."));
			// se agregan componentes al JFrame
			this.getContentPane().setLayout(new BorderLayout());
			this.getContentPane().add(paneScrol,BorderLayout.CENTER);			  			  
			this.getContentPane().add(panel2,BorderLayout.SOUTH);		 
			this.pack();

			// Para la salida de programa al presionar Cerrar . 

			addWindowListener(new WindowQuit() );
			  		
			//Para obtener el tamaño de la pantalla(screen)
      		Toolkit tk = Toolkit.getDefaultToolkit();
      		Dimension d = tk.getScreenSize();

			//	Y damos tamaño al JFrame
			setSize(d.width,d.height);				
			setResizable(false);			  			      		 			  
	}		
	
	/**
	* Metodo que maneja los distintos eventos, al pulsar un boton, en el objeto.
	*/
	public void actionPerformed(ActionEvent evento)
	{
		    Object o = evento.getSource();						
			if( o == mostrarAyuda )
			    ayudaProg.setVisible(true);
			else if( o == about )
			    JOptionPane.showMessageDialog(this,"Programa Proyecto Arboles Rojo-Negro\n "+
				"\nTema: Adicion y Eliminacion en Arboles Rojo-Negro"+"\nIntegrantes:"+"\n     Joel Salinas"+"\n     Sergio Ticona"+"\n     Yecid Yahuita"+"\n     Juan Pablo Yañiquez","Acerca del Programa...",
				JOptionPane.OK_OPTION,new ImageIcon("arbol.gif"));
			else
			{ 
			    if( o == destruirRB )			
				      a.destruirRB();								
			    else
				 {  

				     try 
					  {    
					     int num = Integer.parseInt(text.getText());
				         String s = Integer.toString(num);
				          Integer elem = new Integer(num);
					       if( o == insertar )
						   { 						
						       text.setText(s);						       					
						       a.insertarRB(elem);
						       text.setText("");	
							   repaint();
							}
							else
							{
								if( o == eliminar ){
						           a.eliminarRB(elem);
						           text.setText(""); 							 															     
								       repaint();																
								    //a.mostrarInOrden();								

						       }
				       }
				     }
					 // excepcion para estar seguros de que que se ingresa es un numero entero
				     catch (Exception e)
					{
						   JOptionPane.showMessageDialog(this,"Debe ingresar valores enteros","Error en el ingreso de datos",
						   JOptionPane.OK_OPTION,new ImageIcon("chile.gif"));			
					}
           }
					}	
           if( !a.arbolVacio() )
			   {
           	          destruirRB.setEnabled(true);
              text.setText("");
             }
           else{
              destruirRB.setEnabled(false);   
              text.setText("");}
		}
}
