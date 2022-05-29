import java.util.ArrayList;


public class Producto {
		
	// |---------------------------PROBLEMA 6 -------------------------------̣|
	
	// (6.A) Crea la clase Producto con los siguientes 3 atributos, 2 constructores y la función toString
	
	private int code;
	private double precioEuros;
	private String nombre;
	
	// POR DEFECTO
	public Producto () {
		
	}
	// FULL
	public Producto(int code, double precioEuros, String nombre) {
		this.code = code;
		this.precioEuros = precioEuros;
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Producto [code=" + code + ", precioEuros=" + precioEuros + ", nombre=" + nombre + "]";
	}
		
	
	// (6.E) Define los métodos hashCode y equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precioEuros);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (code != other.code)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precioEuros) != Double.doubleToLongBits(other.precioEuros))
			return false;
		return true;
	}	
	
}
