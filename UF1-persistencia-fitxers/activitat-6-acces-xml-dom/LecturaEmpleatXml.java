import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;
public class LecturaEmpleatXml {
   public static void main (String[] args) {
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       try {
           DocumentBuilder builder = factory.newDocumentBuilder();
           Document document = builder.parse(new File ("Album.xml"));
           System.out.printf ("Element arrel : %s %n", document.getDocumentElement().getNodeName());
           NodeList album = document.getElementsByTagName("album");
           System.out.printf ("Nodes album a recorrer: %d %n", album.getLength());
           for (int i = 0; i < album.getLength(); i++) {
               Node alb = album.item(i);
               if (alb.getNodeType() == Node.ELEMENT_NODE){
                   Element element = (Element) alb;
                   System.out.printf("Autor = %s %n", element.getElementsByTagName("autor").item(0).getTextContent());
                   System.out.printf(" * Titul = %s %n", element.getElementsByTagName("titol").item(0).getTextContent());
                   System.out.printf(" * Format = %s %n", element.getElementsByTagName("format").item(0).getTextContent());
               }
           }
       } catch (Exception e) {e.printStackTrace();}
    }
}

