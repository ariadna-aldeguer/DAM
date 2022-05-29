package ejercicio6;

public class Producto {
	
	// # -> protected, para que lo puedan ver los hijos
	
	protected String id;
	protected String nombre;
	protected String fabricante;
	protected double precioUnidadEU;
	
	
	// FULL
	public Producto(String id, String nombre, String fabricante, double precioUnidadEU) {
		this.id = id;
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.precioUnidadEU = precioUnidadEU;
	}
	
	//POR DEFECTO
	public Producto() {
		this.id = "";
		this.nombre = "";
		this.fabricante = "";
		this.precioUnidadEU = 0;
	}
}
