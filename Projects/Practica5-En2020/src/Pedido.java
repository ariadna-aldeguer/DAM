import java.util.ArrayList;

import javax.sound.sampled.Line;

public class Pedido {
	private String fecha;
	private Viajante viajante;
	private ArrayList<Linea> lineas;
	private Cliente cliente;
	
	
	public Pedido() {
		this.lineas = new ArrayList<Linea>();
	}
	public Pedido(String fecha, Viajante viajante, Cliente cliente) {
		this.fecha = fecha;
		this.viajante = viajante;
		this.lineas = new ArrayList<Linea>();
		this.cliente = cliente;
	}
	
	/* PREGUNTA 3 Constructor. Debe inicializarlo a un pedido sin productos. Debe hacer que el
	atributo fecha sea un string que represente la fecha en la que el constructor es invocado. Decidid los
	argumentos a pasar a dicho constructor. */
	
	public Pedido(Viajante viajante, Cliente cliente) {
		this.fecha = Fecha.getFechaActual();
		this.lineas = new ArrayList<Linea>();
		this.cliente = cliente;
		this.viajante = viajante;
	}
	
	/* PREGUNTA 3.2. Este método debe crear una nueva línea a partir del producto referenciado por el argumento p y la
	cantidad pasada en el argumento cantidad. */
	
	public void addLinea(Producto p, int cantidad) {
		Linea linea = new Linea(cantidad, p);
	}
	
	/* PREGUNTA 3.3. Este método debe devolver el coste total del pedido sin tener en cuenta privilegio alguno. */
	public double calcularCoste() {
		double coste = 0;
		for (Linea linea: lineas) {
			coste += linea.getProducto().getPrecio()*linea.getCantidad();
		}
		return coste;
	}
	
	/* PREGUNTA 3.4. Este método devuelve el producto con más unidades solicitadas en el pedido. 
	Si hay varios productos de los que se han solicitado este número de unidades máximo, el método 
	devuelve uno de ellos solamente; da igual cuál de ellos. */
	
	public Producto getProductoConMasUnidades() {
		int q = 0;
		int aux = 0;
		Producto producto = null;
		for (Linea linea: lineas) {
			aux = linea.getCantidad();
			if(aux > q) {
				q = linea.getCantidad();
				producto = linea.getProducto();
			}
		}
		return producto;
	}
	
	
	
	
}
