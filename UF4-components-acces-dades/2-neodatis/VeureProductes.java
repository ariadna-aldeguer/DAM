package javaBean;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class VeureProductes {

	public static void main(String[] args) {
		
		BaseDades db = new BaseDades();
		ODB odb = db.obrirDB();
		
		Objects productes = odb.getObjects(Producte.class);
		
		while(productes.hasNext()) {
			Producte p = (Producte)productes.next();
			
			System.out.printf("Id: %d, Descripció: %s, Stock actual: %d, Stock mínim: %d, Pvp: %.2f%n",
					p.getIdproducte(), p.getDescripcio(), p.getStockactual(), p.getStockminim(), p.getPvp());
			
		}
		
		Objects comandes = odb.getObjects(Comanda.class);
		
		while(comandes.hasNext()) {
			Comanda c = (Comanda)comandes.next();
			
			System.out.printf("Número comanda: %d, Producte: %s, Data: %1$s %2$tB %2$td, %2$tY, Quantitat: %d",
					c.getNumeroComanda(), c.getProducte().getDescripcio(), c.getFecha(), c.getquantitat());
		}
		
		db.tancarDB();
	}

}
