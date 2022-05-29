package ejercicio6;

public class ProductoEnStock extends Producto{
	
	private int unidadesEnStock;
	
	// POR DEFECTO
	public ProductoEnStock() {
		super();
	}

	// FULL
	public ProductoEnStock(String id, String nombre, String fabricante, double precioUnidadEU, int unidadesEnStock) {
		super(id, nombre, fabricante, precioUnidadEU);
		this.unidadesEnStock = unidadesEnStock;
	} 
}
