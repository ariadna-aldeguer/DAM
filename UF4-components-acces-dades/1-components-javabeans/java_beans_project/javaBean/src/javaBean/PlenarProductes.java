package javaBean;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class PlenarProductes {
	public static void main(String[] args) {
		
		BaseDades db = new BaseDades();
		
		ODB odb = db.obrirDB();
		System.out.print("plenar");
		
		/*Producte p1 = new Producte(1, "Duruss Cobalt", 10, 3, 220);
		Producte p2 = new Producte(2, "Varlion Avant Carbon", 5, 2, 176);
		Producte p3 = new Producte(3, "Star Vie Pyramid R50", 20, 5, 193);
		Producte p4 = new Producte(4, "Dunlop Titan", 8, 3, 85);
		Producte p5 = new Producte(5, "Vision King", 7, 1, 159);*/
		Producte p6 = new Producte(7, "Slazenger Reflex Pro", 1, 2, 80);
		
		db.insertarProducte(p6);
		/*
		db.insertarProducte(p2);
		db.insertarProducte(p3);
		db.insertarProducte(p4);
		db.insertarProducte(p5);
		db.insertarProducte(p6);*/
		
		db.tancarDB();
	}
}
