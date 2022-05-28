import java.io.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class NumeroDiscos {
    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
        /*
         * A continuació es crea un objecte processador XML-XMLReader-. Durant la
         * creació d'aquest objecte es pot produir una excepció *SAXException.
         */
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        XMLReader processadorXML = parser.getXMLReader();
        /*
         * Tot seguit, mitjançant setContentHandler establim que la classe que gestiona
         * els esdeveniments provocats per la lectura del XML serà GestioContingut
         */
        GestioContingut3 gestor = new GestioContingut3();
        processadorXML.setContentHandler(gestor);
        /*
         * Finalment, es defineix el fitxer que es va llegir mitjançant InputSource i es
         * processa el document XML mitjançant el mètode parse() de XMLReader
         */
        InputSource fileXML = new InputSource("discoteca.xml");
        processadorXML.parse(fileXML);
    }
}

/*
 * GestioContingut és la classe que implementa els mètodes necessaris per crear
 * el nostre parser d'XML. És a dir,
 * definim els mètodes que seran cridats en provocar-se els esdeveniments
 * comentats anteriorment: startDocument,
 * startElement, characters, etc. Si volguessim tractar més esdeveniments
 * definiríem el mètode associat en aquesta classe.
 */
class GestioContingut3 extends DefaultHandler {
    int tituls = 0;
    public GestioContingut3() {
        super();
    }

    public void endDocument() {
        System.out.println("Número de títols: " + tituls);
    }

    public void startElement(String uri, String nom, String nomC, Attributes atts) {
        if(nomC.equals("TITLE")){
            tituls++;
        }
    }

}
