package uml;

public class LineaTratamiento {
	private String concepto;
	
	
	public float calculaImporte() {
		return 0;
	}

	
	/* PREGUNTA 5 */
	
	// CONSTRUCTOR FULL
	public LineaTratamiento(String concepto) {
		this.concepto = concepto;
	}
	
	// CONSTRUCTOR POR DEFECTO
	public LineaTratamiento() {
		
	}
	
}


/* PREGUNTA 1 
 * (A)Si no existe un paciente, no existe. Se ha escogido este tipo de relación
 * porque no tendria sentido guardar un paciente que no sabemos cuál es
 * 
*/ 