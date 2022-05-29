//*Programa que demana un text i un numero, i retorna el número de carácters repetint la paraula fins que calgui

public class CadenaContinua{
    public static void main(String [] args){
        
        System.out.println("Text?");
        String text = Entrada.readLine();
        
        if(text.isBlank()){
            System.out.println("error");
        } else {
        
            System.out.println("Nombre?");
            int num = Integer.parseInt(Entrada.readLine());
            int largo = text.length();
            int aux, q;
            char letra;
        
            
            aux = num%largo;
            q = num/largo; 
            if(num < largo){
                for(int i = 0; i < num; i++){
                    letra = text.charAt(i);
                    System.out.print(letra);
                } 
            } else {
                                /*for(int i = 0; i < largo; i++){
                                    letra = text.charAt(i);
                                    System.out.print(letra);
                                }   */ 
                if (aux == 0){
                    q = num/largo;
                    for(int a = 1; a <= q; a++){
                        for(int i = 0; i < largo; i++){
                            letra = text.charAt(i);
                            System.out.print(letra);
                        }
                    }
                } else {
                    q = num/largo;
                    for(int a = 1; a <= q; a++){
                        for(int i = 0; i < largo; i++){
                                letra = text.charAt(i);
                                System.out.print(letra);
                            }  
                    }
                    for(int i = 0; i < aux; i++){
                            letra = text.charAt(i);
                            System.out.print(letra);
                    }
                }
            }   
        }        
    }
}    
               
            
