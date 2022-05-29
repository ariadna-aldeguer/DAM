
public class SeguroDeCoche extends Seguro {
    private String gamaVehiculo;
    private int N = 2;
    private double TOTIND = 500;
    private int D1 = 4;
    private int D2 = 1;

	

    public SeguroDeCoche() {
	}
	public SeguroDeCoche(String gamaVehiculo) {
		this.gamaVehiculo = gamaVehiculo;
	}

	@Override
	public int getN() {
		// TODO Auto-generated method stub
		return N;
	}

	@Override
	public double getTOTIND() {
		// TODO Auto-generated method stub
		return TOTIND;
	}

	@Override
	public int getD1() {
		// TODO Auto-generated method stub
		return D1;
	}

	@Override
	public int getD2() {
		// TODO Auto-generated method stub
		return D2;
	}
    
}
