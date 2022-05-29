//* Programa que demana text i retorna la primera lletra de cada paraula en majúscula.

public class MajusculitzaInicials{
    public static void main (String [] args){
            
        System.out.println("Text?");
        String text = Entrada.readLine(); 
        
        if(text.isBlank()){return;}
        
        majusculitzaInicials(text);
    }
    public static void majusculitzaInicials(String text){
        
        boolean primeraLletra = true;
        
        for(int i = 0; i < text.length(); i++){
            
               if(!Character.isLetter(text.charAt(i)) && !Character.isDigit(text.charAt(i))){
                    primeraLletra = true;               
                    System.out.print(text.charAt(i));
               } else if (primeraLletra) {
                    System.out.print(Character.toUpperCase(text.charAt(i))); 
                    primeraLletra = false;
               } else {
                    System.out.print(Character.toLowerCase(text.charAt(i)));   
               }
         }
         System.out.println();
    }
}
