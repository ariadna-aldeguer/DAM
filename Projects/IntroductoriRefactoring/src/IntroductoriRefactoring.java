import java.io.*;
import java.util.Scanner;
public class IntroductoriRefactoring {

    public static void main (String[] args) throws IOException  {
    	//Reanomenar variables  
    	float[] v=construirVector();	
    	  mostraEstadisticas(v);
	      }
    public static void mostraEstadisticas(float [] v){
	      System.out.println();
	      for(int i=0;i<v.length;i++){
	            System.out.print(v[i]+", ");
	        }
	      System.out.println();
	       //Imprimir 
	        System.out.println("Mitja: "+sumaVector(v)/v.length);
	        System.out.println("Pitjor: "+Minimo(v));
	        System.out.println("Millor: "+Maximo(v));
    }
    public static float[] construirVector() {
        int as = (int) pedirNumero("Quanta gent: ",1,50);
	    float v[];v = new float[as];
	      for(int i=0;i<v.length;i++) {
	    	  v[i] = pedirNumero("Introdueix \"+(i+1)+\": ",0,10);
	    	  System.out.print(v[i]);
	        }
	      return v;
    }
    public static float Maximo(float[]v) {
    	float max=v[0];
    	for(int i=0;i<v.length;i++)
            if(v[i]>max)
                max=v[i];
    	return max;
            
    }
    public static float Minimo(float[]v) {
    	float min=v[0];
    	for(int i=0;i<v.length;i++)
    		if(v[i]<min)
    			min=v[i];
    	return min;
    }
      
    public static float sumaVector(float v[]) {
	     float suma=0;
	      for(int i=0;i<=v.length-1;i++){
	            suma += v[i];
	        }
	      return suma;
    }
    public static float pedirNumero(String str, int max, int min) {
       	Scanner sc = new Scanner(System.in);
    	System.out.print(str);
    	float as = sc.nextInt();
    	while(as>max || as<min){
	        System.out.println("ERROR");
	        System.out.println(str);
	        as = sc.nextInt();
    	}
    	return as;
    }
}
