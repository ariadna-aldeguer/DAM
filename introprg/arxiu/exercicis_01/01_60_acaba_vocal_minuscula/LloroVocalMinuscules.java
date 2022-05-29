//* Programa que repeteix paraules que acaben per vocals en minuscules

public class LloroVocalMinuscules{
    public static void main(String [] args){
        
        String paraula = "hola";  
        
        while (!(paraula.isBlank())){
            System.out.println("El lloro pregunta paraula que finalitzi per vocal en minúscules");
            paraula = Entrada.readLine();
            if(!(paraula.isBlank())){
                int fin = paraula.length();
                char lletra = paraula.charAt(fin - 1);
                if (lletra == 'a'|| lletra == 'e' || lletra == 'i'|| lletra == 'o'|| lletra == 'u'){
                    System.out.println("El lloro diu: " + paraula);
                }
           }
        }
        System.out.println("Adéu");
   }
}
