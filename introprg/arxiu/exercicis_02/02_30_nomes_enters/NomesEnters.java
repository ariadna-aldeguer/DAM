// Analitza els arguments que pasan per la linea de comandes. Si son números o no. 

public class SumaEnters{    
    public static void main(String[] args){
    
        if(args.length > 0) {   //Sempre que hi hagi arguments
        
        
            //Filtra los numeros de la entrada
            int[] llistaNumeros = UtilString.filtraEnters(args);

            //Cuenta cuantos numeros hay en la lista
            int quantsEnters = UtilString.quantsEnters(args);
            
            //Suma los numeros
            int sumaEnters = UtilString.sumaEnters(llistaNumeros, quantsEnters);
            
            
        }
    
    
    }
}   
