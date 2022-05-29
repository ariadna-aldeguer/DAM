//Programa que extreu un text amb els números donats

public class UtilString {

    public static String intervalString(String text, int inici, int fi){
    
        String aux = "";

        if (inici <= fi){
            if (fi > text.length()) { fi = text.length()-1; }
            if (inici < 0) { inici = 0;} 
            for(int i = inici; i <= fi; i++){
                aux += text.charAt(i);
            }
        } else {

            if (!(inici < 0 && fi < 0)) {
                if(fi < 0){
                    fi = 0;
                }
                for(int i = inici; i >= fi; i--){
                    if(i < text.length()){
                        aux += text.charAt(i);
                    }
                }
            }
       }
       return aux; 
   }
}
