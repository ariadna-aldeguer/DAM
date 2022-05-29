/*
 * Classe UsaGatRenat: Demana posicio
 */

public class UsaGatRenat{
    public static void main(String[] args){
        
        GatRenat renat = new GatRenat();
        
        System.out.print("Inicialment renat.estaViu(): " );
            esTrueOFalse(renat.estaViu());
        System.out.print("Inicialment renat.estaDret(): ");
            esTrueOFalse(renat.estaDret());
        System.out.print("Inicialment renat.estaAssegut(): ");
            esTrueOFalse(renat.estaAssegut());
        System.out.print("Inicialment renat.estaEstirat(): ");
            esTrueOFalse(renat.estaEstirat());
        
        System.out.println("Introdueix quantes vides:");
        String numVides = Entrada.readLine();
        if(esEnter(numVides)){
            int num = Integer.parseInt(String.valueOf(numVides));
            renat.setVides(num);
        }
                
        System.out.println("Introdueix nova posició:");
        String resposta = Entrada.readLine();
        renat.setPosicio(resposta);
        
        System.out.print("Finalment renat.estaViu(): " );
            esTrueOFalse(renat.estaViu());
        System.out.print("Finalment renat.estaDret(): ");
            esTrueOFalse(renat.estaDret());
        System.out.print("Finalment renat.estaAssegut(): ");
            esTrueOFalse(renat.estaAssegut());
        System.out.print("Finalment renat.estaEstirat(): ");
            esTrueOFalse(renat.estaEstirat());
    }    
    public static void esTrueOFalse(boolean tipus){
        if(tipus){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    public static boolean esEnter(String text){
        
        if(!text.isEmpty()){    
            if(text.charAt(0) == '-' || text.charAt(0) == '+'){
                for(int i = 1; i < text.length(); i++){
                         
                    if(!Character.isDigit(text.charAt(i))){
                        return false;
                    }
                }
                return true; 
            } else {
                for(int i = 0; i < text.length(); i++){
                         
                    if(!Character.isDigit(text.charAt(i))){
                        return false;
                    }
                }
                return true; 
           }
       } 
       return false;
   }       

}
