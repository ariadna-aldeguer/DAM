//* Programa que demana un text i retorna un triangle amb el text

public class TriangleLletresInvertit{
    public static void main(String [] args){
          

           
        System.out.println("Text?");
        String text = Entrada.readLine();
        
        for(int i = text.length()-1; i >= 0; i--){
                
                for(int a = i; a >= 0; a--){
                 
                    if(a == 0){
                    System.out.print(text.charAt(a));
                    } else {
                    System.out.print(text.charAt(a) + ", ");
                    }
                }
                System.out.println();
        }
   }
}                  
