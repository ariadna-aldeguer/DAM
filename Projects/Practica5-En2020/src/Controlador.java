import java.util.ArrayList;

public class Controlador {
	private Catalogo catalogo;
	private ArrayList<Viajante> viajantes;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Cliente> clientes;
	
	public Controlador() {
		super();
		this.catalogo = new Catalogo();
		this.viajantes = new ArrayList<Viajante>();
		this.pedidos = new ArrayList<Pedido>();
		this.clientes = new ArrayList<Cliente>();
	}
	
	public Controlador(Catalogo catalogo) {
		super();
		this.catalogo = catalogo;
		this.viajantes = new ArrayList<Viajante>();
		this.pedidos = new ArrayList<Pedido>();
		this.clientes = new ArrayList<Cliente>();
	}
}
