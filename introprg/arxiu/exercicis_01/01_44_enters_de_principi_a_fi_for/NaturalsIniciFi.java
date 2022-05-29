//* Retorna Valors amb Salt amb el for

public class NaturalsIniciFi{
    public static void main(String [] args){
        
        
        System.out.println("Valor inicial?");
        int inici = Integer.parseInt(Entrada.readLine());
        System.out.println("Valor final?");
        int fin = Integer.parseInt(Entrada.readLine());
        System.out.println("Salt?");
        int salt = Integer.parseInt(Entrada.readLine());
       
        for(int num = inici; num <= fin; num = num + salt){
        System.out.println(num);
        }
    }
}
