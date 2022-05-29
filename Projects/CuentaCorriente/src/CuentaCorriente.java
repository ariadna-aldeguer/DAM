
public class CuentaCorriente {
	//Atributos
		private String titular;
		private int numero;
		private double saldo;
		private double limiteCredito;
		
		//Constructores
		public CuentaCorriente(String titular, int numero, double saldo, double limiteCredito) {
			this.titular = titular;
			this.numero = numero;
			this.saldo = 0.0;
			this.limiteCredito = 0.0;
		}
		public CuentaCorriente() {
			//this.titular = "";
			//this.numero = 0;
			//this.saldo = 0;
			//this.limiteCredito = 0;
		}
		//Metodos 
		public String getTitular() {
			return titular;
		}

		public void setTitular(String titular) {
			this.titular = titular;
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public double getSaldo() {
			return saldo;
		}

		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public double getLimiteCredito() {
			return limiteCredito;
		}

		public void setLimiteCredito(double limite) {
			if (limite>=0)
				this.limiteCredito = limite;				
		}
		public void ingresar(double ingreso) {
			if (ingreso>0)
				this.saldo = this.saldo + ingreso;
		}
					
		public boolean retirar (double cuanto) {
			double saldo;
			boolean ok;
			if (cuanto > 0) {
				saldo = this.saldo - cuanto; //this necesario
				if (saldo<0) {
						if (this.valAbs(saldo) <= this.limiteCredito) { //this no es necesario
							ok = true;
							this.saldo = saldo; //this necesario
						} else ok = false;
				} else {
					ok = true;
					this.saldo = saldo; //this necesario
				}
			} else {
				ok = false;
			}
			return ok;
		}		
			private double valAbs (double n) {
				if (n>=0.0)
					return n;
				else
					return -n;
			}
}
