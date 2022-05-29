import java.util.ArrayList;

public class Lineas {
	private int numero;
	private ArrayList<Tramo> tramos;
	private ArrayList<Parada> paradas;
	
	public Lineas() {
		this.tramos = new ArrayList<Tramo>();
		this.paradas = new ArrayList<Parada>();
	}
	
	public Lineas(int numero) {
		this.numero = numero;
		this.tramos = new ArrayList<Tramo>();
		this.paradas = new ArrayList<Parada>();
	}
	
	/* PREGUNTA 2: Este método debe devolver el objeto de tipo Parada con nombre igual al parámetro
	nombre perteneciente a la línea que recibe la invocación del método. Si no se encuentra
	parada alguna con ese nombre, el método debe devolver null.  */
	
	 public Parada getParada(String nombre) {
		 for (Parada parada: paradas){
			 if (parada.getNombre().equals(nombre)) {
				 return parada;
			 }
		 }
		 return null;
	 }
	 
	 /* PREGUNTA 3 (1 punto). En la clase Linea, implementa el método:
	Este método debe encontrar y devolver el objeto de tipo Tramo que une las paradas con
	nombres iguales a los parámetros nombreP1 y nombreP2. Ten presente que el tramo
	puede buscarse en ambas direcciones, es decir, la búsqueda de tramo entre las paradas
	Zona Universitària y Palau Reial o Palau Reial y Zona Universitària debería devolver
	idéntico resultado. Si el tramo no se encuentra en la línea, el método devuelve null. */
	 
	 public Tramo getTramo(String nombreP1, String nombreP2) {
		 for(Tramo tramo: tramos) {
			 if (tramo.getParadaInicial().getNombre().equals(nombreP1) || tramo.getParadaFinal().getNombre().contentEquals(nombreP1)) {
				 if (tramo.getParadaInicial().getNombre().equals(nombreP2) || tramo.getParadaFinal().getNombre().contentEquals(nombreP2)){
					 return tramo;
				 }
			 }
		 }
		 return null;
	 }

}
