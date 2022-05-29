//* Informe d'un text.

public class InformeText{
    public static void main(String [] args){
        
        System.out.println("Text?");
        String text = Entrada.readLine();
        String vocals = "aeiouàéèíïóòúü"; 
        String vocalsMay = vocals.toUpperCase();
        int sumaNum = 0;
        int sumaLletres = 0;
        int sumaMin = 0;
        int sumaMay = 0;
        int sumaVocals = 0;
        int sumaVocalsMin = 0;
        int sumaVocalsMay = 0;
        int sumaAltres = 0;
        int sumaTotal = 0;
        
        if(!text.isBlank()){       
            for(int i = 0; i < text.length(); i++){
            
                if(Character.isDigit(text.charAt(i))){
                    sumaNum++;
                    sumaTotal++;
                    continue;
                } 
                else if(Character.isLetter(text.charAt(i))){
                    sumaLletres++;
                    sumaTotal++;
                    
                    if(Character.isUpperCase(text.charAt(i))){
                        sumaMay++;
                    } else {
                        sumaMin++;
                    }
                                    
                    for(int n = 0; n < vocals.length(); n++){
                    
                        if(text.charAt(i) == vocals.charAt(n)){
                            sumaVocalsMin++;
                            sumaVocals++;
                            continue;
                        } else if (text.charAt(i) == vocalsMay.charAt(n)){
                            sumaVocalsMay++;
                            sumaVocals++;
                            continue;
                        }    
                    }
              } else {
                sumaAltres++;
                sumaTotal++;
              }
            }      
            System.out.println("Informe");
            System.out.println("=======");
            System.out.printf("lletres en majúscules: %d (%.2f%%)%n", sumaMay, 100.0 * sumaMay/sumaTotal);
            System.out.printf("lletres en minúscules: %d (%.2f%%)%n", sumaMin, 100.0 * sumaMin/sumaTotal);
            System.out.printf("total lletres: %d (%.2f%%)%n", sumaLletres, 100.0 * sumaLletres/sumaTotal);
            System.out.printf("vocals en majúscules: %d (%.2f%%)%n", sumaVocalsMay, 100.0 * sumaVocalsMay/sumaTotal);
            System.out.printf("vocals en minúscules: %d (%.2f%%)%n", sumaVocalsMin, 100.0 * sumaVocalsMin/sumaTotal);
            System.out.printf("total vocals: %d (%.2f%%)%n", sumaVocals, 100.0 * sumaVocals/sumaTotal);
            System.out.printf("digits: %d (%.2f%%)%n", sumaNum, 100.0 * sumaNum/sumaTotal);
            System.out.printf("altres caràcters: %d (%.2f%%)%n", sumaAltres, 100.0 * sumaAltres/sumaTotal);
            System.out.printf("total caràcters: %d%n", sumaTotal);
       } else {
        System.out.println("Cadena buida");
       }        
   }
}
       
