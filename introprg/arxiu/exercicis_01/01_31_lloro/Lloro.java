// programa que repeteix les paraules

public class Lloro {
	public static void main(String [] args) {
	
	
	System.out.println("El lloro pregunta paraula:");
	String word = Entrada.readLine();
	
	while (!(word.isBlank())){
		System.out.println("El lloro diu: " + word);
		System.out.println("El lloro pregunta paraula:");
		word = Entrada.readLine();
		}
	System.out.println("Adéu");
	}
  }
