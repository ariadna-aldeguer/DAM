/*
 * Programa que llegeix de un fitxer
 * i retorna les paraules que comencen/acaben
 * per vocal
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FitxerVocalIniciFi {
    public static void main(String[] args) throws IOException {
        
        String cami = "frases.txt";
        FileReader fileReader = new FileReader(cami);
        BufferedReader input = new BufferedReader(fileReader);
        String linia;
        while (true) {
            linia = input.readLine();
            
            if (null == linia) break;
            if (!linia.isBlank()){
               
                boolean ultimaConteVocal = false;
                
                // Comprova primera lletra
                boolean primeraConteVocal = UtilString.esVocal(linia.charAt(0));
                
                // Si la primera lletra no té vocal
                     if (!primeraConteVocal){ 
                        if (linia.length()-1 < 0){  //Si només te una lletra
                            ultimaConteVocal = UtilString.esVocal(linia.charAt(0));  // Comprova la ultima lletra
                        } else {    // Última lletra
                           ultimaConteVocal = UtilString.esVocal(linia.charAt(linia.length()-1));
                        }
                    } 
                    if (primeraConteVocal || ultimaConteVocal){ // Si alguna de les dues ha passat les proves
                    System.out.println(linia); 
                    } 
            }    
       }
       input.close();
   }
}         
