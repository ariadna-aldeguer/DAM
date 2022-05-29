//* Programa que valida matricules amb el error detallat

public class MatriculaValida {
    public static void main(String [] args){
    
        System.out.println("Introduïu una matrícula");
        String matricula = Entrada.readLine();
        
        char comprobant;
        int num = matricula.length();
        boolean valid = true;
        
        String StringAux = "No és una matrícula italiana vàlida|";
        
        if (num < 7){
            System.out.println("No és una matrícula italiana vàlida: massa curta");
            valid = false;
        } else if (num > 7){
            System.out.println("No és una matrícula italiana vàlida: massa llarga");
            valid = false;
        } else {
            for(int posicio = 0; posicio < 7; posicio++){ 
                comprobant = matricula.charAt(posicio); 
                if(posicio < 2 || (posicio >= 5 && posicio < 7)){// - De la posició 1 a la 2, després posició 5 a la 7
                    if(!Character.isLetter(comprobant)){
                        StringAux += comprobant + ": Ha de ser una lletra|";
                         valid = false;  
                    } else if(!Character.isUpperCase(comprobant)){
                        StringAux += comprobant + ": Ha de ser un majúscula|";
                         valid = false;
                    } else if((comprobant == 'I' || comprobant == 'O' || comprobant == 'Q' || 
                    comprobant == 'U' || comprobant == 'Ç' || comprobant == 'À' || comprobant == 'Ñ' || comprobant == 'ß')){
                          StringAux += comprobant + ": No és una lletra vàlida|";
                          valid = false;
                    }
               } else if (posicio >= 2 && posicio < 5 && (!(Character.isDigit(comprobant)))){
                        valid = false;
                        StringAux += comprobant + ": Ha de ser un dígit|";
               } else {
                        StringAux += comprobant + ": Correcte|";
                    } 
                }            
           if (!valid){
                String[] parts = StringAux.split("\\|");
                for(int num2 = 0; num2 <= 7; num2++){             
                    System.out.println(parts[num2]);
                }
           } else {
                System.out.println("És una matrícula italiana vàlida");
           }
        } 
           
               
    }
}
           

            
