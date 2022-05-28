package javaBean;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class BaseDades {
    
    private ODB odb;
    
    public BaseDades() {
    	
    }

    public ODB obrirDB(){
        this.odb = ODBFactory.open("Producte_Com.BD");
        return odb;
    }

    public void tancarDB(){
        this.odb.close();
    }
    public void insertarProducte(Producte prod) {
    	odb.store(prod);
    }
    public void insertarComanda(Comanda com) {
    	odb.store(com);
    }
    
    
}
