import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/* Utilitzant l’arxiu Persones.xml que conté informació sobre persones (nom i edat), 
generar un arxiu de text que contingui la mateixa informació separant cadascun dels camps amb dos punts (és a dir, el caràcter “:” ).
*/
public class A3_EscriuCSV{
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            File fitxer = new File("Persones.csv"); 
            FileWriter fitW = new FileWriter(fitxer, true);
            String nom;
            String edat;
            char[] cad;

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File ("Persones.xml"));
            NodeList persona = document.getElementsByTagName("persona");
            for (int i = 0; i < persona.getLength(); i++) {
                Node alb = persona.item(i);
                if (alb.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) alb;
                    nom =  element.getElementsByTagName("nom").item(0).getTextContent(); 
                    cad = nom.toCharArray();
                    fitW.write(cad, 0, cad.length);
                    fitW.append(';');
                    edat = element.getElementsByTagName("edat").item(0).getTextContent();
                    cad = edat.toCharArray();
                    fitW.write(cad, 0, cad.length);
                    fitW.append('\n');
                }
            }
            fitW.close();
        } catch (Exception e) {e.printStackTrace();}
    }
}