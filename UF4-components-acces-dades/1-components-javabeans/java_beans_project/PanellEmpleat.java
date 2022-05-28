import java.beans.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class PanellEmpleat implements Serializable, VetoableChangeListener {

    private int limitVaracioSou;
    private List<String> llistaDeCarregs;

    
    public PanellEmpleat() {
        this.limitVaracioSou = 10;
        this.llistaDeCarregs = Arrays.asList("Junior", "Semisenior", "Analista", "CEO");
    }
    public PanellEmpleat(int limitVaracioSou) {
        this.limitVaracioSou = limitVaracioSou;
        this.llistaDeCarregs = Arrays.asList("Junior", "Semisenior", "Analista", "CEO");
    }
    public int getLimitVaracioSou() {
        return limitVaracioSou; 
    }
    public void setLimitVaracioSou(int limitVaracioSou) {
        this.limitVaracioSou = limitVaracioSou;
    }
    public List<String> getLlistaDeCarregs() {
        return llistaDeCarregs;
    }
    public void setLlistaDeCarregs(List<String> llistaDeCarregs) {
        this.llistaDeCarregs = llistaDeCarregs;
    }

    public boolean estaLlistaCarrecs(String carrec){

    for (String c : llistaDeCarregs) {
        if(c.equals(carrec)){
            return true;
        }
    }

    return false;
    }

     public boolean superaLimitacioVariacio(int valorAnterior, int valorNou){

        int variacio = Math.abs(valorNou - valorAnterior);

        if(variacio <= limitVaracioSou){
            return true;
        }

        return false;
     }
    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        if(evt.getPropertyName().equals("carrec")){
			String carrecAntic = evt.getOldValue().toString();
			String carrecNou = evt.getNewValue().toString();
            if(!estaLlistaCarrecs(carrecNou)){
                throw new PropertyVetoException(null, evt);
            }

		} else if (evt.getPropertyName().equals("sou")){
            int souAntic = Integer.parseInt(evt.getOldValue().toString());
            int souNou = Integer.parseInt((String) evt.getNewValue().toString());
            if(!superaLimitacioVariacio(souAntic, souNou)){
                throw new PropertyVetoException(null, evt);
            }
		}
    }
}
