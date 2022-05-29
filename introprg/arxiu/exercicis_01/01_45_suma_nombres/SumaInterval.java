//* Programa que suma tots els valors demanats entre dos valors

public class SumaInterval{
    public static void main(String [] args){
            
            System.out.println("inici?");
            int inici = Integer.parseInt(Entrada.readLine());
            System.out.println("final?");
            int fin = Integer.parseInt(Entrada.readLine());
            int suma = 0; 
            
            if(inici < fin){
            
                for(int num = inici; num <= fin; num = num + 1){
                    suma = suma + num;
                }
               
            } else if(inici > fin){
                
                for(int num = fin; num <= inici; num = num + 1){
                    suma = suma + num;
                }
                    
           } else if(inici == fin){
           
                suma = inici;   
            }
            System.out.println(suma);
    }
}
