package ejercicio5;

import java.util.ArrayList;


public class Partido {

	private String fecha;
	private ArrayList<Estadistica> estadistica;
	private Equipo ganador;
	private Equipo[] enfrenta = new Equipo[2];
	
	// FULL

	public Partido(String fecha, ArrayList<Estadistica> estadistica, Equipo ganador, Equipo[] enfrenta) {
		this.fecha = fecha;
		this.estadistica = new ArrayList<Estadistica>();
		this.ganador = ganador;
		this.enfrenta = enfrenta;
	}
	// POR DEFECTO

	public Partido() {
		this.estadistica = new ArrayList<Estadistica>();
	}

}
