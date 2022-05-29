import java.util.ArrayList;

public class RedTransporte {
	private String nombre;
	ArrayList<Lineas> lineas;
	
	public RedTransporte() {
		this.lineas = new ArrayList<Lineas>();
	}
	public RedTransporte(String nombre) {
		this.nombre = nombre;
		this.lineas = new ArrayList<Lineas>();
	}
	
	
}
