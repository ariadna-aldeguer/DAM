import java.io.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class NumeroDiscosAutor {
    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
        /*
         * A continuació es crea un objecte processador XML-XMLReader-. Durant la
         * creació d'aquest objecte es pot produir una excepció *SAXException.
         */
        String autor = "";
        for(int i = 0; i < args.length; i++){
            if(i == 0){
                autor = args[i];
            } else {
                autor += " " + args[i];
            }
        }
        System.out.printf("Autor: %s", autor);
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        XMLReader processadorXML = parser.getXMLReader();
        // XMLReader processadorXML = XMLReaderFactory.createXMLReader();
        /*
         * Tot seguit, mitjançant setContentHandler establim que la classe que gestiona
         * els esdeveniments provocats per la lectura del XML serà GestioContingut
         */

        GestioContingut2 gestor = new GestioContingut2(autor);
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
class GestioContingut2 extends DefaultHandler {
    String autor;
    int tituls = 0;
    boolean trobat;
    public GestioContingut2(String autor) {
        super();
        this.autor = autor;
    }

    public void endDocument() {
        if(!trobat || autor.equals("")){
            System.out.println("L'autor <"+ autor +"> no apareix en l'arxiu");
        } else {
            System.out.println("Número de títols: " + tituls);
        }
    }

    public void characters(char[] ch, int inici, int longitud) throws SAXException {
        String car = new String (ch, inici, longitud);
        // car = car.replaceAll("[\t\n]","");
        if(car.equals(autor)){
            tituls++;
            trobat = true;
        }
    }


}