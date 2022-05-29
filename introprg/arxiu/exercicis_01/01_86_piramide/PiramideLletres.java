//* Programa que demana un text i retorna un triangle amb el text i  amb punts

public class PiramideLletres{
    public static void main(String [] args){
           
        System.out.println("Text?");
        String text = Entrada.readLine();
        
        if(!text.isBlank()){    
            for(int fila = text.length()-1; fila >= 0 ; fila--){
                
                for(int i = text.length()+1; i - fila*2 <= text.length() ; i++){ //Punts esquerra
                     System.out.print(".");
                }

                for(int a = 0; a <= text.length()-1 - fila; a++){
                        if( ((text.length()-1) - fila) == a){
                            System.out.print(text.charAt(a));
                        } else {
                            System.out.print(text.charAt(a)+".");
                        }
                }
                 System.out.print("-"); 
                for(int a = text.length()-1 - fila; a >= 0; a--){
                        if( a > 0){
                            System.out.print(text.charAt(a)+".");
                        } else {
                            System.out.print(text.charAt(a));
                        }      
                }
                for(int i = text.length()+1; i - fila*2 <= text.length() ; i++){ //Punts dreta
                     System.out.print(".");
                }
         
           System.out.println();     
           }
       }
    }   
}

//* "["+a+"]" System.out.print( "[A:"+a+"]" + "[F"+fila+"]"+ "[T"+ ((text.length()-1) - fila) +"]");
