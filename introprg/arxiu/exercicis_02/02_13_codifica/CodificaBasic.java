// Programa que demana un text i el codifica 
// movent la lletra amb el número que es demana. 
// Procediment codifica

public class CodificaBasic{
    public static void main(String [] args){
    
        System.out.println("Text?");
        String text = Entrada.readLine();
        System.out.println("Quants?");
        int quants = Integer.parseInt(Entrada.readLine());
        
        if(quants < 0){
            System.out.println("No s'accepten números negatius");
            return;
        }
        
        codifica(text, quants);
    }
    public static void codifica(String text, int quants){
    
        String vocals = "àéèíïóòúüá"; 
        boolean accents = false;
        char aux;
        
        for(int i = 0; i < text.length(); i++){  
            accents = false;
            if(Character.isLowerCase(text.charAt(i))){ //*minuscula
            
                for(int a = 0; a < vocals.length(); a++){ //Busca si te accents
                    
                    if(text.charAt(i) == vocals.charAt(a)){ //si te accents, printa
                        System.out.print(text.charAt(i));
                        accents = true;
                    } 
                } 
                if(!accents){              //sinò té accents               
                    aux = (char) (text.charAt(i) + quants);   //Suma del caracter amb la quantitat que s'ha de moure
                    if(aux > 122){ //Si es més gran que 'z'
                         System.out.print((char)(96+aux-122));   //Comença desde la a + la resta de tots els caracters
                    } else {
                        System.out.print(aux); //Sino printa el caracter
                    }
                }
            } else { 
                System.out.print(text.charAt(i));   //altre tipus de caracters
            }
       }
       System.out.println();
        
    }
}
