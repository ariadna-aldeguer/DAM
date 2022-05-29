// Programa que mostra quantes vocals té un text. 
// Procediment que mostra quantes vocals té
// Funció que conte cuantes vocals té
// Procediment comptaVocals

public class ComptaVocals {
    public static void main(String[] args) {
        System.out.println("Introdueix un text");
        String entrada = Entrada.readLine();
        comptaVocals(entrada);
    }
    public static void mostraOcurrencies(char lletra, int quantes) {
        System.out.println("Nombre de '" + lletra + "'s: " + quantes);
    }
    public static int quantesOcurrencies(String text, char lletra) {
        int comptador = 0;
        for (int i=0; i < text.length(); i++) {
            if (text.charAt(i) == lletra) {
                comptador += 1;
            }
        }
        return comptador;
    }
    public static void comptaVocals(String entrada){
    	String vocals = "aàeèéiíïoóòuúü";
	for(int i = 0; i < vocals.length(); i++){
	    int quantes = quantesOcurrencies(entrada, vocals.charAt(i));
	    mostraOcurrencies(vocals.charAt(i), quantes);
	}
    }			
}

