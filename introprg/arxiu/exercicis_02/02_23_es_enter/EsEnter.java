//* Funció que comprova si es enter un número

public class EsEnter{
    public static void main(String [] args){
        
        System.out.println("Introdueix texts (enter sol per finalitzar)");
        String text = Entrada.readLine();
        
        while(!text.isEmpty()) {
            text = text.strip();  //Treure els espais en blanc
            boolean valid = UtilString.esEnter(text);
            
            if(valid){
                System.out.println("És enter");
            } else {
                System.out.println("No és enter");
            }
            text = Entrada.readLine();
        }
        System.out.println("Adéu"); 
    
    }
}
