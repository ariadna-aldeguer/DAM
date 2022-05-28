import java.io.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ProvaSax {
   public static void main (String [] args) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
/* A continuació es crea un objecte processador XML-XMLReader-. Durant la creació d'aquest objecte es pot produir una excepció *SAXException. */
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        XMLReader processadorXML = parser.getXMLReader();
/* Tot seguit, mitjançant setContentHandler establim que la classe que gestiona els esdeveniments provocats per la lectura del XML serà GestioContingut */
       GestioContingut gestor = new GestioContingut();  processadorXML.setContentHandler(gestor);
/* Finalment, es defineix el fitxer que es va llegir mitjançant InputSource i es processa el document XML mitjançant el mètode parse() de XMLReader */
       InputSource fileXML = new InputSource ("discoteca.xml");  processadorXML.parse(fileXML);
   }
}
/* GestioContingut és la classe que implementa els mètodes necessaris per crear el nostre parser d'XML. És a dir,
definim els mètodes que seran cridats en provocar-se els esdeveniments comentats anteriorment: startDocument,
startElement, characters, etc. Si volguessim tractar més esdeveniments definiríem el mètode associat en aquesta classe.*/
class GestioContingut extends DefaultHandler {
    public GestioContingut(){
       super();             }
    public void startDocument(){
        System.out.println("Començament del document XML");    }
    public void endDocument(){
        System.out.println("Final del document XML");          }
    public void startElement (String uri, String nom, String nomC, Attributes atts) {
        System.out.printf("\tElement Inicial: %s %n", nom);    }
    public void endElement (String uri, String nom, String nomC){
        System.out.printf("\tElement final: %s %n",nom);       }
    public void characters(char[] ch, int inici, int longitud) throws SAXException {
        String car = new String (ch, inici, longitud);
        car = car.replaceAll("[\t\n]","");
        System.out.printf("\tCaràcters: %s %n", car);
    }
 }
 