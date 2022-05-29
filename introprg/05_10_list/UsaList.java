/* Programa que crea un ArrayList i provem certes funcioanlitats */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class UsaList {
    public static void main(String[] args) {
        

        // TODO: inicialitza la llista amb una instància de  ArrayList
        //       un LinkedList. Com et vingui de gust
        ArrayList<String> llista = new ArrayList<String>();


        System.out.println("Obtenim les entrades");
        System.out.println("====================");
        String valor;

        valor = Entrada.readLine();
        
        llista.add(valor);
        // TODO: afegeix valor a la llista


        valor = Entrada.readLine();

        llista.add(0, valor);
        // TODO: afegeix el valor a l'inici de la llista


        valor = Entrada.readLine();
        llista.add(1, valor);
        // TODO: afegeix el valor al mig de la llista



        System.out.println("Cerquem elements de la llista");
        System.out.println("=============================");
        String text = Entrada.readLine();

        boolean esTroba = llista.contains(text);
        // TODO: inicialitza esTroba a true si text està a la llista

        System.out.printf("El text %s és troba a la llista: %s%n", text, esTroba);

        int indexPrimerOcurrència = llista.indexOf(text);
        // TODO: inicialitza indexPrimerOcurrència a l'índex on es troba text

        System.out.printf("Posició de %s a la llista: %s%n", text, indexPrimerOcurrència);


        System.out.println("Mostrem les entrades introduïdes");
        System.out.println("================================");
        boolean llistaBuida = llista.isEmpty();
        // TODO inicialitza llistaBuida de manera que valgui cert si
        // la llista està buida.

        while (! llistaBuida) {
            String entrada = llista.get(0);
            // TODO: inicialitza entrada de manera que contingui el
            // primer element de la llista

            System.out.println(entrada);
            llista.remove(0);
            // TODO: elimina el primer element de la llista
            llistaBuida = llista.isEmpty();
            // TODO: actualitza el valor de llistaBuida

        }
    }
}