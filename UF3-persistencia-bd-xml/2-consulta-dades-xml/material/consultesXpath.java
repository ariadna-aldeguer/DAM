import java.io.*;
import java.util.EventObject;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class consultesXpath {
    Document XMLDoc;

    public static boolean executaXpath() {
        XPathExpression exp;
        XPath xpath;
        String sortida = "";
        Object result = null;
        try {
            // Creem l'objecte XPathFactory
            xpath = XPathFactory.newInstance().newXPath();
            // Creem l'objecte DocumentBuilderFactory pel DOM (JAXP)
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document XMLDoc = factory.newDocumentBuilder()
                    .parse(new InputSource(new FileInputStream("/Users/alvaro/Desktop/pes.xml")));
            // Crea un XPathExpression con la consulta deseada
            exp = xpath.compile("/pacient/identificacio[pes>100]/nom)");
            // Executa la consulta i tornarà com a resultat una llista de nodes
            result = exp.evaluate(XMLDoc, XPathConstants.NODESET);
            //En cas de voler contar resultats
            //result = exp.evaluate(XMLDoc, XPathConstants.NUMBER);    
            NodeList nodeList = (NodeList) result;
            // Recorrem la lista de nodes per treure els resultats
            for (int i = 0; i < nodeList.getLength(); i++) {
                sortida = sortida + "\n" + nodeList.item(i).getChildNodes().item(0).getNodeValue();
            }        
            System.out.println(sortida);
            return true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
            return false;
        }
    }
    public static void main(String args[]){  
        //Executem el mètode i comprovem el seu resultat 
        boolean result = executaXpath();
        if (result == true){
            System.out.println("Fi del programa");
        }else{
            System.out.println("Resultat erroni");
        }
        
    } 
}