// Analitza els arguments que pasan per la linea de comandes. Si son números o no. 

public class Arguments{    
    public static void main(String[] args){
    
        if(args.length == 0){
            System.out.println("Cap argument");
        } else {
        
            for(int i = 0; i < args.length; i++){
                
                boolean valid = UtilString.esEnter(args[i]);
                
                if(valid){
                    System.out.printf(
                    "[%d] \"%s\": és enter%n", i, args[i]); 
                } else {
                    System.out.printf(
                    "[%d] \"%s\": no és enter%n", i, args[i]); 
                }
            }   
        }
    }
}


