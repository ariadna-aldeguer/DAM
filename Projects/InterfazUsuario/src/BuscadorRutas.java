
public abstract class BuscadorRutas {
	private Ruta ruta;
	
	public abstract Ruta buscaRuta(String npIni, String npFin);

	public BuscadorRutas() {
	}
	public BuscadorRutas(Ruta ruta) {
		this.ruta = ruta;
	}
}
