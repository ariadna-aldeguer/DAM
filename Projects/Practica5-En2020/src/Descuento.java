
public class Descuento extends Privilegio{
	private double porcentaje;
	private double costeDespuesAplicarDescuento;
	
	
	public Descuento() {
	}
	public Descuento(double porcentaje, double costeDespuesAplicarDescuento) {
		this.porcentaje = porcentaje;
		this.costeDespuesAplicarDescuento = costeDespuesAplicarDescuento;
	}

	@Override
	public void aplica(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}
}
