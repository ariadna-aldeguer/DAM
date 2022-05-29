package uml;

import java.util.ArrayList;

public class RegistroPacientes {
	//Atributos
	
	private ArrayList<Paciente> pacientes;
	
	//Metodos
	/* PREGUNTA 4 */ 
	   public float importeFacturas(String nif) {  // Sin refactoring -- esto se deberia hacer en paciente
	
		float coste = 0;
		
		
		
		for(Paciente p : pacientes) {  //Recorre todos los pacientes
			if(p.getNif().equals(nif)){
				
				// Coger las facturas del cliente (Esto no estaría bien, bonito, se tendria que llevar esto al paciente)
				
				ArrayList<Factura> facturas = p.getFacturas();
				for(Factura f: facturas) { //Recorre todas las facturas del paciente
					coste= coste + f.calculaImporteFactura();
				}
				break;
			}
		}
		
		return coste;
	}
	/* Refactoring 
	public float importeFacturas(String nif) {  
		
		float coste = 0;
		
		for(Paciente p : pacientes) { 
			if(p.getNif().equals(nif)){
				coste = p.costeFacturas();
				break;	
			}
			
		}
		
		return coste;
	} */
	
}
