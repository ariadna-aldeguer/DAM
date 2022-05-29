/*
* Aquí podem comprovar si una cadena es o no un valor enter.
*/
public class UtilString {
    public static boolean esEnter(String text){
        int digit =0;

        for (int i = 0; i < text.length(); i++){
            char caracter = text.charAt(i);
            
            if (Character.isDigit(caracter)){
                digit=1;
            }else {
                digit = 0;
            }
            if (text.startsWith("-") || text.startsWith("+")){
                digit=1;
            }
            if (text.startsWith(" ")){
                return false;
            }
            if (Character.isLetter(caracter)){
                return false;
            }
        }
        if (digit==1){
            return true;
        }else {
            return false;
        }
    }
        public static boolean respostaABoolean(String resposta) {
        if (null == resposta) {     // si la resposta és null, la donem com a false
            return false;
        }
        resposta = resposta.toLowerCase();
        if (resposta.equals("s") || resposta.equals("y")) {
            return true;
        }
        if (resposta.equals("sí") || resposta.equals("yes")) {
            return true;
        }
        if (resposta.equals("si") || resposta.equals("vale") || resposta.equals("yeah")) {
            return true;
        }
        return false;
    }
}
