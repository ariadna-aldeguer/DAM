//* Programa que retorna una taula de multiplicar
public class TaulaMultiplicar{
    public static void main(String[] args){
    
    int result = 0;
    int primerX = Integer.parseInt(args[0]);
    int segonX = Integer.parseInt(args[1]);
    int primerM = Integer.parseInt(args[2]); 
    int segonM = Integer.parseInt(args[3]); 
    
      
         
         for(int fila = primerX; fila <= segonX; fila++){ //Agafa el primer operant i va sumant-lo fins q (0)
                                                          //arriba al últim operant (1)
            for(int num = primerM; num <= segonM; num++){ //Aixó agafa el primer múltiplicant (2) i suma fins arribar a l'últim (3)
                 
                if(num == primerM){ //* Només si ho fa si es el primer multiplicant (2)
                result = fila*primerM;
                System.out.println(fila + " x " + num + " = "+result); 
                } else if(num == segonM) { //* Només si ho fa si es el segon multiplicant (3)
                result = fila*segonM;
                System.out.println(fila + " x " + num + " = "+result); 
                }
            }
         }       
   } 
}  
