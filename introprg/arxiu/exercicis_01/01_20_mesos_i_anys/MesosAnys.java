/* Programa que et retorna un mes menys i un més */

public class MesosAnys {
    public static void main(String[] args) {
    
    	System.out.println("Mes?"); 
    	int month = Integer.parseInt(Entrada.readLine()); 
    	System.out.println("Any?");
    	int year, yearDed, yearSum;
    	year = yearDed = yearSum = Integer.parseInt(Entrada.readLine());
	int monthDed = month - 1;
	int monthSum = month + 1;
	
	if (month == 1){
		monthDed = 12;
		yearDed = year - 1;		
	} else if (month == 12){
		monthSum = 1;
		yearSum = year + 1;
	}
	System.out.println("Anterior " + monthDed + "/" + yearDed + " i posterior " + monthSum + "/" + yearSum);
    }
}


