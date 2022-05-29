import java.util.ArrayList;

public class Ruta {
	private int tRecorrido;
	ArrayList<Parada> paradas;
	
	
	public Ruta() {
		this.paradas = new ArrayList<Parada>();
	}
	public Ruta(int tRecorrido) {
		this.tRecorrido = tRecorrido;
		this.paradas = new ArrayList<Parada>();
	}
	public int gettRecorrido() {
		return tRecorrido;
	}
	public void settRecorrido(int tRecorrido) {
		this.tRecorrido = tRecorrido;
	}
	public ArrayList<Parada> getParadas() {
		return paradas;
	}
	public void setParadas(ArrayList<Parada> paradas) {
		this.paradas = paradas;
	}
	
	
	
}
