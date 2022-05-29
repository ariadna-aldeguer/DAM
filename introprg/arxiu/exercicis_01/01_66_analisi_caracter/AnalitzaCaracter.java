//*Programa que demana un text i una posicio i retorna la lletra, numero o simbol i diu que es. 
public class AnalitzaCaracter{
    public static void main(String [] args){
        
        System.out.println("Text?");
        String text = Entrada.readLine();
        System.out.println("Posició?");
        int posicio = Integer.parseInt(Entrada.readLine());
        int num = text.length();
        char lletra;
        boolean valid = true;

            if(posicio > 0){
                if(posicio >= num){
                valid = false;
                } else {
                    lletra = text.charAt(posicio);
                    System.out.print("'" + lletra + "' "); 
                    if (Character.isLetter(lletra)){
                        System.out.println("és una lletra");
                    } else if (Character.isDigit(lletra)){
                        System.out.print("és un nombre");
                    } else {
                        System.out.print("és una altra cosa");
                    }
                }
             } else if (posicio < 0){
                   if ((num + posicio) >= num || (num + posicio) < 0 ){
                      valid = false;
                    } else {
                        lletra = text.charAt(num + posicio);
                        System.out.print("'" + lletra + "' ");
                        if (Character.isLetter(lletra)){
                             System.out.println("és una lletra");
                        } else if (Character.isDigit(lletra)){
                            System.out.print("és un nombre");
                        } else {
                            System.out.print("és una altra cosa");
                        }
                    }
              }  
              if (valid == false){
                    System.out.println("Fora de rang");     
              }   
     }
}


