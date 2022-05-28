package javaBean;
import java.beans.*;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

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
    	
    	BaseDades db = new BaseDades();
    	ODB odb = db.obrirDB();
    	
    	Comanda Comanda = new Comanda();
    	
    	Objects comandes = odb.getObjects(Comanda.class);
		int id = 1;
		while(comandes.hasNext()) {
			Comanda c = (Comanda)comandes.next();
			id++;
		}
    	
		Comanda.setNumeroComanda(id);
    	Comanda.setProducte(producte);
    	Comanda.setFecha(new Date());
    	Comanda.setquantitat((int)evt.getNewValue());
  
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