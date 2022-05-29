package intro001;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

/* ----------------------------------------- PROBLEMA 1 ----------------------------------------- */

/*(1.B) Crea la clase Main dentro del mismo paquete que utilice la clase Vehículo 

		
		Vehiculo v1 = new Vehiculo();
		
		// Constructor
		
		v1.color = "amarillo";
		v1.caballos = 180;
		v1.marca = "Nissan";
		v1.modelo = "Primera";

	}
}
*/

/* ----------------------------------------- PROBLEMA 2 ----------------------------------------- 


	/* (2.A) Borramos el package extra y las clases contenidas en el. Dejamos los atributos
	 *     de la clase Vehiculo con el modificador private. ¿Cómo queda el Main? 
	 *     
	 *     Los atributos de vehiculo siguen dando error porque estan en private y no se pueden acceder a ellos.


		
		Vehiculo v1 = new Vehiculo();
		
		
	// (2.C) Arregla el problema en Main, corrigiendo los errores pero manteniendo la funcionalidad 
		
		// Constructor
		v1.setColor("amarillo");
		v1.setCaballos(180);
		v1.setMarca("Nissan");
		v1.setModelo("Primera");
		

	}
}

*/

/* ----------------------------------------- PROBLEMA 3 ----------------------------------------- 


		/*(3.B) Si se define un constructor diferente al por defecto, el sistema
		 * obliga a defirnir el contrusctor por defecto */
		/*		
		Vehiculo v1 = new Vehiculo();
		// Constructor
		v1.setColor("amarillo");
		v1.setCaballos(180);
		v1.setMarca("Nissan");
		v1.setModelo("Primera");


}

}

/* ----------------------------------------- PROBLEMA 4 ----------------------------------------- */ 
/*		
		
		// (4.F) Instancia dos coches usando métodos diferentes, de manera que al final ambos
		// coches tengan el mismo estado (el mismo valor de sus atributos).
		
		Coche c1 = new Coche();
		c1.setColor("amarillo");
		c1.setCaballos(180);
		c1.setMarca("Nissan");
		c1.setModelo("Primera");
		c1.setNumPuertas(5);
		c1.setCapacidadMaletero(200);
		
		Coche c2 = new Coche("amarillo",180,"Nissan","Primera",5,200);
*/	

/* ----------------------------------------- PROBLEMA 5 ----------------------------------------- */ 

		
			
	// (5.E) b) En el main instancia una variable de tipo Vehiculo ¿Qué ocurre?
		
	// Vehiculo v1 = new Vehiculo();
	// Vehiculo v2 = new Vehiculo();
		
	//	Una clase abstracta no se puede instanciar, solo se usa para definir una
	// jerarquía de clases y para que otras clases deriven de ella.
	
	
// ----------------------------------------- PROBLEMA 6 ----------------------------------------- 
	
	
	// (6.C) Crea un Objeto coche en el main
	
		/*
		Coche c1= new Coche();
		c1.numPuertas = 6;
		c1.capacidadMaletero = 200;
		*/
	
	// (6.D) 
		
		/*
		Coche c1 = new Coche();
		System.out.print(c1.numPuertas);
		*/
		
	// (6.E) crea 3 objetos de tipo coche, asignando una capacidadMaletero distinta a cada uno.
		
		/*
		Coche c1 = new Coche();
		c1.capacidadMaletero=30;
		Coche c2 = new Coche();
		c2.capacidadMaletero=21;
		Coche c3 = new Coche();
		c3.capacidadMaletero=54;
		
		System.out.print(c1.capacidadMaletero);
		System.out.print(c2.capacidadMaletero);
		System.out.print(c3.capacidadMaletero);
		
		*/
		
//----------------------------------------- PROBLEMA 7 -----------------------------------------|
		
	// (7.C) Crea un programa que cree un coche y le asigne una Radio de forma externa. 
		
		Coche micoche = new Coche();
		Coche.Radio laradio = micoche.new Radio();
		micoche.setRadio(laradio);;
		laradio.encender();
		
// ----------------------------------------- PROBLEMA 9 ----------------------------------------- |	
		
	// (9.B) En un programa de Main crea un objeto de tipo Coche y otro de tipo Moto, y guárdalos en variables tipo Vehículo. ¿Es posible?
		
		Vehiculo v1 = new Coche();
		Vehiculo v2 = new Moto();
		Coche c3 = new Coche();
		Vehiculo v3 = c3;
		
	
	// (9.C) Intenta guardar un coche y una moto en un objeto de tipo Producto.
		
		Producto p1 = new Coche();
		Producto p2 = new Moto();
		Coche c4 = new Coche();
		Producto p3 = c4;
		
	// (9.D) Haz un programa que genere un array de 5 Vehículos
		
		/*
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i<5;i++) {
			System.out.print("1.Moto o 2.Coche: ");
			int opcion = sc.nextInt();
			if(opcion==1) {
				Moto mimoto = new Moto();
				lista.add(mimoto);
			} else {
				Coche micoche2 = new Coche();
				lista.add(micoche2);
			}
		}
		for (Vehiculo v:lista) {
			if (v instanceof Moto)
				System.out.println("Se trata de una moto");
			else
				System.out.println("Se trata de un coche");
		}
		
		*/
		
	// (9.E) muestra por pantalla el contenido del array mediante la función instanceOf.
		
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i<5;i++) {
			System.out.print("1.Moto o 2.Coche: ");
			int opcion = sc.nextInt();
			if(opcion==1) {
				Moto mimoto = new Moto();
				lista.add(mimoto);
			} else {
				Coche micoche2 = new Coche();
				lista.add(micoche2);
			}
		}
		for (Vehiculo v:lista) {
			System.out.println(v);
		}
	}
}

