

import java.text.SimpleDateFormat;
import java.util.Date;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import classes.*;
public class Main {
   public static void main(String[] args){
	   
	   /* Insertar Fila al dept 
	   
	   //En primer lloc s'obté la sessió creada pel Singleton.
	   SessionFactory sesion = HibernateUtil.getSessionFactory();
	   //Obrim la sesió i iniciem una transacció
	   Session session = sesion.openSession();  Transaction tx = session.beginTransaction();
	   System.out.println("Inserim una fila en depart");
	   //Creem un nou objete Depart i donem valor als seus atributs
	   Depart dep = new Depart();
	   dep.setDeptNo((byte) 62);  dep.setDnombre("MARKETING");  dep.setLoc("GUADALAJARA");
	   //Desem a la base de dades i comprometems la informació
	   session.save(dep);
	   tx.commit();
	   session.close();  System.exit(0);*/
	   
	   
	   /* Insertar empleat */
	   //En primer lloc s'obté la sessió creada pel Singleton.
	   SessionFactory sesion2 = HibernateUtil.getSessionFactory();
	   //Obrim la sesió i iniciem una transacció
	   Session session2 = sesion2.openSession();  
	   Transaction tx2 = session2.beginTransaction();

	   Depart dept2 = new Depart();
	   dept2.setDeptNo((byte) 10); 
	   
	   Date date = new Date(System.currentTimeMillis());
	   
	   
	   Emple empl = new Emple(20, dept2, "ALDEGUER", "EMPLEADO", 7360, date,  2500, 300);
	   //Desem a la base de dades i comprometems la informació
	   session2.save(empl);
	   tx2.commit();
	   session2.close();  System.exit(0);
	   
   }
}
