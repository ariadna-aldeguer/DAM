//* Programa que fa un informe sobre una lletra

public class InformeCaracter{
    public static void main(String [] args){
    
    System.out.println("Caràcter?");
    String paraula = Entrada.readLine();
    
    
    
        if (paraula.isBlank()){
          
            System.out.println("Caràcter buit");
          
        } else {
            
            char lletra = paraula.charAt(0);
            //nom del caràcter
            System.out.println("Character.getName('" + lletra + "'): " + Character.getName(lletra));
            //boolean que indica si és o no un dígit
            System.out.println("Character.isDigit('" + lletra + "'): " + Character.isDigit(lletra));
            //boolean que indica si pot ser o no l’inici d’un identificador vàlid per Java
            System.out.println("Character.isJavaIdentifierStart('"  + lletra + "'): " + Character.isJavaIdentifierStart(lletra));
            //boolean que indica si pot ser o no part d’un identificador vàlid de Java (sense considerar el caràcter inicial)
            System.out.println("Character.isJavaIdentifierPart('"   + lletra + "'): " + Character.isJavaIdentifierPart(lletra));
            //boolean que indica si correspon o no a una lletra
            System.out.println("Character.isLetter('"   + lletra + "'): " + Character.isLetter(lletra));
            //boolean que indica si està o no en minúscules
            System.out.println("Character.isLowerCase('"   + lletra + "'): " + Character.isLowerCase(lletra));
            //boolean que indica si està o no en majúscules
            System.out.println("Character.isUpperCase('"   + lletra + "'): " + Character.isUpperCase(lletra));
            //boolean que indica si correspon o no amb un espai blanc
            System.out.println("Character.isWhitespace('"   + lletra + "'): " + Character.isWhitespace(lletra));
            //retorna la versió del caràcter com a minúscules
            System.out.println("Character.toLowerCase('"   + lletra + "'): " + Character.toLowerCase(lletra));
            //retorna la versió del caràcter com a majúscules
            System.out.println("Character.toUpperCase('"   + lletra + "'): " + Character.toUpperCase(lletra));
            
        }   
   }
}
