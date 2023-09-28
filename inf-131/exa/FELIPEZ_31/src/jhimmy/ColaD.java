package jhimmy;
public class ColaD extends PilaColaD{
	protected int ini, fin;
	public int getIni() {
		return ini;
	}
	public void setIni(int ini) {
		this.ini = ini;
	}
	public int getFin() {
		return fin;
	}
	public void setFin(int fin) {
		this.fin = fin;
	}
	public ColaD(){
		ini = fin = 0;
	}
}
