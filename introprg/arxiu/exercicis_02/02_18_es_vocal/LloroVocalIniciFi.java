// Programa que repeteix la paraula si comença o acaba per vocal
// Funció que comprova si hi ha vocals
// Funció de comprovació de la confirmació

public class LloroVocalIniciFi {
    
    public static void main (String [] args) {
    
        System.out.println("El lloro demana paraula amb vocal a l'inici o/i final");
        
        while(true){
        
            String paraula = Entrada.readLine();

            if (paraula.isBlank()){ //Si esta en blanc
                System.out.println("El lloro demana confirmació per finalitzar");
                String resposta = Entrada.readLine();
                boolean confirma = UtilitatsConfirmacio.respostaABoolean(resposta); //Confirmació
                if (confirma){  
                    System.out.println("Adéu");
                    return;
                } else {
                    System.out.println("El lloro demana paraula amb vocal a l'inici o/i final"); //Demana valor
                }
            } else {  //Si te text 
                boolean ultimaConteVocal = false;
                boolean primeraConteVocal = UtilString.esVocal(paraula.charAt(0)); //Comprova primera lletra
                if (!primeraConteVocal){  // Si la primera lletra no té vocal
                    if (paraula.length()-1 < 0){  //Si només te una lletra
                           ultimaConteVocal = UtilString.esVocal(paraula.charAt(0));
                        } else {    // Última lletra
                           ultimaConteVocal = UtilString.esVocal(paraula.charAt(paraula.length()-1));
                        }
                } 
                if (primeraConteVocal || ultimaConteVocal){ // Si alguna de les dues ha passat les proves
                    System.out.println("El lloro diu: " + paraula); //Repeteix la paraula
                }
               System.out.println("El lloro demana paraula amb vocal a l'inici o/i final"); //Demana un altre paraula.
            }
        }
    }
}   
            
            
            
            
                
            
