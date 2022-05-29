// Función Numeros entre comas
// Pide la longitud de la lista, los valores y el separador.

public class EntersEntreComes {

    public static void main(String [] args){
    
        String aux;
        //Demana la quantitat. 
        
        System.out.println("Quants?");
        String text = Entrada.readLine();
        int quantitat = numValid(text);
        if (quantitat < 0){
            System.out.println("Res a fer"); return;
        }

        
        // Demana el separador
        
        System.out.println("Separador?");   
        String separador = Entrada.readLine(); 
        if(separador.isEmpty()){
            separador = ",";
        } 
        char caracter = separador.charAt(0);


        // Demana els valors
        
        int[] numeros;
        numeros = new int[quantitat];
        for(int i = 0; i < quantitat; i++){  
            System.out.println("Valor "+ (i+1) + "?");
            aux = Entrada.readLine(); 
            int num = numValid(aux);        //verifica que sigui un numero
            numeros[i] = num; 
           
        }
        
        //Escriu els números
        String resposta = UtilString.entreComes(numeros, caracter);
        System.out.println(resposta);
        System.out.println();
            
    }
    public static int numValid(String text){
    
         boolean numValid = false;
           
         while(!numValid){  //Mentres no sigui numero, va demanant. 

        
            numValid = UtilString.esEnter(text);
        
            if(!numValid){
                System.out.println("Per favor, un valor enter");
                text = Entrada.readLine();
            }
         }
         int numeroEnter = Integer.parseInt(text);
         
         return numeroEnter;
    }
}
