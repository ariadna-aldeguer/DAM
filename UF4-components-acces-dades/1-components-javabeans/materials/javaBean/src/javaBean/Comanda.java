package javaBean;
import java.beans.*;
import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")
public class Comanda implements Serializable, PropertyChangeListener {     
    private int numeroComanda;
    private Producte producte;
    private Date data;
    private int quantitat;   
    public Comanda() { }
    public Comanda (int numeroComanda, Producte producte, Date data, int quantitat) {
            this.numeroComanda = numeroComanda;
            this.producte = producte;
            this.data = data;
            this.quantitat = quantitat;
    }
   
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    	System.out.printf("stock anterior: %d%n",evt.getOldValue());
    	System.out.printf("stock actual: %d%n",evt.getNewValue());
    	System.out.printf("REALITZAR Comanda EN PRODUCTE: %s%n",producte.getDescripcio());
     }
	public int getNumeroComanda() {
		return numeroComanda;
	}
	public void setNumeroComanda(int numeroComanda) {
		this.numeroComanda = numeroComanda;
	}
	public Producte getProducte() {
		return producte;
	}
	public void setProducte(Producte producte) {
		this.producte = producte;
	}
	public Date getFecha() {
		return data;
	}
	public void setFecha(Date data) {
		this.data = data;
	}
	public int getquantitat() {
		return quantitat;
	}
	public void setquantitat(int quantitat) {
		this.quantitat = quantitat;
	}
	
}
