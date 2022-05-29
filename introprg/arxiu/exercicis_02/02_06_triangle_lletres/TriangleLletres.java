//* Programa que demana un text i retorna un triangle amb el text

public class TriangleLletres{
    public static void main(String [] args){
    
        System.out.println("Text?");
        String text = Entrada.readLine();
        
        if (text.isBlank()){return;}
        
        dibuixaTriangle(text);
    }    
        
    public static void dibuixaTriangle(String text){
    
         for(int linia = 0; linia < text.length(); linia++){
            dibuixaLinia(text, linia);
            System.out.println();
         }      
    }
    public static void dibuixaLinia(String text, int linia){
    
        for(int a = 0; a <= linia ; a++){
            if(a == 0){
                System.out.print(text.charAt(a));
            } else {
                System.out.print(", " + text.charAt(a));
            }
        }
   }
}   
