package ascensor;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Problema 2
		/*
		Ascensor a1, a2;  //Esto son los objetos
		a1 = new Ascensor(0,10);
		a2 = a1;
		a1.ir(6);
		a2.bajar();
		a1 = new Ascensor(-1, a1.getMax()/2);
		
		a1.ir(a2.getPiso());
		a1.subir();
		a2.bajar();
		System.out.println("El ascensor 1 está en el piso: " + a1.getPiso());
		System.out.println("El ascensor 2 está en el piso: " + a2.getPiso());
		*/
		
		//Problema 3 a)
		/*
		
		Ascensor asc1, asc2;
		int veces;
		asc1 = new Ascensor (0,4);
		asc2 = new Ascensor(-2,7);
		asc1.ir(2);
		asc2.ir(asc1.getPiso()+2);
		veces = 0;
		while (veces < 5) {
			asc1.subir();
			asc2.bajar();
			veces = veces + 1;
		}
		System.out.println("El primer ascensor está en el piso: " + asc1.getPiso());
		System.out.println("El segundo ascensor está en el piso: " + asc2.getPiso());
		
		*/
		//Problema 3 b)
		/*
		
		Ascensor asc1, asc2, asc3;
		asc1 = new Ascensor(0,19);
		asc2 = new Ascensor(-4, 4);
		asc3 = new Ascensor(-2, 10);
		
		asc1.ir(5);
		asc2.ir(asc1.getPiso()-10);
		asc3.ir(asc1.getPiso()+asc2.getPiso());
		
		while(asc1.getPiso()>0) {
			asc1.bajar();
			asc2.subir();
			asc3.bajar();
		}
		System.out.print("Primer ascensor:");
		escribirPiso(asc1.getPiso());
		System.out.print("Segon ascensor:");
		escribirPiso(asc2.getPiso());
		System.out.print("Tercer ascensor:");
		escribirPiso(asc3.getPiso());
	}
		
		public static void escribirPiso(int piso) {
			if (piso == 0) { 
				System.out.println(" se encuentra en la planta baja");
			} else if (piso > 0 ) {
				System.out.println(" se encuentra en la planta " + piso);
			} else{ 
				System.out.println(" se encuentra en el subterraneo " + piso);
			}	
		}
		
		*/
		//Problema 3 c)
		/*
		Ascensor asc;
		// Ascensor: class. asc = objeto
		asc = new Ascensor(10,30);
		asc.ir(28);
		for(int i = 15; i > 0; i--) {
			asc.bajar();
		}
		System.out.println("El ascensor está en el piso: " + asc.getPiso());
		
	  }
	  */
		//Problema 3 d)
		/*
		Ascensor asc1, asc2;
		Scanner lector = new Scanner(System.in);
		System.out.print("Introduce piso inicial: ");
		int min = lector.nextInt(); 
		
		System.out.print("Introduce piso final: ");
		int max = lector.nextInt(); 
		
		
		asc1 = new Ascensor (min, max);
		asc1.ir(   (asc1.getMax()+asc1.getMin()  )/2);
		
		asc2 = new Ascensor(asc1.getPiso(), asc1.getMax()+1);
		while(asc2.getPiso() < asc2.getMax()) {
			asc2.subir();
		}
		System.out.println("El primer ascensor puede ir del piso "+ asc1.getMin() + " al piso " + asc1.getMax());
		System.out.println("El primer ascensor está en la planta: " + asc1.getPiso());
		System.out.println("El segudno ascensor puede ir del piso "+ asc2.getMin() + " al piso " + asc2.getMax());
	
	}
	*/
}
