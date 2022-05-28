
import java.util.Scanner;


import java.util.ArrayList;
import java.util.Date;
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
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import java.lang.System;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.*;

public class Project{
    public static void main(String[] args) throws IOException{
        String name_fitxer = "doc";
        int id = 0;
        ArrayList<String> nodes = new ArrayList<String>();

        System.out.println("Fitxer paraules:");
        Scanner sc = new Scanner(System.in);
        String path_pla = sc.nextLine();
        // String path_pla = "fitxer_pla";
        System.out.println("Fitxer csv:");
        sc = new Scanner(System.in);
        String path_csv = sc.nextLine();
        // String path_csv = "fitxer_csv.csv";

        // Creo el document xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, name_fitxer, null);
            document.setXmlVersion("1.0");
            
            ///Root Node
            Element raiz = document.getDocumentElement();

            try {
                BufferedReader entrada = new BufferedReader(new FileReader(path_pla));
                String linia;
                while ((linia = entrada.readLine()) != null){ // llegim de línia en línia
                    nodes.add(linia);
                }
            } catch (FileNotFoundException e){
                printError(e);
            }
            try {
                BufferedReader cReader = new BufferedReader(new FileReader(path_csv));
                String fila;
                while ((fila = cReader.readLine()) != null){ // llegim de línia en línia
                    String[] elements = fila.split(",");
                    Element elem = document.createElement("elem"); 
                    elem.setAttribute("nr", String.valueOf(id++));
                    for(int i = 0; i < elements.length; i++){
                        if(elements.length <= 1){
                            Text node_1_value = document.createTextNode(elements[i]);
                            Element node_1 = document.createElement(nodes.get(0)); 
                            node_1.appendChild(node_1_value);  
                            elem.appendChild(node_1);
                            Element node_2 = document.createElement(nodes.get(1));
                            elem.appendChild(node_2);
                        } else {
                            //Element 
                            switch (i){
                                case 0:
                                    Text node_1_value = document.createTextNode(elements[i]);
                                    Element node_1 = document.createElement(nodes.get(0)); 
                                    node_1.appendChild(node_1_value);  
                                    elem.appendChild(node_1);
                                    break;
                                case 1:
                                    Text node_2_value = document.createTextNode(elements[i]);
                                    Element node_2 = document.createElement(nodes.get(1));
                                    node_2.appendChild(node_2_value);    
                                    elem.appendChild(node_2);
                                    break;
                                default:
                                    Text node_3_value = document.createTextNode(elements[i]);
                                    Element node_3 = document.createElement("altres");
                                    node_3.appendChild(node_3_value);   
                                    elem.appendChild(node_3); 
                                    break;
                            }  
                        }
                    }
                    raiz.appendChild(elem); 
                }
            } catch (FileNotFoundException e){
                printError(e);
            }

            Source source = new DOMSource(document);
                
            //Folder selection to store the file
            Result result = new StreamResult(new java.io.File(name_fitxer+".xml")); //File name and extension
            Transformer transformer;
            try {
                transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, result);
            } catch (TransformerConfigurationException e) {
                printError(e);
            } catch (TransformerException e) {
                printError(e);
            }

        } catch (ParserConfigurationException e) {
            printError(e);
        }

        // sc.close();
    }


    public static void printError(Exception e)throws IOException{
        File fitxer = new File("errors.txt"); // declaració del fitxer
        FileWriter fitW = new FileWriter(fitxer, true); 
        
        fitW.write(getDate() + "\n");
        fitW.write(e + "\n");
        fitW.close();
    }
    public static String getDate(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}