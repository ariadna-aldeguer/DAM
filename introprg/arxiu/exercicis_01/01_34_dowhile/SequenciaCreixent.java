//*Programa que demana numeros creixents i s'atura en el moment en el que el número es més petit

public class SequenciaCreixent{
    public static void main(String [] args){
        
       int tmp = 0;
       int max = 0;
       int sec = -1; //*Possible solució 
       
       do {
           tmp = max;
           System.out.println("Introdueix un valor");
           max = Integer.parseInt(Entrada.readLine());
           sec = sec + 1;
       } while (max > tmp);
       System.out.println("Longitud de la següència creixent: " + sec); //*Possible solució: posar sec -1
   }
}
      
       
