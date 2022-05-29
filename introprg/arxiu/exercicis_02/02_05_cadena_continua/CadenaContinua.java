//*Programa que demana un text i un numero, i retorna el número de carácters repetint la paraula fins que calgui

public class CadenaContinua{
    public static void main(String [] args){
    
    System.out.println("Text?");
    String text = Entrada.readLine();
    
    if(text.isBlank()){
        System.out.println("error");
        return;
    }
    System.out.println("Nombre?");
    int longitud = Integer.parseInt(Entrada.readLine());
    mostraCadenaContinua(text, longitud);
    }
    
    public static void mostraCadenaContinua(String text, int longitud) {
        
        
        if(longitud < text.length()){ //La entrada es més petita que la llargada de la paraula
            for(int i = 0; i < longitud; i++){
                System.out.print(text.charAt(i));
            } 
        } else {
            if (longitud%text.length() == 0){ 
                for(int a = 1; a <= longitud/text.length(); a++){
                    for(int i = 0; i < text.length(); i++){
                        System.out.print(text.charAt(i)); //Printa la lletra
                    }
                }
            } else {
                for(int a = 1; a <= longitud/text.length(); a++){
                    for(int i = 0; i < text.length(); i++){
                            System.out.print(text.charAt(i)); //Printa la lletra
                        }  
                }
                for(int i = 0; i < longitud%text.length(); i++){
                        System.out.print(text.charAt(i)); //Printa la lletra
                }
            }
        }
    }
}    
    
         
        
