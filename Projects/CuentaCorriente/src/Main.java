import java.util.Random;

public class Main {

	public static void main(String[] args) {
		/*CuentaCorriente c1 = new CuentaCorriente("Edu", 1111, 100, 0 );
		CuentaCorriente c2 = new CuentaCorriente("Moises", 2222, 200, 0 ); 
		boolean procedimiento = iguala_saldo(c1, c2);*/
		
		
		if (iguala_saldo(c1, c2)) {
			System.out.println("Se ha podido igualar la cuenta corriente uno con la 2");
		}
		if (iguala_saldo(c2, c3)) {
			System.out.println("Se ha podido igualar la cuenta corriente dos con la tres");
		}
		if (mismo_saldo(c1,c2,c3)) {
			System.out.println("Las tres cuentas tienen el mismo saldo");
	    } else {
	    	System.out.println("Las tres cuentas NO tienen el mismo saldo");
	    }
		//Exercici 8c)
		CuentaCorriente c1 = new CuentaCorriente("Maria", 1001, 1000, 0 );
		CuentaCorriente c2 = new CuentaCorriente("Joan", 1002, 500, 0 );
		CuentaCorriente c3 = new CuentaCorriente("Jesus", 1031, 250, 0 );
		
		
		//Ingresar en cada uno de las cuentas anteriores una cantidad de euros obtenida al azar y
		//comprendida entre 100 y 200 (cada cuenta ha de tener su cantidad). Para generar la cantidad que
		//se ingresa en cada cuenta utiliza la función aleaJactaEst 
		c1.setSaldo(aleaJactaEst(100,200));
		c2.setSaldo(aleaJactaEst(100,200));
		c3.setSaldo(aleaJactaEst(100,200));
		
		//Utilizando la función rollTheDice, escoger una de las 3 cuentas. La cuenta escogida se
		//"guardará" en la variable llamada afortunada.
		
		CuentaCorriente afortunada = rollTheDice(c1,c2,c3);
		
		//Utilizando la función rollTheDice, escoger uno de las 3 cuentas. La cuenta escogida se
		//guardará" en la variable llamada malaPata
		
		CuentaCorriente malaPata = rollTheDice(c1,c2,c3);
		
		//Hacer que la cuenta afortunada reciba unos intereses del 10% 
		dar_intereses(afortunada,10);
		
		// Intentar retirar de la cuenta malaPata 150 euros 
		// Decir si la operación anterior se ha podido efectuar o no. 
		if(malaPata.retirar(150)) {
			System.out.println("Se ha podido retirar 150 euros de malapata");
		}

	}
	public static boolean iguala_saldo (CuentaCorriente c1, CuentaCorriente c2) {
		
		// Escribir una función que dadas dos cuentas se iguale el saldo,
		// pasando las cantidades de dinero que hagan falta de la cuenta que más 
		// tiene a la cuenta que menos tiene. El resultado es un valor booleano 
		// que indica si la operación se ha podido hacer 
		
		double s1 = c1.getSaldo();
		double s2 = c2.getSaldo();
		boolean procedimiento = false;
		
		 if (s1>s2) {   //Imaginemos que s1= 200, s2 =100; 
			 procedimiento = c1.retirar(s1-(s1-s2)/2);  //200-(200+100):2 -- 200-150 = 50
			 if (procedimiento) {
					c2.ingresar(s1-(s1-s2)/2);
			 }
		} else if (s2>s1) {
			 procedimiento = c2.retirar(s1-(s1-s2)/2);
			 if (procedimiento) {
			 	c1.ingresar(s1-(s1-s2)/2);
			 }
		} else {
			procedimiento = true;
		} 
		return procedimiento; 
	}
	public static boolean mismo_saldo(CuentaCorriente c1, CuentaCorriente c2, CuentaCorriente c3) {

		if (c1.getSaldo() == c2.getSaldo() && c2.getSaldo() == c3.getSaldo()) {
			return true;
		}
		return false; 
	}
	
	//Problema 8a
	public static void dar_intereses (CuentaCorriente c, int n) {
			//c.saldo = c.saldo + c.saldo*n/100
		double saldito = c.getSaldo();
		saldito = saldito + saldito*n/100;
		c.setSaldo(saldito);  //Set: Se mete en la clase almacenada 
	}
	//Problema 8b
	public static int aleaJactaEst(int min, int max) {
		Random random = new Random();
		return random.nextInt(max + 1 - min) + min;
	}
	public static CuentaCorriente rollTheDice(CuentaCorriente c1,
										      CuentaCorriente c2,
										      CuentaCorriente c3) {
		
		int num = aleaJactaEst(1,3);
			if(num==1) {
				return c1;
			} else if (num==2) {
				return c3;
			} else {
				return c3;
			}
	}
	
	
}
