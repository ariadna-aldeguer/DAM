package intro001;


// public class Coche extends Vehiculo{
		
/*	
	
//----------------------------------------- PROBLEMA 4 ----------------------------------------- 

	
	//(4.A) a) Crea una clase Coche, que heredará de Vehículo, y además contendrá los
	// siguientes atributos propios: numPuertas y capacidadMaletero
	
	private int numPuertas;
	private int capacidadMaletero;
	
	
	// (4.B) Crea los Getters y Setters correspondientes en la clase Coche
	
	public int getNumPuertas() {
		return numPuertas;
	}
	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}
	public int getCapacidadMaletero() {
		return capacidadMaletero;
	}
	public void setCapacidadMaletero(int capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}
	
	// (4.C) Crea un constructor por defecto en la clase Coche. En ellos se debe de inicializar
	// todos los atributos de la clase (los heredados y los suyos propios), pero sin usar ningún
	// método/constructor de la clase base Vehiculo. ¿Ocurre algún error?
	
	/*
	public Coche() {
		this.color = "";
		this.caballos = 0;
		this.marca = "";
		this.modelo = "";
		this.numPuertas = 0;
		this.capacidadMaletero = 0;
		
	}
	
	// El modificador de acceso correcto para que los atributos de la clase base
	// Vehiculo sean accesibles desde la clase hijo Coche debe ser protected.
	
	// (4.E) Modifica el constructor por defecto de la clase Coche, pero en este caso usando
	// constructores de la clase base Vehiculo.
	
	public Coche() {
		super();
		this.numPuertas = 0;
		this.capacidadMaletero = 0;
		
	}
	
	// (4.E) Crea un constructor full de parámetros de la clase Coche. La idea básica es que los
	// parámetros del padre los inicialice el constructor del padre y los parámetros del hijo los
	// inicialice el hijo.
	
	public Coche(String color, int caballos, String marca, String modelo, int numPuertas, int capacidadMaletero) {
		super(color, caballos, marca, modelo);
		this.numPuertas = numPuertas;
		this.capacidadMaletero = capacidadMaletero;
	}
	
*/ 	
	/* 
	 * 
	//----------------------------------------- PROBLEMA 5 ----------------------------------------- 
	
	
		private int numPuertas;
		private int capacidadMaletero;
		
		//(5.F) Redefine el método arrancar en la subclase Coche
		
		public void arrancar() {
			 // TODO Auto-generated method stub
		}
		
		public Coche(String color, int caballos, String marca, String modelo, int numPuertas, int capacidadMaletero) {
			super(color, caballos, marca, modelo);
			this.numPuertas = numPuertas;
			this.capacidadMaletero = capacidadMaletero;
		}
		
		
	*/	
	
	
//----------------------------------------- PROBLEMA 6 -----------------------------------------|
	
	// (6.A) Redefine los atributos propios de Coche, añadiendo la etiqueta final a uno y static al otro, siendo ahora públicos ambos. 
		
	   /*
		public final int numPuertas;
		public static int capacidadMaletero;
	  */

	// (6.B) 
		
		
		/*
		public static int getCapacidadMaletero() {
			return capacidadMaletero;
		}
		public static void setCapacidadMaletero(int capacidadMaletero) {
			Coche.capacidadMaletero = capacidadMaletero;
		}
		public int getNumPuertas() {
			return numPuertas;
		}
		public void setNumPuertas(int numPuertas) {
			this.numPuertas = numPuertas;
		}
		*/
		
		
	// (6.D) Queremos asignar un valor constante de 4 a numPuertas y que no se vuelva a modificar nunca más ¿Cómo se puede hacer tal cosa?
		
		/*
		public Coche() {
			super();
			this.numPuertas= 4;
			this.capacidadMaletero = 200;
		}
		
		public int getNumPuertas() {
			return numPuertas;
		}
		*/
	
		
	// (7.A) Crea una clase Radio dentro de la clase Coche, con los siguientes atributos y métodos. Añade un atributo de tipo Radio en la clase Coche.
		
		/*		
		public Radio radio;
		
		public class Radio{
			boolean encendido;
			int frecuencia=100;
			public void encender() {}
			public void apagar() {}
		}
		
	// (7.B) Añade un setter de Radio en Coche y en el constructor de Coche inicializa el atributo Radio.
		
		public Coche() {
			super();
			this.numPuertas=4;
			this.capacidadMaletero=200;
			this.radio= new Radio();
		}
		public void setRadio(Radio radio) {
			this.radio = radio;
		}
		*/
		
//----------------------------------------- PROBLEMA 8 -----------------------------------------|	
		
		// (8.B) Haz que la clase Coche implemente la interfaz Producto. ¿Da errores?
		
public class Coche extends Vehiculo implements Producto{
	
		public final int numPuertas;
		public static int capacidadMaletero;
		public Radio radio;
		
		public class Radio{
			boolean encendido;
			int frecuencia=100;
			public void encender() {}
			public void apagar() {}
		}

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
		
		public Coche() {
			super();
			this.numPuertas=4;
			this.capacidadMaletero=200;
			this.radio= new Radio();
		}
		
		public void setRadio(Radio radio) {
			this.radio = radio;
		}
		@Override
		public void arrancar() {
		}
				
//----------------------------------------- PROBLEMA 9 -----------------------------------------|	
	
		
	// (9.E) función toString de las subclases Moto y Coche
		
		@Override
		public String toString() {
			return "Coche [numPuertas=" + numPuertas + ", radio=" + radio + "]";
		}

		
		
		
		
		


	
}
		

