package ejercicio5;

import java.util.ArrayList;

public class Jugador extends Persona {
	
	private int numDorsal;
	private String posicionCampo;
	private ArrayList<Estadistica> estadistica;
	
	// FULL

	public Jugador(int numDorsal, String posicionCampo, ArrayList<Estadistica> estadistica) {
		this.numDorsal = numDorsal;
		this.posicionCampo = posicionCampo;
		this.estadistica = new ArrayList<Estadistica>(); 
	}
	
	// POR DEFECTO

	public Jugador() {
		this.estadistica = new ArrayList<Estadistica>(); 
	}

}
