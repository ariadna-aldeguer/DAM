package problema1;

//Problema 5
public class Coche extends Vehiculo{
	int numPuertas;
	int capacidadMaletero;
	
	//Problema 6 
	/*public Coche() {
		this.capacidadMaletero=0;
		this.numPuertas=0;
		this.Color="";
		this.Modelo="";
		this.Marca="";
		this.Caballos=0;

	public Coche(String Color, int Caballos,
			String Marca, String Modelo, 
			int numPuertas, int capacidadMaletero) {
		this.numPuertas = numPuertas;
		this.capacidadMaletero = capacidadMaletero;
		this.Color= Color;
		this.Modelo= Modelo;
		this.Marca= Marca;
		this.Caballos= Caballos;
	}*/
	
	//Problema 7
	
	public Coche() { //Por defecto
		super(); //Llama al constructor por defecto de vechiulo
		this.capacidadMaletero=0;
		this.numPuertas=0;
	}
	public Coche(String Color, int Caballos,
			String Marca, String Modelo, 
			int numPuertas, int capacidadMaletero) {
		super(Color, Caballos, Marca, Modelo);
		this.numPuertas = numPuertas;
		this.capacidadMaletero = capacidadMaletero;
	}
	
}
