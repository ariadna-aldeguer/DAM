// Programa que valida matricules amb mòduls

public class MatriculaValida {
    
    private static final String LLETRES_INVALIDES = "ÀIOQU"; 
    
    public static void main(String [] args){
    
        System.out.println("Introduïu una matrícula");
        String matricula = Entrada.readLine();
        boolean obtingut = false;
        
        if(matricula.isBlank()){return;}
        
        if (matricula.length() == 7){
            obtingut = true;
            for(int i = 0; i < matricula.length(); i++){
                if(i >= 0 && i <= 1 || 5 <= i && i <= 6){
                    obtingut = esLletraValidaPerMatriculaItaliana(matricula.charAt(i));
                    if(!obtingut){break;}
                } else {
                     if(!Character.isDigit(matricula.charAt(i))){

                        obtingut= false;
                        break;
                    }
                }
            }
        }
           
        if(!obtingut){
            System.out.println("No és una matrícula italiana vàlida");
        } else {
            System.out.println("És una matrícula italiana vàlida");
        }
    }    
    public static boolean esLletraValidaPerMatriculaItaliana(char lletra){
    

        if(lletra < 'A' || lletra > 'Z'){
            return false;
       }
        
        if(!Character.isLetter(lletra) || !Character.isUpperCase(lletra)){
            return false;
        }
        for(int a = 0; a < LLETRES_INVALIDES.length(); a++){
            if(lletra == LLETRES_INVALIDES.charAt(a)){
                return false;
            }   
        }
        return true;
    }
} 
