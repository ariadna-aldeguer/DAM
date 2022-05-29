/*
 * Aquest programa dona el canvi d'una transacció de diners 
 */
public class Pagament {
    public static void main(String[] args) {
    	System.out.println("Preu?");
        int preu = Integer.parseInt(Entrada.readLine());
        System.out.println("Paga?");
        int paga = Integer.parseInt(Entrada.readLine());
        
        if (preu < paga){
        int retorn = paga - preu;
        System.out.println("Sobren "+ retorn + "€");
        } else if (preu > paga){
        int falta = preu - paga;
        System.out.println("Falten " + falta + "€");
        } else if (preu == paga){
        System.out.println("No sobra ni falta res");
        }
      }
     }
