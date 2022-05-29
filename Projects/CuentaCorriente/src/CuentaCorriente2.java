
public class CuentaCorriente2 {
	//Atributos
	private String titular; //Numero del titular de la cuenta
	private int numero;		//Numero de la cuenta
	private double saldo; 	// Cantidad de euros en la cuenta
	private double limiteCredito; 		//Maximo saldo negativo permitido



	public CuentaCorriente2 (String titular, int numero) {
		this.titular = titular;
		this.numero = numero;
		this.saldo = 0.0;
		this.limiteCredito = 0.0;
	}
	//Metodos de acceso. En los 4 casos this no es necesario.
	// No hay possibilidad de conflicto
	
	public String getTitular () {
		return this.titular;
	}
	public int getNumero() {
		return this.numero;
	}
	public double getSaldo() {
		return this.saldo;
	}
	public double getLimitCredit() {
		return this.limiteCredito;
	}
	public void setLimitCredit (double limiteCredito) {
		if(limiteCredito >= 0) {
			this.limiteCredito = limiteCredito; // this necesario
		}
	}
	public void ingresar (double cuanto) {
		if (cuanto>0) {
			this.saldo = this.saldo + cuanto; // this no necesario
		}
	}
	public boolean retirar (double cuanto) {
		double saldo;
		boolean ok;
		if (cuanto>0) {
			saldo = this.saldo - cuanto;
			if (saldo<0) {
				if (this.valAbs(saldo) <= this.limiteCredito) {
					ok = true;
					this.saldo = saldo;
				} else { 
					ok = false;
				}
			} else {
				ok = true;
				this.saldo = saldo;
			}
		} else {
			ok = false;
		}
		return ok;
	}
	private double valAbs (double n) {
		if (n>=0.0) {
			return n;
		} else {
			return -n;
		}
	}
}