import java.util.ArrayList;

public class Viajante {
	private String nombre;
	private String nif;
	private ArrayList<Pedido> pedidos;
	
	
	public Viajante() {
		this.pedidos = new ArrayList<Pedido>();
	}
	public Viajante(String nombre, String nif) {
		this.nombre = nombre;
		this.nif = nif;
		this.pedidos = new ArrayList<Pedido>();
	}
	
	
	
}
