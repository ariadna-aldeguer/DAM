// Recursivitat: demana un text y suma els digits que conté.
public class SumaDigits {
    public static void main(String[] args){
        System.out.println("Text?");
        String text = Entrada.readLine();
        int nombres = sumaDigits(text);
        System.out.println(nombres);
    }

    // extreu els numeros i retorna la suma d'aquests. 
    public static int sumaDigits(String text) {
        // cas base
        if(text.isEmpty()){
            return 0;
        }
        int numero = 0;
        // tracta pas actual
        char primer = text.charAt(0);
        if(Character.isDigit(primer)){
            numero = Integer.parseInt(String.valueOf(primer));
        } else {
            numero = 0;
        }

        // tracta pas recursiu
        String restaText = text.substring(1);
        int restaNumeros = sumaDigits(restaText);

        // composa resultat
        int total = numero + restaNumeros;
        return total;
    }
}
