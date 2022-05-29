/* Programa que et retorna un mes menys i un més */

public class MesosAnys3 {
    public static void main(String[] args) {
    
    	System.out.println("Mes?"); 
    	int mes = Integer.parseInt(Entrada.readLine()); 
    	System.out.println("Any?");
    	int any = Integer.parseInt(Entrada.readLine()); 
    	
    	if (mes >2 && mes < 12){
    	int mesAnt = mes - 1;
    	System.out.print("Anterior " + mesAnt + "/" + any);
    		} else {
    	i	nt anyAnt = any - 1;
    	int mesEn = 1;
    	System.out.print("Anterior " + mesEn + "/" + anyAnt);
    	} if (mes > 1 && mes < 11){
    	int mesSig = mes + 1;
    	System.out.print(" i posterior " + mesSig + "/" + any);
    	} else { 
    	int anySig = any + 1;
    	int mesDic = 1; 
    	System.out.print(" i posterior " + mesDic + "/" + anySig); 
    	}
    }
  }
    	
    	
    	
