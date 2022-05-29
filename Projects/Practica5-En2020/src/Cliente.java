import java.util.ArrayList;

public class Cliente {
	private String nif;
	private String nombre;
	private String tfno;
	private String clienteDesde;
	private double facturado;
	private int ultimoPrivilegioRegaloEn;
	private ArrayList<Privilegio> privilegios;
	private ArrayList<Pedido> pedidos;
	
	
	public Cliente() {
		this.privilegios = new ArrayList<Privilegio>();
		this.pedidos = new ArrayList<Pedido>();
	}
	public Cliente(String nif, String nombre, String tfno, String clienteDesde, double facturado, int ultimoPrivilegioRegaloEn) {
		this.nif = nif;
		this.nombre = nombre;
		this.tfno = tfno;
		this.clienteDesde = clienteDesde;
		this.facturado = facturado;
		this.ultimoPrivilegioRegaloEn = ultimoPrivilegioRegaloEn;
		this.privilegios = new ArrayList<Privilegio>();
		this.pedidos = new ArrayList<Pedido>();
	}
	
	/* PREGUNTA 2*/
	public Cliente(String nif, String nombre, String tfno, double facturado,
			int ultimoPrivilegioRegaloEn) {
		this.nif = nif;
		this.nombre = nombre;
		this.tfno = tfno;
		this.clienteDesde = Fecha.getFechaActual();
		this.facturado = facturado;
		this.ultimoPrivilegioRegaloEn = ultimoPrivilegioRegaloEn;
		this.privilegios = new ArrayList<Privilegio>();
		this.pedidos = new ArrayList<Pedido>();
	}
	
	
}
