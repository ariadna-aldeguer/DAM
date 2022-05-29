// Programa numero demanat entre comes amb Array

public class EntersEntreComes {

    public static void main(String [] args){
        
        int[] numeros;
        numeros = new int[6];
        for(int i = 1; i < 6; i++){  //Demana els valors
            System.out.println("Valor "+ i + "?");
            int num = Integer.parseInt(Entrada.readLine());
            numeros[i] = num; 
           
        }
        System.out.print(numeros[1]);
        for (int i = 2; i < numeros.length; i++) { //Print els valors entre comes
            System.out.print(", " + numeros[i]);
        }
        System.out.println();
    }
}
