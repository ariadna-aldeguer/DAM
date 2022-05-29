package ex1pilota;

public class Pelota {
	
	//Constructor de pelota:
	//El enunciado dice que pelota tiene tres atributos: nombre propietario, presion de inflado y operatividad
	//Atributos de la clase, definen el estado(tienen que ser privados--pueden publicos también)
	
	private String nombrePropietario; 
	private int presion;
	private boolean operativa;
	
	//Botón derecho, source, constructor using Fields:
	//Como solo tiene el nombre de entrada, se quitan presion y operativa
	public Pelota(String nombrePropietario) {
		
		this.nombrePropietario = nombrePropietario;
		this.presion = 6; //6: porque las salidas que te da, al principio la de Maradona peta, entonces es que ya tiene una presión
		this.operativa = true;
	}
	/*public Pelota() { //Este es el constructor por defecto
		
		this.nombrePropietario = nombrePropietario;
		this.presion = presion;
		this.operativa = operativa;
	}*/
	public void inflar(int num) { //void: no devuelve nada	
		// Hay que mirar primero si esta operativa o no
		if(operativa) {
			
			//Compruebas la presión:
			
			this.presion = this.presion+num;  //this.presion: es el objeto 
			if(this.presion>25) {
				operativa = false;
				this.presion = 0; 
			}
			// otra versión seria:
			// if(this.presion+presion>25){
			// 		operativa = false;
			//		this.presion = 0;
			// } else {
			// 	this.presion = this.presion + presion;
		}

	}
	public void desinflar(int num) {
		//Lo mismo que inflar, pero desinflando, respetar que no puede ser negativo
		if(operativa) {
			if(this.presion - num < 0) {
				this.presion = 0;
			} else {
				this.presion = this.presion - num;
			}
		}
	}
	public String botar() { //los print devuelven strings
		
		String retorno = "La pelota de " + this.nombrePropietario; //Como devuelvo un string, tengo que meter la info en una variable
		if(!operativa) {
			retorno += " no bota porque se ha reventado";
		} else {
			if(this.presion<=5) {
				retorno += " hace boing-boing";
			} else {
				retorno += " hace BOING-BOING";
			}
		}
		return retorno;
	}
}
