package intro001;

public class Moto extends Vehiculo implements Producto{
	
// ----------------------------------------- PROBLEMA 9 ----------------------------------------- |	
	
	// (9.A)  Crea la clase Moto que heredará de Vehículo e implementará la interfaz Producto. 	Debe contener los atributos enteros xx e yy.
	
		private int xx;
		private int yy;
		
		@Override
		public float getPrecio() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public String getDescripcion() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void arrancar() {
			
		}
	
	// (9.E) función toString de las subclases Moto y Coche
		
		@Override
		public String toString() {
			return "Moto [xx=" + xx + ", yy=" + yy + "]";
		}
			
}
