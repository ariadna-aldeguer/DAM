// Suma de numeros de l'entrada. Filtra els numeros del text. 

public class SumaEnters{    
    public static void main(String[] args){
    
        if(args.length >= 0) {   //Sempre que hi hagi arguments
        
        
            //Filtra los numeros de la entrada
            int[] llistaNumeros = filtraEnters(args);

            //Cuenta cuantos numeros hay en la lista
            int quantsEnters = quantsEnters(args);
            
            //Suma los numeros
            int sumaEnters = sumaEnters(llistaNumeros);
            
            System.out.println(sumaEnters);
            
        }
    }
    public static int[] filtraEnters(String[] entrada){ 
        
        int quantsEnters = quantsEnters(entrada);
                
        int[] llistaNumeros = new int[quantsEnters];
        int j = 0;

        for(int i = 0; i < entrada.length; i++){
            boolean valid = UtilString.esEnter(entrada[i]);
            if(valid){
                int numero = Integer.parseInt(entrada[i]);
                llistaNumeros[j] = numero;  
                j++;
            }
        }
        return llistaNumeros;    
    }   
   
    public static int quantsEnters(String[] llistaNumeros){
       
       int quantsEnters = 0; 
        
       for(int i = 0; i < llistaNumeros.length; i++){
            boolean valid = UtilString.esEnter(llistaNumeros[i]);
            if(valid){
                quantsEnters += 1; 
            }
        }
        return quantsEnters;     
    }
    public static int sumaEnters(int[] llistaNumeros){
        
        int sumaEnters = 0;
        
        for(int i = 0; i < llistaNumeros.length; i++){
            sumaEnters += llistaNumeros[i];
        }
        return sumaEnters;
    
    }
}   
