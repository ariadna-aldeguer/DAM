//*Programa que pensa un numero i el usuari l'ha d'endevinar

public class Endevina{
    public static void main(String [] args){
        
        boolean encertat = false;
        
        System.out.println("Nombre?");
        String numAux = Entrada.readLine();
        
        while (!encertat) { //*Mentres sigui fals 
            if (numAux.isEmpty()){
                System.out.println("Cancel·lat!");
                break;
            } else {    
            int num = Integer.parseInt(numAux);
                 if (num >= 1 && num <= 41){
                    System.out.println("Massa petit"); //* Print massa petit entre 0 - 41
                    System.out.println("Nombre?");
                    numAux = Entrada.readLine(); 
                } else if (num >= 43 && num <= 100) {
                    System.out.println("Massa gran"); //* Print massa gran entre 43 - 100
                    System.out.println("Nombre?");
                    numAux = Entrada.readLine();
                } else if (num == 42) { 
                    encertat = true; //*Li dic que aixó es veritat
                    System.out.println("Encertat!");
                } else {
                    System.out.println("Fora de rang");  //*La resta esta fora de rang
                    System.out.println("Nombre?");
                    numAux = Entrada.readLine(); 
                }
           }
        }
   }
}
