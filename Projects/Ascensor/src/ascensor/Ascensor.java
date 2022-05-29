package ascensor;

public class Ascensor {

	//Atributos:
	private int min;
	private int max;
	private int piso;
	
	
	//Inicializar los atributos de la clase
	public Ascensor(int min, int max) {
		this.min = min;
		this.max = max;
		this.piso = min;
	}
	
	public void subir() {	
		if(piso<max) {
			piso=piso+1;
		}
	}
	public void bajar() {
		if(piso>min) {
			piso=piso-1;
		} 	
	}
	public void ir(int p) {
		if(p<=max && p>=min)
			piso= p; 
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getPiso() {		
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}

		
}
 