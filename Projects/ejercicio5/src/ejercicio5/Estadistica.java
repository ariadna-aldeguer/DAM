package ejercicio5;

public class Estadistica {

	private int minJugados;	
	private int nGoles;
	private boolean tAmarilla;
	private boolean tRoja; 
	private Partido durante;
	
	// FULL
	public Estadistica(int minJugados, int nGoles, boolean tAmarilla, boolean tRoja, Partido durante) {
		this.minJugados = minJugados;
		this.nGoles = nGoles;
		this.tAmarilla = tAmarilla;
		this.tRoja = tRoja;
		this.durante = durante;
	}
	// POR DEFECTO
	public Estadistica() {

	}
	

}
