// Recursivitat: demana un text y retorna només els números concatenats
public class ExtreuNombres {
    public static void main(String[] args){
        System.out.println("Text?");
        String text = Entrada.readLine();
        String nombres = extreuNombres(text);
        System.out.println(nombres);
    }

    // extreu els nombres i els retorna concatenats
    public static String extreuNombres(String text) {
        // cas base -- Quan estigui buit el text, s'acaba
        String lletres ="";
        if(text.isEmpty()){
            return "";
        }

        // tracta pas actual -- comprovar que es un digit.
        char primer = text.charAt(0);
        if(Character.isDigit(primer)){
            lletres = String.valueOf(primer);
        }  
            
        // tracta pas recursiu -- anar fent el text més petit. 
        String restaText = text.substring(1);
        String numerosRestaText = extreuNombres(restaText);

        // composa resultat 
        String resultant = lletres + numerosRestaText;
        return resultant;
    }
}
