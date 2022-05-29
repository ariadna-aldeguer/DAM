//**Programa que demana el nom, edat i any actual i retorna la edat als anys. 

public class HistoricEdats{
    public static void main(String [] args){
            
            System.out.println("nom?");
            String nom = Entrada.readLine();
            System.out.println("edat?");
            int edat = Integer.parseInt(Entrada.readLine());
            System.out.println("any actual?");
            int any = Integer.parseInt(Entrada.readLine());
            int num = 0;
            
            int naixement = any - edat;
         
            if (edat > 0 && !nom.isEmpty() && any >= 1971){       
                System.out.println("El " + naixement + " va néixer");    
                for (int aux = naixement + 1; aux < any; aux = aux + 1){
                num = num + 1;
                    if (num == 1){
                    System.out.println("El " + aux + " tenia 1 any" );
                    } else {
                    System.out.println("El " + aux + " tenia " + num + " anys" );
                    }    
                } 
                System.out.println("Adéu "+ nom);
            } else if (edat < 0 || nom.isEmpty() || any < 1971){
               System.out.println("Entrada errònia");    
            } else {
                System.out.println("Adéu "+ nom);    
            }    
    }
}
               
           
