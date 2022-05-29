// Programa numero demanat y quants numeros entre comes amb Array

public class EntersEntreComes {

    public static void main(String [] args){
        
        System.out.println("Quants?");
        int quantitat = Integer.parseInt(Entrada.readLine());
        
        if(quantitat < 0){
            System.out.println("Res a fer");
            return;
        }
        
        int[] numeros;
        numeros = new int[quantitat + 1];
        for(int i = 1; i < quantitat + 1; i++){  //Demana els valors
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
