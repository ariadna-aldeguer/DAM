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
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import java.lang.System; 
import java.util.Scanner;

public class XMLCreator {

    public static void main(String[] args) {


        String nombre_archivo = "geekyxml";
        ArrayList <String> key = new ArrayList<String>();
        ArrayList <String> value = new ArrayList<String>();
        ArrayList <String> role = new ArrayList<String>();
        
        System.out.print("Quants elements item vols al fitxer: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= num; i++){
            System.out.println("Valor de l'element key " + i + ": ");
            String k = sc.nextLine();
            key.add(k + " " +i);
            System.out.println("Valor de l'element value " + i + ": ");
            String v = sc.nextLine();
            value.add(v);
            System.out.println("Valor de l'element role " + i + ": ");
            String r = sc.nextLine();
            role.add(r);
        }
       /*  key.add("opcion1");
        value.add("22");

        key.add("opcion2");
        value.add("22");

        key.add("opcion3");
        value.add("22");

        key.add("opcion4");
        value.add("25"); */



        try { 
            generate(nombre_archivo, key, value, role);
        } catch (Exception e) {
            System.out.println("ERROR:\n"+e.toString());
        }
    }

    public static void generate(String name, ArrayList<String> key,ArrayList<String> value, ArrayList<String> role) throws Exception{
        int id = 0;
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
                itemNode.setAttribute("id", String.valueOf(id++));

                //Key Node
                Element keyNode = document.createElement("KEY"); 
                //Role Node
                //keyNode.setTextContent("\n");
                Text nodeKeyValue = document.createTextNode(key.get(i));
                keyNode.appendChild(nodeKeyValue);      
                
                //Value Node
                Element valueNode = document.createElement("VALUE");
                //valueNode.setTextContent("\n");
                Text nodeValueValue = document.createTextNode(value.get(i));
                valueNode.appendChild(nodeValueValue);

                Element roleNode = document.createElement("ROLE"); 
                //roleNode.setTextContent("\n");
                Text nodeRoleValue = document.createTextNode(role.get(i));
                roleNode.appendChild(nodeRoleValue);
                
                //append keyNode and valueNode to itemNode
                //itemNode.setTextContent("\n");
                itemNode.appendChild(keyNode);
                itemNode.appendChild(valueNode);
                itemNode.appendChild(roleNode);
                
                //append itemNode to raiz
                raiz.appendChild(itemNode); //Root node addition
            }      
            //keysToLower(raiz);         
            //XML generation
            Source source = new DOMSource(document);
            
            //Folder selection to store the file
            Result result = new StreamResult(new java.io.File(name+".xml")); //File name and extension
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        }
    }
  /*  NO SE CAMBIAR EL VALOR DEL NODE
   public static void keysToLower(Element element){
        NodeList list = element.getChildNodes();
        for(int i = 0; i < list.getLength(); i++){
            String a = list.item(i).getNodeName().toString().toLowerCase();
            list.item(i).setNodeValue(a);
            String b = list.item(i).getNodeName().toString();
            String c = "a";
        }
    } 
    public static String keysToLower (String text) {
        return text.toLowerCase();
    } */
}