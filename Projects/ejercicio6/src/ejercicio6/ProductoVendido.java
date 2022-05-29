package ejercicio6;

public class ProductoVendido extends Producto{
	
	private int UnidadesVendidas;
	
	// FULL
	public ProductoVendido(String id, String nombre, String fabricante, double precioUnidadEU, int unidadesVendidas) {
		super(id, nombre, fabricante, precioUnidadEU);
		UnidadesVendidas = unidadesVendidas;
	}
	
	// POR DEFECTO
	public ProductoVendido() {
		super();
	}
}
