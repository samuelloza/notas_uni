
public class AppListaEnlazada {

	 public static void main(String[] args) {
         ListaEnlazada laLista = new ListaEnlazada(); // crea nueva lista

         laLista.insertaPrimero(22, "Maria"); // inserta cuatro nodos
         laLista.insertaPrimero(44, "Jose");
         laLista.insertaPrimero(66, "Ana");
         laLista.insertaPrimero(88, "Juan");

         laLista.despliegaLista(); // despliega la lista

         while (!laLista.estaVacia()) { // hasta que est vaca,
                 Nodo temp = laLista.eliminaPrimero(); // elimina nodo
                 System.out.print("Eliminado "); // despliega ste
                 temp.despliegaNodo();
                 System.out.println("");
         }
         laLista.despliegaLista(); // despliega la lista
         laLista.insertaPrimero(10, "jorge");
         laLista.insertadespues(10,20, "luis");
         laLista.insertadespues(20,45, "Karen");
         laLista.despliegaLista();
 } // fin main()
}
