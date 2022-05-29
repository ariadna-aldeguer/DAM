//**Programa que demana el nom, edat i any actual i retorna la edat als anys. 

public class HistoricEdats2{
    public static void main(String [] args){
            
            System.out.println("nom?");
            String nom = Entrada.readLine();
            System.out.println("edat?");
            int edat = Integer.parseInt(Entrada.readLine());
            System.out.println("any actual?");
            int any = Integer.parseInt(Entrada.readLine());
            
            int naixement = any - edat;
            
            for (int aux = naixement; aux < any; aux = aux + 1){
                if (aux == naixement){
                System.out.println("El " + naixement + " va néixer");
                } else {
                     for (int num = 1; num >= edat; num = num + 1){
                         if (num < edat){
                            System.out.println("El " + naixement + "tenia "+ num + "anys");
                         } else {
                            System.out.print(num + "any");
                         }
                    }     
                }
            }
    }
}
