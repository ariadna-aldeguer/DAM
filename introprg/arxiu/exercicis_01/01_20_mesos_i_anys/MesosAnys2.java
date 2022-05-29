
public class MesosAnys2 {
    public static void main(String[] args) {
    
    	System.out.println("Mes?"); 
    	int month = Integer.parseInt(Entrada.readLine());
    	System.out.println("Any?");
    	int year = Integer.parseInt(Entrada.readLine());
    	int monthJanuary = 1;
    	int monthDecember = 12;
    	int yearDed = year - 1;
    	int yearSum = year + 1;
    	int monthSum = month + 1;
    	int monthDed = month - 1;
    	
    		switch (month) {
    		case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11:   		
    		System.out.println("Anterior " + monthDed + "/" + year + " i posterior " + monthSum + "/" + year);
    		;
    		break;
    		case 1:
    		System.out.println("Anterior " + monthDecember + "/" + yearDed + " i posterior " + monthSum + "/" + year);
    		;
    		break;
    		case 12:
    		System.out.println("Anterior " + monthDed + "/" + year + " i posterior " + monthJanuary + "/" + yearSum);
    		break; 
    		}
   	 }
    	}
