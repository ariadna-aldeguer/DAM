import java.io.*;
import java.util.EventObject;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import java.lang.System; 
import java.util.Scanner;


public class consultesXpath {
    Document XMLDoc;

    public static void executaXpath(String fitxer, String query) {
        XPathExpression exp;
        XPath xpath;
        String sortida = "Resultat: ";
        Object result = null;
        try {
            // Creem l'objecte XPathFactory
            xpath = XPathFactory.newInstance().newXPath();

            // Creem l'objecte DocumentBuilderFactory pel DOM (JAXP)
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document XMLDoc = factory.newDocumentBuilder()
                    .parse(new InputSource(new FileInputStream(fitxer)));
                    
            // Crea un XPathExpression con la consulta deseada
            exp = xpath.compile(query);
            
            //exp = xpath.compile("/pacient/identificacio[pes>100]/nom");

            // Executa la consulta i tornarà el resultat
            if (funcioNumero(query)){
                result = exp.evaluate(XMLDoc, XPathConstants.NUMBER); 
                Double count = (Double) result;
                System.out.println(sortida + count.intValue());
                return;
            } else {
                result = exp.evaluate(XMLDoc, XPathConstants.NODESET);
                NodeList nodeList = (NodeList) result;
                // Recorrem la lista de nodes per treure els resultats
                for (int i = 0; i < nodeList.getLength(); i++) {
                    sortida = sortida + "\n" + nodeList.item(i).getChildNodes().item(0).getNodeValue();
                }        
                System.out.println(sortida);
                return;
            }
        } catch (Exception ex) {
            System.out.println(sortida + "erroni");
            System.out.println("Error: " + ex.toString());
            return;
        }
    }
    public static void main(String args[]){  
        Scanner sc = new Scanner(System.in);

        System.out.println("#######################################");
        System.out.println("Benvingut al programa Executa Querys");
        System.out.println("#######################################");

        // Demana ruta absoluta
        String abs_path = demanaFitxer();

        //Comprova que existeix el fitxer o s'ha escrit una ruta
        if (!fitxerValid(abs_path)) return;

        //Demana XPATH
        String xpath = demanaXpath();
        System.out.println("Poden haver consultes sense resultat");
        
        //Executem el mètode i comprovem el seu resultat 
        executaXpath(abs_path, xpath);
        
        //Menu continuació
        while(true){
            int opcio = menu();
            switch(opcio){
                case 1: 
                abs_path = demanaFitxer();
                break;
                case 2: 
                xpath = demanaXpath();
                break;
                case 3:
                System.out.println("Adeu");
                return;
                default: 
                break;
            }
            executaXpath(abs_path, xpath);
        }

    }
    public static String demanaFitxer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quina ruta absoluta XML");
        return sc.nextLine();
    }

    public static String demanaXpath(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quin XPATH");
        return sc.nextLine();
    }
    public static boolean fitxerValid(String abs_path){
        File file = new File(abs_path);
        if (abs_path.equals("")){
            System.out.println("Obligatori una ruta");
            return false;
        } else if(!file.exists()){
            System.out.println("El fitxer no existeix");
            return false;
        }
        return true;
    }

    public static boolean funcioNumero(String query){
        String[] funcions = {"number", "abs", "ceiling", "floor", "round", "count", "avg", "max", "min", "sum"};
        for (int i = 0; i < funcions.length; i++) {
            if (query.contains(funcions[i])) {
                return true;
            }
        }
        return false;
    }

    public static int menu(){
        System.out.println("Escull una opció [1-3]");
        System.out.println("1. Cambiar el fitxer");
        System.out.println("2. Cambiar el xpath");
        System.out.println("3. Sortir del programa");
        
        int numero = 0;

        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        try {
            numero = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            System.out.println("##!! S'esperava un número !!##");
            menu();
        };
        return numero;
    }
}