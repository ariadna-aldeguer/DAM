package uml;

import java.util.ArrayList;

public class Paciente {
	//Atributos
	private String nif;
	private String nombre;
	private String direccion;
	private ArrayList<Factura>facturas;
	
	
	
	/* PREGUNTA 6 - Boton derecho/Source/Generar auto toString */
	@Override
	public String toString() {
		return "Paciente [nif=" + nif + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	public float costeFacturas () { //Suma todas las facturas
		float coste = 0;
		for(Factura f: facturas) { //Recorre todas las facturas del paciente
			coste= coste + f.calculaImporteFactura();
		}
		return coste;
		
	}
}
