package jhimmy;
import java.util.Scanner;

public class Auto {

	private String placa;
	Scanner in = new Scanner(System.in);
	
	public Auto() {
		this.placa = "";
	}
	public void leer(){
		System.out.print("ingrese codigo de placa => ");
		this.placa = in.nextLine();
		this.placa = this.placa.trim();
		this.placa = this.placa.toUpperCase();
	}
	public void mostrar(){
		System.out.println("Placa : "+this.placa);
	}
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
