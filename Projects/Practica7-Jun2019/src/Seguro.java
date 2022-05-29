import java.util.ArrayList;

public abstract class Seguro {
    protected String fechaContrato;
    protected double cuotaAnualBase;
    protected double descuentoORecargo;
    private ArrayList<Parte> partes;

    public abstract int getN();
    public abstract double getTOTIND();
    public abstract int getD1();
    public abstract int getD2();
	
    public Seguro() {
		this.partes = new ArrayList<Parte>();
	}
    
    public Seguro(String fechaContrato, double cuotaAnualBase, double descuentoORecargo) {
		this.fechaContrato = fechaContrato;
		this.cuotaAnualBase = cuotaAnualBase;
		this.descuentoORecargo = descuentoORecargo;
		this.partes = new ArrayList<Parte>();
	}
    
    public String getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(String fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	/*Ejercicio 2 (1,5 puntos). 
    	Este método genera un String que incluye detalles de los partes de incidencia asociados al seguro en
    	cuestión, ocurridos entre la fecha indicada en el argumento fechaInicio y la fecha indicada por
    	el argumento fechaFinal (ambas incluidas).
    	Se sugiere la implementación del método toString() en la clase Parte para que el código de dicho
    	método sea más corto. El string resultante NO debe contener ninguna otra información del seguro
    	asociado al parte.
    */
    public String listaPartesEntreFechas(String fechaInicio, String fechaFinal) {
    	
    	String resultat = ""; 
    	for(Parte parte: partes) {
    		if (parte.getFechaIncidencia().compareTo(fechaInicio) >= 0 &&
    			parte.getFechaIncidencia().compareTo(fechaFinal) <= 0) {
    			resultat += parte.toString() + "\t";
    		}
    	}
    	
    	return resultat;
    }
    
    /*Ejercicio 3 ( 1,5 puntos). Implementad en la clase Seguro los siguiente métodos:
	numPartesEnAnyo(int anyo) ; Este método devuelve el número de incidencias notificadas para el 
	seguro durante el año indicado por el argumento anyo.
	public double costeIncidenciasEnAnyo(int anyo) ; Este método devuelve la suma de los costes de 
	todas las incidencias que se dieron para el seguro 	durante el año indicado por el argumento anyo. */
    
    public int numPartesEnAnyo(int anyo) {
    	
    	int contador = 0;
    	
    	for(Parte parte: partes) {
    		if(Fecha.getAnyoDeFecha(parte.getFechaIncidencia()).equals(anyo)) {
    			contador++;
    		}
    	}
    	
    	return contador;
    }
    public double costeIncidenciasEnAnyo(int anyo) {
    	double coste = 0;
    	
    	for(Parte parte: partes) {
    		if(Fecha.getAnyoDeFecha(parte.getFechaIncidencia()).equals(anyo)) {
    			coste += parte.getCosteIndemnizacion();
    		}
    	}
    	
    	return coste;
    }
    
    
//    Ejercicio 4 (2 puntos). En la clase Seguro el atributo descuentoORecargo indica el porcentaje
//    en % en el que el atributo cuotaAnualBase debe incrementarse para calcular la cuota anual
//    correspondiente a un seguro que el cliente debe pagar. Un valor positivo indica un recargo; un valor
//    negativo indica un descuento.
//    La clase Seguro incorpora el método que sigue:

      public void actualizarDescuentoORecargo() {
    	  
    	  
    	  int anyoAnterior = Integer.parseInt(Fecha.getFechaActual())-1;
    	  if(numPartesEnAnyo(anyoAnterior) > getN() ||
    		 costeIncidenciasEnAnyo(anyoAnterior) > getTOTIND()){
    		  
    		  this.descuentoORecargo += this.descuentoORecargo*(getD1()/100);
    		  
    		  if(this.descuentoORecargo > 25) {
    			  this.descuentoORecargo = 25;
    		  }
    	  }
    	  
    	  if(numPartesEnAnyo(anyoAnterior) == 0) {
    		  this.descuentoORecargo -= this.descuentoORecargo*(getD2()/100);
    		  
    		  if(this.descuentoORecargo < -15) {
    			  this.descuentoORecargo = -15;
    		  }
    	  }
      }
    
    
    

}
