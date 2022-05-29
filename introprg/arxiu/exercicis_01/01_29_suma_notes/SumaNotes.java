// programa que suma les notes

public class SumaNotes {
    public static void main(String[] args) {
    int nota;
    int suma = 0;
    
    // Demana la nota
    System.out.println("Introdueix una nota");
    nota = Integer.parseInt(Entrada.readLine());
    
    // Suma els valors diferents
    while (nota >= 0 && nota <= 100) {
    suma = suma + nota;
    System.out.println("Introdueix una nota");
    nota = Integer.parseInt(Entrada.readLine());
    }
    
    System.out.println("La suma de les notes vàlides és " + suma);
  }
}

