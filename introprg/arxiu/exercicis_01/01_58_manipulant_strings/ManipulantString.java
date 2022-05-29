 //* Revisant documentació
 
 public class ManipulantString{
    public static void main(String [] args){
        
        String sin ="";
        System.out.println("Paraula?");
        String paraula = Entrada.readLine();

        
        //Imprimir la segona lletra
        System.out.println("La segona lletra de la paraula és " + paraula.charAt(1)); 

        //Print longitud
        System.out.println("La longitud de la paraula és " + paraula.length());

        //Print ultima lletra
        int p = paraula.length();
        System.out.println("La darrera lletra de la paraula és " + paraula.charAt(p - 1));
        
        //Print penultima
        System.out.println("La penúltima lletra de la paraula és " + paraula.charAt(p - 2));

        //Print en may
        System.out.println("La paraula amb totes les lletres en majúscules és " + paraula.toUpperCase());

        //Moure una lletra al inici
        for(int i = 0; i < p; i++){
           if(!(i == 3)){
                sin += paraula.charAt(i); 
           }
        }
        System.out.println("La paraula amb la quarta lletra moguda a l’inici " + paraula.charAt(3) + sin);


        System.out.print("La paraula amb les primeres tres lletres en majúscules i la resta en minúscules és ");

        //Imprimir les tres primeres lletres en may
        for(int text=0; text<=2; text++){ 
            String lletra = String.valueOf(paraula.charAt(text));
            System.out.print(lletra.toUpperCase());
        }
    
        //Imprimir la resta de lletres en minuscula     
        for(int resta=3; resta<p; resta++){ 
            System.out.print(paraula.charAt(resta));
        }
       
    }
}
