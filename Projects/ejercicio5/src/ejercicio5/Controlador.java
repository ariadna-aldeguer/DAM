package ejercicio5;

import java.util.ArrayList;

public class Controlador {
	private ArrayList<Equipo> equipos;
	private ArrayList<Partido> partidos;
	
	
	public Controlador(ArrayList<Equipo> equipos, ArrayList<Partido> partidos) {
		super();
		this.equipos = new ArrayList<Equipo>();
		this.partidos = new ArrayList<Partido>();
	}
	
	public Controlador() {
		this.equipos = new ArrayList<Equipo>();
		this.partidos = new ArrayList<Partido>();
	}
	
}