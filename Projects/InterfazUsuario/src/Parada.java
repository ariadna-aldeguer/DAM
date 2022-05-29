import java.util.ArrayList;

public class Parada {
	private String nombre;
	ArrayList<Tramo> tramos;
	
	public Parada() {
		this.tramos = new ArrayList<Tramo>();
	}
	
	public Parada(String nombre) {
		super();
		this.nombre = nombre;
		this.tramos = new ArrayList<Tramo>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
