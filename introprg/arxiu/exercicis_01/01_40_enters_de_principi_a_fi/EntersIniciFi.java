//* Exercici que retorna els valors amb un salt. 

public class EntersIniciFi{
    public static void main(String [] args){
    
        System.out.println("Valor inicial?");
        int inici = Integer.parseInt(Entrada.readLine());
        System.out.println("Valor final?");
        int fin = Integer.parseInt(Entrada.readLine());
        System.out.println("Salt?");
        int salt = Integer.parseInt(Entrada.readLine());
       
        while (inici <= fin){
        System.out.println(inici);
        inici = inici + salt;
        }
    }
}
