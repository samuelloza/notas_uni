public class Edificio 
{
	public String nombre;
	public int nroPisos;
	public String color;
	
	public Edificio(String nom,int np,String col)
	{
		nombre=nom;
		nroPisos=np;
		color=col;
	}
	
	public void mostrar()
	{
		System.out.println("\t"+nombre+"\t"+nroPisos+"\t"+color);
	}
}
