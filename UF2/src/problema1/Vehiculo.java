package problema1;

public class Vehiculo{
	
	//Problema 3
	/*private String Color;
	private int Caballos;
	private String Marca;
	private String Modelo;*/
	
	//Problema 6
	protected String Color;
	protected int Caballos;
	protected String Marca;
	protected String Modelo;
	
	//Problema 1
	public Vehiculo(){
		Color = "";
		Caballos = 0;
		Marca = "";
		Modelo = "";
	}
	//Funciones miembro

	//Constructores
	public Vehiculo(String color, int caballos, String marca, String modelo) {
		this.Color = color;
		this.Caballos = caballos;
		this.Marca = marca;
		this.Modelo = modelo;
	}

	
	//Problema 4
    // Getters and Setters
	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public int getCaballos() {
		return Caballos;
	}

	public void setCaballos(int caballos) {
		Caballos = caballos;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	
	
	
}
