//* Programa que demana un text i retorna un triangle amb el text

public class TriangleLletres{
    public static void main(String [] args){
          
        System.out.println("Text?");
        String text = Entrada.readLine();
        
        if(!text.isBlank()){
        
            for(int i = 0; i < text.length(); i++){
                
                for(int a = 0; a <= i ; a++){
                
                    if(a == 0){
                    System.out.print(text.charAt(a));
                    } else {
                    System.out.print(", " + text.charAt(a));
                    }
                }
                System.out.println();
            }
        }
   }
}            
            
            
                
        
