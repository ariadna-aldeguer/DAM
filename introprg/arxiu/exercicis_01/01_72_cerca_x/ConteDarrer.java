//* Programa que demana un text i agafa la ultima lletra d'aquests, el següent text ha de contenirla o s'acaba.

public class ConteDarrer{
    public static void main(String [] args){
        
        System.out.println("Introdueix texts (enter sol per finalitzar)");
        String text = Entrada.readLine();

        if(!text.isBlank()){
            System.out.println("bé");
            char lletra = Character.toUpperCase(text.charAt(text.length()-1));
            
            while(true){
                
                text = Entrada.readLine(); //*Pide el texto

                if(text.isBlank()){
                    System.out.println("Adéu");
                    return;
                }
                else {
                
                
                    for(int i = 0; i < text.length(); i++){
                        if(lletra == Character.toUpperCase(text.charAt(i))){
                            lletra = Character.toUpperCase(text.charAt(text.length()-1));
                         System.out.println("bé");   
                            break;
                        }
                    if(i == text.length()-1){
                        System.out.println("Adéu");
                        return;
                        }
                            
                    }
               }     
           }     
       } else {
           System.out.println("Adéu");  
       }                
   }
}   

            
