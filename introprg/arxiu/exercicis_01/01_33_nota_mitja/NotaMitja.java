//* Programa que treu la nota mitja 

public class NotaMitja{
    public static void main(String [] args){
	
	    int suma, mitja, nota;
	    nota = suma = mitja = 0;
	    
	    System.out.println("Introdueix una nota"); 
	    nota = Integer.parseInt(Entrada.readLine());
	    
	    if (nota < 0 || nota > 100){
	        System.out.println("Cap nota vàlida introduïda");
	   } while (nota >= 0 && nota <= 100){
	        suma = suma + nota;
	        mitja = mitja + 1;
	        System.out.println("Introdueix una nota");
	        nota = Integer.parseInt(Entrada.readLine()); 
	        if (nota < 0  || nota > 100){
	        	   suma = suma / mitja;
	        	   System.out.println("La mitja de les notes vàlides és " + suma); 
	        }
	   } 

       }
}

