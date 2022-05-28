package javaBean;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import java.util.Date;
public class VeureProductes {

	public static void main(String[] args) {
		
		BaseDades db = new BaseDades();
		ODB odb = db.obrirDB();
		
		Objects productes = odb.getObjects(Producte.class);
		
		Comanda Comanda = new Comanda();
		Objects comandes = odb.getObjects(Comanda.class);
		int id = 0;
		while(comandes.hasNext()) {
			Comanda c = (Comanda)comandes.next();
			id++;
			String data = String.format("%1$tY-%1$tm-%1$td", c.getFecha());
			System.out.printf("Número comanda: %d, Producte: %s, Data: %s, Quantitat: %s%n",
					c.getNumeroComanda(), c.getProducte().getDescripcio(), data, c.getquantitat());
		}
		
		Producte p1 = new Producte();
		
		while(productes.hasNext()) {
			Producte p = (Producte)productes.next();
			System.out.printf("Id producte: %d, Descripció: %s, Stock actual: %d, Stock mínim: %d, Pvp: %.2f%n",
					p.getIdproducte(), p.getDescripcio(), p.getStockactual(), p.getStockminim(), p.getPvp());
			if(p.getStockactual()<p.getStockminim()) {
				db.insertarComanda(new Comanda(id, p, new Date(), p.getStockminim() - p.getStockactual()));
				
			}
		}
		
		db.tancarDB();
	}

}
