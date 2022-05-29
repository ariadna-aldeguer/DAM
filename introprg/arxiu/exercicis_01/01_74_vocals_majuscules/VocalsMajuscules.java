//* Programa que demana un text i retorna les vocals amb Majúscules.

public class VocalsMajuscules{
    public static void main(String [] args){
        
        String vocals = "aeiou";     
        boolean conteVocal = false;
        
        System.out.println("Text?");
        String text = Entrada.readLine();
        String textAux = text.toLowerCase();
        
        for(int i = 0; i < textAux.length(); i++){
            conteVocal = false;
            for(int n = 0; n < vocals.length(); n++){
                
                if(textAux.charAt(i) == vocals.charAt(n)){
                    System.out.print(Character.toUpperCase(text.charAt(i)));
                    conteVocal = true;
                    break;
                }
            }
            if(!conteVocal){
            System.out.print(Character.toLowerCase(text.charAt(i)));
            }
       }
       System.out.println();
   }
}
        
       
                
