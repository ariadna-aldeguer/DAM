package uml;

public class Ortodoncia extends LineaTratamiento {
	private int numDientesAfectados;

	
	
	/* PREGUNTA 5 */
	
	// CONSTRUCTOR FULL. Super-> el del padre. 
	public Ortodoncia(String concepto, int numDientesAfectados) {
		super(concepto);
		this.numDientesAfectados = numDientesAfectados;
	}
	// CONSTRUCTOR DEFAULT
	public Ortodoncia() {
		super();
		this.numDientesAfectados = 0;
	}

	
	
}
