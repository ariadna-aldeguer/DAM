package javaBean;

//import javaBean.Comanda;
//import javaBean.Producte;
public class Prova {
    public static void main(String[] args) {
    	
    	System.out.println("prova");
        Producte producte = new Producte(1, "Duruss Cobalt", 10, 3, 220);
        Comanda Comanda =new Comanda();
        Comanda.setProducte(producte);
        
        producte.addPropertyChangeListener (Comanda);
        producte.setStockactual(4);
    }
}

