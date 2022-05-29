//* Programa que valida matricules

public class MatriculaValida {
    public static void main(String [] args){
    
        System.out.println("Introduïu una matrícula");
        String matricula = Entrada.readLine();
        
        char comprobant;
        int num = matricula.length();
        boolean valid = true;
        
        
        if (num != 7){
            System.out.println("No és una matrícula italiana vàlida");
        } else {
            for(int posicio = 0; posicio < 2; posicio++){
                comprobant = matricula.charAt(posicio);
                    if(!(Character.isLetter(comprobant) && Character.isUpperCase(comprobant))){
                        valid = false;
                    } else if(comprobant == 'I' || comprobant == 'O' || comprobant == 'Q' || comprobant == 'U' || comprobant == 'Ç' || comprobant == 'À' || comprobant == 'Ñ' || comprobant == 'ß'){
                        valid = false;
                    }
            } for(int posicio = 2; posicio < 5; posicio++){
                comprobant = matricula.charAt(posicio);
 
                    if((!(Character.isDigit(comprobant)))){
                        valid = false;
                    }
               
            } for(int posicio = 5; posicio < 7; posicio++){
                comprobant = matricula.charAt(posicio);
                    if(!(Character.isLetter(comprobant) && Character.isUpperCase(comprobant))){
                        valid = false;
                    } else if(comprobant == 'I' || comprobant == 'O' || comprobant == 'Q' || comprobant == 'U' || comprobant == 'Ç' || comprobant == 'À' || comprobant == 'Ñ' || comprobant == 'ß'){
                        valid = false;
                    }
           }
           if (!valid){
                System.out.println("No és una matrícula italiana vàlida");
           } else {
                System.out.println("És una matrícula italiana vàlida");
           }
       }        
    }
}
           

            
