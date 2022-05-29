
public class Tramo {
	private int tiempo;
	private Parada paradaInicial;
	private Parada paradaFinal;
	
	public Tramo() {
	}
	public Tramo(int tiempo, Parada paradaInicial, Parada paradaFinal) {
		this.tiempo = tiempo;
		this.paradaInicial = paradaInicial;
		this.paradaFinal = paradaFinal;
	}
	public Parada getParadaInicial() {
		return paradaInicial;
	}
	public void setParadaInicial(Parada paradaInicial) {
		this.paradaInicial = paradaInicial;
	}
	public Parada getParadaFinal() {
		return paradaFinal;
	}
	public void setParadaFinal(Parada paradaFinal) {
		this.paradaFinal = paradaFinal;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	
	
}
