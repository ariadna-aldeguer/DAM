//*Programa que vol endevinar el número 42, identifica si es text, o el numero es mes gran o mes petit

public class Endevina{
    public static void main(String [] args){
           
        boolean digit = false;

        while(true){
        
            System.out.println("Nombre?");    
            String num = Entrada.readLine();
            if(num.isBlank()){
                   System.out.println("Cancel·lat!"); 
                   break;
            }            
            for(int i = 0; i < num.length(); i++){
            
                if(Character.isLetter(num.charAt(i))){
                    System.out.println("Només nombres");
                    break;
                }
                if(Character.isDigit(num.charAt(i))){
                digit = true; 
                }
            } 
            if(digit){
                int numAux = Integer.parseInt(num);
                digit = false;
                if(numAux <= 0 || numAux > 100){
                    System.out.println("Fora de rang");
                
                } else if(numAux >= 1 && numAux <= 41){
                    System.out.println("Massa petit");
                
                } else if (numAux >= 43 && numAux <= 100){
                    System.out.println("Massa gran");
                
                } else if (numAux == 42) { 
                       System.out.println("Encertat!");
                       break;
                }
           }     
        
        }   
   }
}   
        
        
            
           
        
       
      
