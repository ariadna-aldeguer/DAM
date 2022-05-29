package ejercicio6;

import java.util.ArrayList;

public class Cesta {
	
	private String nCliente;
	private String direccion;
	private ArrayList<ProductoVendido> productoVendido;
	
	// OTRA FORMA Y NO HACE FALTA INICIALIZARLO EN EL CONSTRUCTOR
	// private ArrayList<ProductoVendido> productoVendido = new ArrayList<ProductoVendido>();
	
	
	// FULL
	public Cesta(String nCliente, String direccion, ArrayList<ProductoVendido> productoVendido) {
		this.nCliente = nCliente;
		this.direccion = direccion;
		this.productoVendido = productoVendido;
	}
	
	public Cesta(String nCliente, String direccion) {
		this.nCliente = nCliente;
		this.direccion = direccion;
		this.productoVendido = new ArrayList<ProductoVendido>();
	}
	
	// POR DEFECTO
	public Cesta() {
		this.productoVendido = new ArrayList<ProductoVendido>();
	}
}
