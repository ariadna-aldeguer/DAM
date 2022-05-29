 //*  Programa que demana un interval y un text y retorna les lletres.

public class MostraInterval {
    public static void main(String[] args) {
        System.out.println("text?");
        String text = Entrada.readLine();
        System.out.println("inici?");
        int inici = Integer.parseInt(Entrada.readLine());
        System.out.println("final?");
        int fi = Integer.parseInt(Entrada.readLine());
        mostraInterval(text, inici, fi);
     }

     public static void mostraInterval(String text, int inici, int fi){
     
         
        if(inici <= fi){   // Inici mes petit que final - ordre normal
            if(fi > text.length()-1){   // Si el fi es mes gran que la longitud
                fi = text.length()-1;   //Canviar el fi per la longitud
            } 
            if(inici < 0){          // SI el inici es mes petit que 0
                inici = 0;          // Canviar per 0
            }
        for(int num = inici; num <= fi; num++){
              System.out.println(text.charAt(num));
        }
 
       
        } else { // Inici es mes gran que fi - Ordre al reves
            
            if(!(inici < 0 && fi < 0)){   // Si no son mes petits que cero ambos
                if(fi < 0){             
                    fi = 0;
                }
                for(int num = inici; num >= fi; num--){
                    if(num <= text.length()-1){
                        System.out.println(text.charAt(num));
                    }
                }
            }
        }
    } 
}        
   
