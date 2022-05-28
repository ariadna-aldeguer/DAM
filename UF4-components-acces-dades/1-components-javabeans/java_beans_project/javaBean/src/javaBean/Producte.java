package javaBean;
import java.beans.*;
import java.io.Serializable;
import java.util.Date;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

@SuppressWarnings("serial")
public class Producte implements Serializable {

	public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
	private String descripcio;
	private int idproducte;
	private int stockactual;
	private int stockminim;
	private float pvp;
	
	private PropertyChangeSupport propertySupport;
	
	public Producte () {
		propertySupport = new PropertyChangeSupport (this);
    }
	
	public Producte (int idproducte, String descripcio, int stockactual, int stockminim, float pvp) {
		propertySupport = new PropertyChangeSupport(this);
		this.idproducte = idproducte;
		this.descripcio = descripcio;
		this. stockactual = stockactual;
		this.stockminim = stockminim;
		this.pvp = pvp;
	}
	
	public void addPropertyChangeListener (PropertyChangeListener listener) {
		propertySupport.addPropertyChangeListener(listener);
		BaseDades db = new BaseDades();
    	
    	Comanda Comanda = (javaBean.Comanda) listener;
    	db.insertarComanda(Comanda);

	}
	
	public void removePropertyChangeListener (PropertyChangeListener listener) {
		propertySupport.removePropertyChangeListener(listener);
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public int getIdproducte() {
		return idproducte;
	}

	public void setIdproducte(int idproducte) {
		this.idproducte = idproducte;
	}

	public int getStockactual() {
		return stockactual;
	}

	public void setStockactual(int valorNou) {
		int valorAnterior = this.stockactual;
		this.stockactual = valorNou;
		
		if (this.stockactual < getStockminim()) // hi ha que realitzar comanda
		{
			propertySupport.firePropertyChange("stockactual", valorAnterior, this.stockactual);
			this.stockactual = valorAnterior; // deixem el stock anterior, no actualitzem
		}
	}

	public int getStockminim() {
		return stockminim;
	}

	public void setStockminim(int stockminim) {
		this.stockminim = stockminim;
	}

	public float getPvp() {
		return pvp;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	public PropertyChangeSupport getPropertySupport() {
		return propertySupport;
	}

	public void setPropertySupport(PropertyChangeSupport propertySupport) {
		this.propertySupport = propertySupport;
	}

}