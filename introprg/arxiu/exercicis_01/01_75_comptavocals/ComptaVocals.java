//* Programa que demana un text i compta les vocals

public class ComptaVocals{
    public static void main(String [] args){
        
        String vocals = "aeiouáàéèíïóòúü";     
        int suma = 0;
        
        System.out.println("Text?");
        String text = Entrada.readLine();
        String textAux = text.toLowerCase();
        
        for(int i = 0; i < textAux.length(); i++){
        
            for(int n = 0; n < vocals.length(); n++){
                
                if(textAux.charAt(i) == vocals.charAt(n)){
                    suma++;
                    break;
                }
            }
       }
       System.out.println(suma);
   }
}
