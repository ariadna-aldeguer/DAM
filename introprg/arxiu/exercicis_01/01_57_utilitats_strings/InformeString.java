//* Demana dos texts i un enter positiu i fa un petit informe amb les opcions que dona el Java

public class InformeString{
    public static void main(String [] args){
        
        System.out.println("Text principal?");
        String text = Entrada.readLine();
        System.out.println("Text secundari ?");
        String t = Entrada.readLine();
        System.out.println("Número positiu?");
        int num = Integer.parseInt(Entrada.readLine());
        
        
        System.out.println("\"" + text + "\"" + ".length(): " + text.length()); //*Longitud de la cadena
        System.out.println("\"" + text + "\"" + ".startsWith(\"" + t + "\"): " + text.startsWith(t)); //* Boolean que indica si la cadena comença per l’altre
        System.out.println("\"" + text + "\"" + ".endsWith(\"" + t + "\"): " + text.endsWith(t));
        System.out.println("\"" + text + "\"" + ".equals(\"" + t + "\"): " + text.equals(t));
        System.out.println("\"" + text + "\"" + ".equalsIgnoreCase(\"" + t + "\"): " + text.equalsIgnoreCase(t));
        System.out.println("\"" + text + "\"" + ".isBlank(): " + text.isBlank());
        System.out.println("\"" + text + "\"" + ".isEmpty(): " + text.isEmpty());
        System.out.println("\"" + text + "\"" + ".charAt(" + num + "): " + text.charAt(num));
        System.out.println("\"" + text + "\"" + ".concat(\"" + t + "\"): " + text.concat(t));
        System.out.println("\"" + text + "\"" + ".repeat(" + num + "): " + text.repeat(num));
        System.out.println("\"" + text + "\"" + ".toUpperCase(): " + text.toUpperCase());
        System.out.println("\"" + text + "\"" + ".toLowerCase(): " + text.toLowerCase());
    }
}   
 
