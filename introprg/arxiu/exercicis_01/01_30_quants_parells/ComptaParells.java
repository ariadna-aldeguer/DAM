// programa que et retorna els parells

public class ComptaParells {
    public static void main(String[] args) {
    
    int valor = 0;
    int suma = 0;
    
    System.out.println("Introdueix un valor");
    valor = Integer.parseInt(Entrada.readLine());
    
    while (valor >= 0) {
    	if (valor % 2 == 0) {
    	suma = suma + 1;
    	System.out.println("Introdueix un valor");
    	valor = Integer.parseInt(Entrada.readLine());
    	} else {
    	System.out.println("Introdueix un valor");
    	valor = Integer.parseInt(Entrada.readLine()); 
    	}
    	}
    System.out.println("Parells introduïts: " + suma);
  }
 }
