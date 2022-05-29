package uml;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	private int numero;
	private String descripcion;
	private Date fecha;
	private Paciente paciente;
	private ArrayList<LineaTratamiento> lineas;

	
	/* PREGUNTA 6 */
	
	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", descripcion=" + descripcion + ", fecha=" + fecha + ", paciente="
				+ paciente + "]";
	}


	/* PREGUNTA 3 */
	public float calculaImporteFactura() {
		
		float coste = 0;
		for(LineaTratamiento lt:lineas) {
			coste=coste + lt.calculaImporte();
		}
		return coste;	
		
	}
	
	
}
// Maneras de recorrer un ArrayList 
// Crecen en función de tus necesidades.

/*
 * -----------------------------   FORMA BUENA --------------------------------------------------
 * 
 * for(LineaTratamiento lt:lineas) {
			coste=coste + lt.calculaImporte();
		}
		return coste;	
 */



/* 
 *------------------------------- FORMA 2 ----------------------------------------------------
 * 
 * for(int i = 0; i < lineas.size(); i++){ -- si tiene diez components, irá del 1 al 0
 * 		LineaTratamiento lt = lineas.get(i);
 * 		coste = coste + lt.calculaImporte();
 * } 
 */

/* 
 * ------------------------------ FORMA 3 --------------------------------------------------
 * 
 * Iterator<LineaTratamiento> it = lineas.iterator();
 * 		while(it.hasNext()) {
 * 			LineaTratamiento lt = it.next();
 * 			coste=coste + lt.calculaImporte();
 * }
 */

