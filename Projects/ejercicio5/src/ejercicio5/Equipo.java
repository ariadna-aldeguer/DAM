package ejercicio5;

import java.util.ArrayList;

public class Equipo {

	private String nombre;
	private String ciudad;
	private String direccionCampo;
	private ArrayList<Tecnico> tecnicos;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Partido> partidos;
	
	
	// FULL
	public Equipo(String nombre, String ciudad, String direccionCampo, ArrayList<Tecnico> tecnicos,
			ArrayList<Jugador> jugadores, ArrayList<Partido> partidos) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.direccionCampo = direccionCampo;
		this.tecnicos = new ArrayList<Tecnico>();
		this.jugadores = new ArrayList<Jugador>();
		this.partidos = new ArrayList<Partido>();
	}
	
	public Equipo() {
		this.tecnicos = new ArrayList<Tecnico>();
		this.jugadores = new ArrayList<Jugador>();
		this.partidos = new ArrayList<Partido>();
	}
	
	
	
}
