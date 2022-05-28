import java.io.*;
import java.util.EventObject;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import java.lang.System;
import java.util.Scanner;

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

public class Ariadna_Aldeguer {
    public static void main(String[] args) {


        System.out.println("#######################################");
        System.out.println("Benvingut al programa");
        System.out.println("#######################################");

        String abs_path = "/home/ari/Desktop/DAM/Acces a dades/bcn.xml";

        // Comprova que existeix el fitxer
        if (!fitxerValid(abs_path))
            return;

        // Demana el dia i comprova que sigui correcta
        int dia = demanaDia();
        if (dia < 1 || dia > 7) {
            System.out.println("Valor de dia incorrecte, revisa l'entrada.");
            System.out.println("Fi del programa.");
            return;
        }

        //Executem la consulta
        executaXpath(abs_path, dia);

        System.out.println("Fi del programa.");

    }

    public static int demanaDia() {
        System.out.println("Quin dia vols saber les temperatures mínimes i máximes?");
        Scanner sc = new Scanner(System.in);
        String dia = sc.nextLine();
        int num;

        try {
            num = Integer.valueOf(dia);
        } catch (Exception e) {
            return 0;
        }

        return num;
    }

    public static boolean fitxerValid(String abs_path) {
        File file = new File(abs_path);

        if (!file.exists()) {
            System.out.println("El fitxer no existeix");
            return false;
        }
        return true;
    }


    public static void executaXpath(String fitxer, int dia) {

        String maxima = "";
        String minima = "";
        String data = "";

        String sortida = "Resultat: ";
        try {

            // Creem l'objecte DocumentBuilderFactory pel DOM (JAXP)
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document XMLDoc = factory.newDocumentBuilder()
                    .parse(new InputSource(new FileInputStream(fitxer)));
            XMLDoc.getDocumentElement().normalize();
            
            //Agafem els nodes de dia
            NodeList nodeList = XMLDoc.getElementsByTagName("dia");  
            
            dia = dia - 1;
            
            //Busquem el dia escollit i enseñem els nodes
            Node node = nodeList.item(dia);  
            if (node.getNodeType() == Node.ELEMENT_NODE){
                
                Element eElement = (Element) node;  
                
                
                maxima = eElement.getElementsByTagName("maxima").item(0).getTextContent();
                minima = eElement.getElementsByTagName("minima").item(0).getTextContent(); 
                data = eElement.getAttribute("fecha");

                System.out.println("Máxima: "+ maxima);  
                System.out.println("Mínima: "+ minima); 
            }  
            
            //Genera el document XML amb la informació
            generaDocument(data, maxima, minima, String.valueOf(dia+1));
            
            return;
            
        } catch (Exception ex){
    
            System.out.println(sortida + "erroni");
            System.out.println("Error: " + ex.toString());
            return;
        }
    }

    // Genera un document XML amb la temperatura máx i mín del dia introduït
    public static void generaDocument(String data, String maxima, String minima, String dia) throws Exception{

        String nom_fitxer = "Ariadna_Aldeguer_temp";
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "consulta", null);
        document.setXmlVersion("1.0");

        //Root Node
        Element arrel = document.getDocumentElement();
        arrel.setAttribute("xpath", dia);
        
        //Dia Node
        Element diaNode = document.createElement("dia"); 
        diaNode.setAttribute("data", data);

        //Temperatura Node
        Element tempNode = document.createElement("temperatura"); 

        //Maxima Node
        Element maxNode = document.createElement("maxima");
        Text maxValue = document.createTextNode(maxima);
        maxNode.appendChild(maxValue);

        //Minima Node
        Element minNode = document.createElement("minima"); 
        Text minValue = document.createTextNode(minima);
        minNode.appendChild(minValue);
            
        //Adjunta temperatura Node a dia Node
        diaNode.appendChild(tempNode);

        //Adjunta max and min Node a temperatura Node
        tempNode.appendChild(maxNode);
        tempNode.appendChild(minNode);
            
        //Adjunta dia Node a arrel
        arrel.appendChild(diaNode); //Root node addition
                  
        //XML generation
        Source source = new DOMSource(document);
            
        //Selecciona la carpeta per crear el fitxer
        Result result = new StreamResult(new java.io.File(nom_fitxer+".xml")); //Nom i extensió
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);

    }

}