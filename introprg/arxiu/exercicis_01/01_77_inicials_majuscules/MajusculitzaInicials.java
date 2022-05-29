//* Programa que demana text i retorna la primera lletra de cada paraula en majúscula.

public class MajusculitzaInicials{
    public static void main (String [] args){

        boolean primeraLletra = true;
       
        System.out.println("Text?");
        String text = Entrada.readLine(); 
        
        for(int i = 0; i < text.length(); i++){

            if(primeraLletra){
                System.out.print(Character.toUpperCase(text.charAt(i)));
                primeraLletra = false;
            } else if(!Character.isLetter(text.charAt(i))){
                System.out.print(text.charAt(i));
                primeraLletra = true;
            } else {
                System.out.print(Character.toLowerCase(text.charAt(i)));
            }
	    }
	    System.out.println();
   }
}       
        
        
