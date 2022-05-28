import java.io.Serializable;
import java.beans.*;
import java.util.Date;

@SuppressWarnings("serial")
public class Empleat implements Serializable {

    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    private String NIF;
    private String nom;
    private String carrec;
    private int sou;

    private VetoableChangeSupport propertySupport;

    public Empleat(){
        propertySupport = new VetoableChangeSupport (this);
        this.carrec = "Junior";
        this.sou = 1000;
    }
    public Empleat(String NIF, String nom){
        propertySupport = new VetoableChangeSupport(this);
        this.carrec = "Junior";
        this.sou = 1000;
        this.NIF = NIF;
        this.nom = nom;
    }

    public void addPropertyChangeListener (VetoableChangeListener listener) {
		propertySupport.addVetoableChangeListener(listener);
	}
	
	public void removePropertyChangeListener (VetoableChangeListener listener) {
		propertySupport.addVetoableChangeListener(listener);
	}

    public String getNIF() {
        return NIF;
    }
    public void setNIF(String nIF) {
        NIF = nIF;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCarrec() {
        return carrec;
    }
    public void setCarrec(String carrecActual) {
        if (carrecActual.equals("NULL") || carrecActual.isEmpty() || carrecActual.isEmpty()){ // hi ha que realitzar comanda
        } else {
			try {
                propertySupport.fireVetoableChange("carrec", this.carrec, carrecActual);
            } catch (PropertyVetoException e) {
                System.out.print("Carrec no acceptat");
            }
            this.carrec = carrecActual;
        }
    }
    public int getSou() {
        return sou;
    }
    public void setSou(int sou) {
        if(sou > 0){
			try {
                propertySupport.fireVetoableChange("sou", this.sou, sou);
            } catch (PropertyVetoException e) {
                System.out.print("Variació de sou no acceptada");
            }
            this.sou = sou;
        }
    }

}