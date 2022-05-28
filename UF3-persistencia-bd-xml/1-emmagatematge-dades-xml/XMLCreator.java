import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XMLCreator {

    public static void main(String[] args) {
        String nombre_archivo = "geekyxml";
        ArrayList <String> key = new ArrayList<String>();
        ArrayList <String> value = new ArrayList<String>();

        key.add("opcion1");
        value.add("22");

        key.add("opcion2");
        value.add("22");

        key.add("opcion3");
        value.add("22");

        key.add("opcion4");
        value.add("25");

        try { 
            generate(nombre_archivo, key, value);
        } catch (Exception e) {
            System.out.println("ERROR:\n"+e.toString());
        }
    }

    public static void generate(String name, ArrayList<String> key,ArrayList<String> value) throws Exception{

        if(key.isEmpty() || value.isEmpty() || key.size()!=value.size()){
            System.out.println("ERROR empty ArrayList");
            return;
        }else{

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, name, null);
            document.setXmlVersion("1.0");

            //Root Node
            Element raiz = document.getDocumentElement();
            //Each item Node will content a Key Node and a Value Node
            for(int i=0; i<key.size();i++){
                //Item Node
                Element itemNode = document.createElement("ITEM"); 
                
                //Key Node
                Element keyNode = document.createElement("KEY"); 
                //keyNode.setTextContent("\n");
                Text nodeKeyValue = document.createTextNode(key.get(i));
                keyNode.appendChild(nodeKeyValue);      
                
                //Value Node
                Element valueNode = document.createElement("VALUE");
                //valueNode.setTextContent("\n");
                Text nodeValueValue = document.createTextNode(value.get(i));
                valueNode.appendChild(nodeValueValue);
                
                //append keyNode and valueNode to itemNode
                //itemNode.setTextContent("\n");
                itemNode.appendChild(keyNode);
                itemNode.appendChild(valueNode);
                
                //append itemNode to raiz
                raiz.appendChild(itemNode); //Root node addition
            }                
            //XML generation
            Source source = new DOMSource(document);
            
            //Folder selection to store the file
            Result result = new StreamResult(new java.io.File(name+".xml")); //File name and extension
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        }
    }

}