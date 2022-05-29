import java.util.Collections;
import java.util.Comparator;

public class Habitacion implements Comparable<Habitacion>{
	
	/* |---------------------------PROBLEMA 4 -------------------------------̣|*/
	
	/* (4.A) Crea la clase Habitacion, con los siguientes atributos y constructores */
	
	// Atributos:
	private String name;
	private int id;
	
	//Constructores
	public Habitacion() {
	
	}
	
	public Habitacion(String name, int id) {
		this.name = name;
		this.id = id;
	}

	/* (4.D) Define el método toString en la clase Habitacion. Utiliza el wizard de eclipse */
	
	@Override
	public String toString() {
		return "Habitacion [name=" + name + ", id=" + id + "]";
	}	
	
	public void getName() {
		// TODO Auto-generated method stub
		
	}

	
	/* (4.G)  Implementa la interfaz comparable en la clase Habitacion. Implementa el método
	 * compareTo de esta interfaz, de manera que permita ordenar por el nombre de la Habitacion: */
	
	/*
	@Override
	public int compareTo(Habitacion o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	*/	
	
	
	/* (4.I) Modifica el método compareTo para realizar la ordenación del array estático de
	 * habitaciones según su atributo entero id. */
	/*
	@Override
	public int compareTo(Habitacion o) {
		// TODO Auto-generated method stub
		return this.getId().compareTo(o.getId());
	}
	 */
	
	// |---------------------------PROBLEMA 5 -------------------------------̣|
	
	// (5.F)  Define el método equals en la clase Habitacion, usando el wizard de eclipse
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Habitacion other = (Habitacion) obj;
		if (id != other.id) return false;
		if (name == null) {
			if (other.name != null) {
				return false;
			} else if (!name.contentEquals(other.name)) 
				return false;
			
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Habitacion arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
	
}
