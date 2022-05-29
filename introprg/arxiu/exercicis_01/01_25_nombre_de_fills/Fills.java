/*
 * Aquest programa demana quants fills tenen els usuaris i 
 * respon segons el nombre de fills sigui
 */
public class Fills {
    public static void main(String[] args) {
    System.out.println("Quants fills tens?");
    int year = Integer.parseInt(Entrada.readLine());
    
    if (year == 0){
    System.out.println("Tot el que t'has estalviat en bolquers!");
    } else if (year < 0){
    System.out.println("No pots tenir menys de 0 fills!");
    } else if (year == 1){
    System.out.println("Compte de no mimar-lo massa!");
    } else if (year >= 2 && year <= 4){
    System.out.println("No t'avorreixes a casa, eh?");
    } else {
    System.out.println("Tu sí fas país!");
    }
   }
  }
