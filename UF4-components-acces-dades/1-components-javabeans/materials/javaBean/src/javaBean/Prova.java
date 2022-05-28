package javaBean;


//import javaBean.Comanda;
//import javaBean.Producte;
public class Prova {
    public static void main(String[] args) {
        Producte producte = new Producte(1,"ProducteEstrela",10,3,16);
        Comanda Comanda =new Comanda();
        Comanda.setProducte(producte);
        
        producte.addPropertyChangeListener (Comanda);
        producte.setStockactual(2);
    }
}


