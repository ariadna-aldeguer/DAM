
public class Parte {
    private String descripcion;
    private String informe;
    private double costeIndemnizacion;
    private String fechaIncidencia;
    private Seguro seguro;
    
    public Parte() {
	}
    public Parte(String descripcion, String informe, double costeIndemnizacion, String fechaIncidencia, Seguro seguro) {
		this.descripcion = descripcion;
		this.informe = informe;
		this.costeIndemnizacion = costeIndemnizacion;
		this.fechaIncidencia = fechaIncidencia;
		this.seguro = seguro;
	}
	public String getFechaIncidencia() {
		return fechaIncidencia;
	}
	public void setFechaIncidencia(String fechaIncidencia) {
		this.fechaIncidencia = fechaIncidencia;
	}
	
	
	public double getCosteIndemnizacion() {
		return costeIndemnizacion;
	}
	public void setCosteIndemnizacion(double costeIndemnizacion) {
		this.costeIndemnizacion = costeIndemnizacion;
	}
	@Override
	public String toString() {
		return "Parte [descripcion=" + descripcion + ", informe=" + informe + ", costeIndemnizacion="
				+ costeIndemnizacion + ", fechaIncidencia=" + fechaIncidencia + ", seguro=" + seguro + "]";
	}
    
	
    

}
