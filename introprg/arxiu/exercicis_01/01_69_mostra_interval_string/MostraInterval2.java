//* Programa que demana un interval y un text y retorna les lletres.

public class MostraInterval{
    public static void main(String [] args){
        
        System.out.println("text?");
        String text = Entrada.readLine();
        System.out.println("inici?");
        int num1 = Integer.parseInt(Entrada.readLine());
        System.out.println("final?");
        int num2 = Integer.parseInt(Entrada.readLine());
        
        int aux = text.length()-1;
        
        
        if(num1 <= num2){
            if(num2 > aux){
                num2 = aux;
            } 
            if(num1 < 0){
                num1 = 0;
            }
        for(int num = num1; num <= num2; num++){
              System.out.println(text.charAt(num));
        }
 
       
        } else if(num1 > num2){
            
            if(!(num1 < 0 && num2 < 0)){
                if(num2 < 0){
                    num2 = 0;
                }
                for(int num = num1; num >= num2; num--){
                    if(num <= aux){
                        System.out.println(text.charAt(num));
                    }
                }
            }
        }
    }
}
