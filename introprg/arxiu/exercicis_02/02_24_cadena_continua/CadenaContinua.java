// Utilitzant funcio esEnter, demana un text i un numero, i retorna el número de carácters repetint la paraula fins que calgui

public class CadenaContinua{
    public static void main(String [] args){
    
        System.out.println("Text?");
        String text = Entrada.readLine();
        boolean valid = true;
        
        if(text.isEmpty()){
            valid = false;
        } else {
            
            System.out.println("Nombre?");
            String longitud = Entrada.readLine();
        
            valid = UtilString.esEnter(longitud);
                    
            if (valid){
                int numero = Integer.parseInt(longitud);
                String resultant = UtilString.cadenaContinua(text, numero);
                System.out.println(resultant); 
            }
            
        }
        if (!valid) {
            System.out.println("error"); 
        }
    }
}
    
    
