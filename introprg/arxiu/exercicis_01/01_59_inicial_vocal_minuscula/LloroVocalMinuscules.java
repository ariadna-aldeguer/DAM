//* Programa que repeteix paraules que comencen per vocals

public class LloroVocalMinuscules{
    public static void main(String [] args){
        
        String paraula = "hola";  
        char lletra;
        
        while (!(paraula.isBlank())){
            System.out.println("El lloro pregunta paraula que comenci amb vocal en minúscules");
            paraula = Entrada.readLine();       
                if(!(paraula.isBlank())){
                lletra = paraula.charAt(0);
                    if (lletra == 'a'|| lletra == 'e' || lletra == 'i'|| lletra == 'o'|| lletra == 'u'){
                    System.out.println("El lloro diu: " + paraula);
                    }
                }
        }
        System.out.println("Adéu");
   }
}
            
