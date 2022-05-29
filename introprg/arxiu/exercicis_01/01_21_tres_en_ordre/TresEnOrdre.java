/* Programa que et retorna tres en ordre*/

public class TresEnOrdre {
    public static void main(String[] args) {
    	System.out.println("Primer?");
   	int first = Integer.parseInt(Entrada.readLine()); 
   	System.out.println("Segon?");
   	int second = Integer.parseInt(Entrada.readLine()); 
   	System.out.println("Tercer?");
   	int third = Integer.parseInt(Entrada.readLine()); 
   	int small, medium, bigger;
   	small = medium = bigger = 0;
   	
		if (first < second && first < third && second < third){
				small = first;
			 	medium = second;
			 	bigger = third;
			 	} 
		if (first < second && first < third && second > third){
			 	 small = first;
			 	 medium = third;
			 	 bigger = second;
		 		 }
		if (first < second && first > third && second > third){
				small = third;
			 	medium = first;
			 	bigger = second;	 
				}	
				
		if (first > second && first > third && second > third){
			 	 small = third;
			 	 medium = second;
			 	 bigger = first;
			 	 }
		if (first > second && first > third && second < third){
			  	small = second;
				medium = third;
				bigger = first;						 
				}
		if (first > second && first < third && second < third){	
				small = second;
				medium = first;
				bigger = third;			
		}
			
      	System.out.println(small + ", " + medium + " i " + bigger);
	}
   }
  
 
