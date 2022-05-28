package Bean;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
public class BaseDatos{
	private ODB odb;
	
	public BaseDatos() {
		
	}
	
	public void obrirDB(){

	    this.odb = ODBFactory.open("C:/Users/ariadna.aldeguer/eclipse-workspace/Alvaro/Departamentos.BD");
	}
	
	public void tancarDB(){
	    this.odb.close();
	}
	public void insertarDepartamento(Departamentos dept) {
		obrirDB();
				
		if(dept.getDeptno() < 1) {
			System.out.println("Número negativo");
		} else {			
			odb.store(dept);
			System.out.println("Se esta insertando en la BD");
		}
		
		Objects departaments = odb.getObjects(Departamentos.class);
		
		while(departaments.hasNext()) {
			Departamentos p = (Departamentos)departaments.next();
			
			System.out.printf("Id: %d, Nom: %s, Loc: %s %n",
					p.getDeptno(), p.getDnombre(), p.getLoc());
			
		}
		
		tancarDB();
	}
}