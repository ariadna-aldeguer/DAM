package intro001;

// public class Vehiculo {

/* ----------------------------------------- PROBLEMA 1 ----------------------------------------- */

/* (1.A) Crea la clase vehículo con los siguientes atributos: 


	public String color;
	public int caballos;
	public String marca;
	public String modelo;
	
	public Vehiculo() {
		this.marca="";
		this.modelo="";
	}
	*/	

/* (1.E) Quitamos el modificador public de los atributos de Vehiculo, dejando el modificador default (por defecto). 
 *    ¿En qué ficheros ocurren errores? ¿Es coherente con lo que dice la teoria? 
 * 
 * Presentan errores las clases dentro del segundo paquete, ya que no pueden acceder a la clase vehículo. 
 * Solo las clases en el mismo paquete pueden acceder a la propiedad o método. 

	
	String color;
	int caballos;
	String marca;
	String modelo;
	
	public Vehiculo() {
		this.marca="";
		this.modelo="";
	}
	 */	

/* (1.F) Ponemos el modificador protected a los atributos de Vehiculo ¿En qué ficheros
 *     ocurren errores? ¿Es coherente con lo que dice la teoría? 
 * 
 * Solo hay errores en el Main. Las clases del mismo paquete pueden acceder y las hijos de la clase también. 
 * 
 * 

	
	protected String color;
	protected int caballos;
	protected String marca;
	protected String modelo;
	
	public Vehiculo() {
		this.marca="";
		this.modelo="";
	}

*/

/* (1.G) Ponemos ahora el modificador private a los atributos de Vehiculo ¿En qué ficheros 
 *     ocurren errores? ¿Es coherente con lo que dice la teoría? 
 *     
 *     Ocurren errores en todos los ficheros (Main, 002Coche, 002Main) 
 *     Al ser privados solo pueden ser usados por la misma clase. 
 * 
 *     

	
	private String color;
	private int caballos;
	private String marca;
	private String modelo;
	
	public Vehiculo() {
		this.marca="";
		this.modelo="";
	}
}
*/


/* ----------------------------------------- PROBLEMA 2 ----------------------------------------- 

	
	private String color;
	private int caballos;
	private String marca;
	private String modelo;

	
/* (2.B) Crear las funciones Getters y Setters en la clase Vehiculo para que sus atributos privados puedan ser accedidos. 
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}


//----------------------------------------- PROBLEMA 3 ----------------------------------------- 
/*
	
	private String color;
	private int caballos;
	private String marca;
	private String modelo;
*/	
//(3.A) Elimina el constructor creado anteriormente en Vehiculo. ¿Ocurre algún error? ¿Por qué?
//*  
//*   No ocurre nada porque el sistema interpreta de forma implícita que hay un por defecte, sin parámetros. 	
	
	//public Vehiculo() {
		//this.marca="";
		//this.modelo="";	
	//}


	
//(3.B) Crea un constructor full, es decir, con todos los parámetros de la clase en Vehiculo.
//	¿Ocurre algún error? ¿Por qué?
/*

	public Vehiculo(String color, int caballos, String marca, String modelo) {
		super();
		this.color = color;
		this.caballos = caballos;
		this.marca = marca;
		this.modelo = modelo;
	}
*/	
//(3.C) Crea un constructor por defecto en Vehiculo 
/*	
	public Vehiculo() {
		this.color = "";
		this.caballos =0;
		this.marca = "";
		this.modelo="";
	}
*/ 	
//(3.D) Crea otro constructor full de 4 parámetros en la clase Vehiculo ¿Cuantos constructores
//	diferentes se pueden crear en esta clase?
//Infinitos, siempre que se diferencien en numero o tipo de parámetros.

/*
	public Vehiculo(String color, String marca, int caballos, String modelo) {
		super();
		this.color = color;
		this.caballos = caballos;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
*/

//----------------------------------------- PROBLEMA 4 ----------------------------------------- 

	// (4.D) Soluciona el error del apartado anterior.


	/*	
	protected String color;
	protected int caballos;
	protected String marca;
	protected String modelo;
	
	*/


/* ----------------------------------------- PROBLEMA 5 ----------------------------------------- */ 

//(5.A) a) Declara la clase Vehículo “abstract”.

/*
public abstract class Vehiculo {

	protected String color;
	protected int caballos;
	protected String marca;
	protected String modelo;
	
	public Vehiculo() {
		this.color = "";
		this.caballos =0;
		this.marca = "";
		this.modelo="";
	}
*/

//(5.B)Elimina la clausula abstract de la clase Vehiculo, pero ahora crea un método abstract
//por ejemplo arrancar(). ¿Qué ocurre? ¿Surgen nuevos problemas?

//Una clase que tenga un método abstract, convierte la clase en abstract
/*


	protected String color;
	protected int caballos;
	protected String marca;
	protected String modelo;
	
	abstract public void arrancar();
	
	
*/

//(5.C) Vuelve a definir la clase Vehiculo abstract ¿Qué ocurre ahora?

//Surge un problema en la clase hijo Coche



public abstract class Vehiculo {

	protected String color;
	protected int caballos;
	protected String marca;
	protected String modelo;
	
	abstract public void arrancar();

	


	
	
}
