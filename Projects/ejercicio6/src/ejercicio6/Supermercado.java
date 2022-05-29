package ejercicio6;

import java.util.ArrayList;

public class Supermercado {
	
	private ArrayList<Cesta> cesta;
	private ArrayList<Seccion> seccion;
	private Almacen almacen; 
	

	public Supermercado(Almacen almacen){
		this.seccion = new ArrayList<Seccion>();
		this.cesta = new ArrayList<Cesta>();
		this.almacen = almacen;
	}
	
	// POR DEFECTO - No hace falta el almacen
	
	public Supermercado(){
		this.seccion = new ArrayList<Seccion>();
		this.cesta = new ArrayList<Cesta>();
	}
}
