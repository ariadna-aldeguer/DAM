//* Programa que compara la segona y la penultima lletra

public class SegonaIgualPenultima{
    public static void main(String [] args){
        
        System.out.println("Ves introduïnt texts (finalitza amb enter sol)");
        String paraula = Entrada.readLine();
        

        
            while (!(paraula.isBlank())){
                
                int num = paraula.length();
                if(num == 1){
                    System.out.println("Segona diferent de penúltima");
                    paraula = Entrada.readLine();
                } else if (!(num==0)){
               
                    char segona = paraula.charAt(1);
                    char penultima = paraula.charAt(num - 2);
                    
                    if(segona == penultima){
                        System.out.println("Segona igual a penúltima");
                    } else if(!(segona == penultima)){
                    
                        System.out.println("Segona diferent de penúltima");
                    }
                    paraula = Entrada.readLine();
               }
           }
        System.out.println("Adéu");
        
   }
}
