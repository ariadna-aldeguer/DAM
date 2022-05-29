package problema1;

public class main {

	public static void main(String[] args) {		
		
		//Problema 2
			
		/* Vehiculo v1 = new Vehiculo();
		v1.setCaballos(100);
		v1.Color("Blanco");
		v1.Marca("Ferrari");
		v1.Modelo("v5");*/
		
		//Problema 4;
		/*Vehiculo v1 = new Vehiculo(); //Asi se crea un objeto en Vehiculo
		
		v1.setCaballos(100);
		v1.setColor("Blanco");
		v1.setMarca("Ferrari");
		v1.setModelo("v5"); */ 

		//Problema 8
		Coche c1 = new Coche(); //Constructor por defecto
		c1.Color = "amarillo";
		c1.Caballos = 180;
		c1.Marca = "Nissan";
		c1.Modelo = "Primera";
		c1.numPuertas = 4;
		c1.capacidadMaletero = 30;
		
		//Coche c2 = c1; c1 le esta dando los datos a c2
		
		Coche c2 = new Coche("amarillo", 180, "Nissan", "Primera", 4, 30);
		
		 
		 
		
		
	}

}
