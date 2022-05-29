
public class SeguroDeHogar extends Seguro {
    private String tipoVivienda;
    private int N = 3;
    private double TOTIND = 700;
    private int D1 = 5;
    private int D2 = 2;
    
    public SeguroDeHogar() {
	}
    
    public SeguroDeHogar(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
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
