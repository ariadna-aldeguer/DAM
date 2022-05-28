import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearEmpleatXml {
    public static void main(String args[]) throws IOException {
        File fitxer = new File("Empleats.xml");
        FileReader flux = new FileReader (fitxer);  // declaració del reader
        BufferedReader bReader = new BufferedReader(flux); // métode BufferReader
        int id, dep, posicio;
        double salari;
        String cognom;
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleats", null);
            document.setXmlVersion("1.0");

            String linia;
            while ((linia = bReader.readLine()) != null){ // llegim de línia en línia
                String[] empleat = linia.split(":");
                id = Integer.valueOf(empleat[0]);
                cognom = empleat[1];
                dep = Integer.valueOf(empleat[2]);
                salari = Double.valueOf(empleat[3]);
                if (id > 0) {
                    Element arrel = document.createElement("empleat");
                    document.getDocumentElement().appendChild(arrel);
                    CrearElement("id", Integer.toString(id), arrel, document);
                    CrearElement("cognom", cognom.trim(), arrel, document);
                    CrearElement("dep", Integer.toString(dep), arrel, document);
                    CrearElement("salari", Double.toString(salari), arrel, document);
                }
            }

            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("EmpleatsResult.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        bReader.close(); 
    }

    static void CrearElement (String dadaEmpleat, String valor, Element arrel, Document document) {
        Element elem = document.createElement (dadaEmpleat);
        Text text = document.createTextNode(valor);
        arrel.appendChild (elem);
        elem.appendChild (text);
    }
}
