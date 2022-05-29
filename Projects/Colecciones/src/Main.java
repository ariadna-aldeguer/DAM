import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
		
		/* |---------------------------PROBLEMA 1 -------------------------------̣|*/
		
		/*(1.A) Crea el array de strings llamado fruits, 
		 *   formado por las cadenas: Pineapple, Apple, Orange y Banana
		 */
		
		String[] fruits = new String[] {"Pineapple", "Apple", "Orange", "Banana"};
		
		
		/* (1.B)  Indica dos formas de mostrar los elementos de un array de strings */
		
		for (int i = 0; i<fruits.length;i++) {
			System.out.println(fruits[i]);
		}
		
		for(String temp: fruits) {
			System.out.println(temp);
		}
		
		/* (1.C)  ¿Cómo quedan almacenados los elementos dentro de un array estático? */
		/* 
		 * Això es lo mateix que la linia 13. 
		 * 
		fruits[0]="Pineapple";
		fruits[1]="Apple";
		fruits[2]="Orange";
		fruits[3]="Banana";
		 *		
		 */
		
		/* (1.D) Existe alguna forma de eliminar o agregar un elemento 
		 * de un array estático de strings o de un array en general? 
		 * 
		 * No es posible, hi ha truquets.  Com fer un array nova, i amb un bucle 
		 * quan arriba al elements que vols eliminar, aquest no el copies. 
		 * 
		 * La millor manera es fer una array dinámica. 
		 * 
		 */
		
		/* (1.E)  Ordena el array de strings alfabéticamente mediante el método 
		 *     estático sort de Arrays.
		 */
		
		Arrays.sort(fruits);
		for (String temp: fruits) {
			System.out.println(temp);
		}
		
		/* Llavors ara:
		 
		 fruits[0]="Apple";
		 fruits[1]="Banana";
		 fruits[2]="Orange";
		 fruits[3]="Pineapple";
		 
		 */
		
		/* (1.F) Define un array de 5 strings e introduce los 4 elementos anteriores */
		
		String[] fruits2 = new String[5];
		
		fruits2[0]="Pineapple";
		fruits2[1]="Apple";
		fruits2[2]="Orange";
		fruits2[3]="Banana";
		fruits2[4]=""; // (1.H) Per arreglar-ho es podria posar un "" al espai q falta. 
		
		Arrays.sort(fruits2); //Això donarà un error perque hi ha un espai buit. 
		/*
		 * at java.base/java.util.ComparableTimSort.binarySort(ComparableTimSort.java:262)
		 * at java.base/java.util.ComparableTimSort.sort(ComparableTimSort.java:189)
	     * at java.base/java.util.Arrays.sort(Arrays.java:1249)
	     * at Main.main(Main.java:75)
		 */
		
		/* |---------------------------PROBLEMA 2 -------------------------------̣|*/
		
		/* (2.A) Crea un array de enteros llamado numeros, formado por 40, 20, 50, 70, 10 */
		
		int numeros[] = new int[] {40,20,50,70,10};
		
		/* (2.B) Ordena el array de enteros mediante el método estático sort de la clase Arrays */
		
		Arrays.sort(numeros);
		for(int num:numeros) {
			System.out.println(num);
		}
		
		/* Resultat: 
		 * [0]:10
		 * [1]:20
		 * [2]:40
		 * [3]:50
		 * [4]:70
		 */
		
		/* (2.C) Define un array estático de 6 enteros e introduce los 5 elementos anteriores */
		
			int[] numeros2 = new int[6];
			
			numeros2[0]=40;
			numeros2[1]=20;
			numeros2[2]=50;
			numeros2[3]=70;
			numeros2[4]=10;
			
			Arrays.sort(numeros2);
			
		/* (2.D) Realiza la ordenación numérica de este array de enteros. ¿Ocurre algún error? */
			
		/* Por defecto Java inicia los enteros con 0. Por eso no falla. 
		 * 
		 * [0]=0
		 * [1]=10
		 * [2]=20
		 * [3]=40
		 * [4]=50
		 * [5]=70
		 * 
		 */
			
		/* |---------------------------PROBLEMA 4 -------------------------------̣|*/
		
		/* (4.B)  Crea un array estático de 5 objetos Habitacion */	
			
			Habitacion [] habitacionesArray = {
				 new Habitacion("James",20),  //Si no le ponemos nada al new, es clase anónima
				 new Habitacion("Mary",10),
				 new Habitacion("Jonh",80),
				 new Habitacion("Amanda",40),
				 new Habitacion("Charles",30)
		    }; 
			
			// Podriamos poner a algunas nombres y otras no
			
			/*
			Habitacion james = new Habitacion("James",20); 
			Habitacion habitacionesArray2 [] = {
			 			james,
			   		new Habitacion("Mary",10),
		      		new Habitacion("Jonh",80),
					new Habitacion("Amanda",40),
		    		new Habitacion("Charles",30)
			}
			
			james.getName();*/
			
			habitacionesArray[0].getName();
			
			//Seria lo mismo
			
			for (Habitacion temp: habitacionesArray) {
				System.out.println(temp);
			}
		/* (4.C)  Imprime el array de habitaciones anterior ¿Qué ocurre? ¿Qué se imprime? */
			
			/* Porque no tiene implementado el toString --> que te enseña el estado del objeto.
			 * 
			 * Habitacion@4b1210ee
			 * Habitacion@4d7e1886 
			 * Habitacion@3cd1a2f1
			 * Habitacion@2f0e140b
			 * Habitacion@7440e464
			 */
			
		/* (4.E) Vuelve a mostrar el contenido del array estático de habitaciones 
		 * 
		 * Habitacion [name=James, id=20]
		 * Habitacion [name=Mary, id=10]
		 * Habitacion [name=Jonh, id=80]
		 * Habitacion [name=Amanda, id=40]
		 * Habitacion [name=Charles, id=30]
		 * 
		 */
		
		/* (4.F) Realiza la ordenación del array anterior mediante Arrays.sort. ¿Qué ocurre? */
		
			// Para ordenar estáticos: sort
			// Para ordenar dinámicos: 
			// Como se ordena con un array de objetos? teniendo Strigs, ints, mezclados. 
			
			Arrays.sort(habitacionesArray);
			
			
			
			
		/* |---------------------------PROBLEMA 5 -------------------------------̣|*/
			
		/* (5.A) Crea un arrayList de objetos Habitacion */
			
			ArrayList <Habitacion> lista = new ArrayList<Habitacion>();
			
		/* (5.B) Agrega 5 habitaciones */
			
			lista.add(new Habitacion("James",20));
			lista.add(new Habitacion("Mary",10));
			lista.add(new Habitacion("Jonh",80));
			lista.add(new Habitacion("Charles",30));
			lista.add(new Habitacion("Amanda",40));
			
	   /* (5.C) Indica 3 formas diferentes de mostrar un arrayList */
			
			for (int i = 0; i<lista.size(); i++) {
				System.out.println(lista.get(i));
			}
			
			for (Habitacion temp: lista)
				System.out.println(temp);
			
			System.out.println(lista);
			
	  /* (5.D) Borra el elemento habitación que ocupa la posición 3. */
			
			lista.remove(3);
			for (Habitacion temp: lista)
				System.out.println(temp);
	 // (5.E) Borra la habitación de “Charles,30” usando el método remove(object)
			
			lista.remove(new Habitacion("Charles",30));
			for (Habitacion temp: lista)
				System.out.println(temp);
			
			// No funciona
	
	// (5.G)  Prueba de hacer de nuevo el borrado con las siguientes condiciones
			
			lista.remove(new Habitacion("Charles",30));
			for (Habitacion temp: lista)
				System.out.println(temp);
	// (5.H) Realiza una prueba con el método contains, comentando y descomentando el método equals
	
			System.out.print(lista.contains(new Habitacion("Amanda",40)));
			
	// (5.I) Ordena el arrayList inicial de habitaciones, usando en este caso el método	Collections.sort
			
			/*
			Collections.sort(lista);
			for (Habitacion temp: lista)
				System.out.println(temp);
	
			// (5.J) Realiza una ordenación puntual de lista de habitaciones, según su nombre
			
			Collections.sort(lista, new Comparator<Habitacion>() {
				@Override
				public int compareTo(Habitacion first, Habitacion second) {
					// TODO Auto-generated method stub
					return first.getName().compareTo(second.getName());
				}

			});
			
			*/
			
	// |---------------------------PROBLEMA 6 -------------------------------̣|
			
	// (6.B)  Crea un ArrayList de Productos 
			
			/*
			
			ArrayList<Producto>productos = new ArrayList <Producto>();
			Producto p1 = new Producto(468,20,"Leche");
			productos.add(p1);
			Producto p2 = new Producto(345,25,"Patatas");
			productos.add(p2);
			productos.add(new Producto(239,30,"Cereales"));
			productos.add(new Producto(293,24,"Chocolate"));
			productos.add(new Producto(239,43,"Pastel"));
			productos.add(p1);
			productos.add(p2);
			
			for(Producto temp: productos) {
				System.out.println(temp);
			}
			
			*/
		
	// (6-C) Crea un HasSet de Producto
			
			
			/*
			HashSet <Producto>productosh = new HashSet <Producto>();
			Producto p1 = new Producto(468,20,"Leche");
			productosh.add(p1);
			Producto p2 = new Producto(345,25,"Patatas");
			productosh.add(p2);
			productosh.add(new Producto(239,30,"Cereales"));
			productosh.add(new Producto(293,24,"Chocolate"));
			productosh.add(new Producto(239,43,"Pastel"));
			productosh.add(p1);
			productosh.add(p2);
			
			for(Producto temp: productosh) {
				System.out.println(temp);
			}
			
			*/
			
	// (6.D) Inserta en una HashSet de Productos los mismo productos
			
			HashSet <Producto>productosh = new HashSet <Producto>();
			productosh.add(new Producto(468,20,"Leche"));
			productosh.add(new Producto(345,25,"Patatas"));
			productosh.add(new Producto(239,30,"Cereales"));
			productosh.add(new Producto(293,24,"Chocolate"));
			productosh.add(new Producto(239,43,"Pastel"));
			productosh.add(new Producto(468,20,"Leche"));
			productosh.add(new Producto(345,25,"Patatas"));
			
			for(Producto temp: productosh) {
				System.out.println(temp);
			}
	
			
	// |---------------------------PROBLEMA 7 -------------------------------̣|		
			
	// (7.A)  Crea un Hash Map
			
			/*
			
			HashMap<String, Habitacion> habitacionesHash = new HashMap<String, Habitacion>();
			habitacionesHash.put("80", new Habitacion("James",20));
			habitacionesHash.put("10", new Habitacion("Mary",10));
			habitacionesHash.put("40", new Habitacion("John",80));
			habitacionesHash.put("20", new Habitacion("Amanda",40));
			habitacionesHash.put("30", new Habitacion("Charles",30));
			
			for (Map.Entry<String, Habitacion> entry : habitacionesHash.entrySet()) {
				String key = entry.getKey();
				Habitacion value = entry.getValue();
				System.out.println(key +" - "+value);
			}
			
			*/
			
	// (7.B) Crea una HashMap<Integer, Habitacion> indexada por claves de tipo Integer y valores de tipo Habitacion
			
			
			/*
			HashMap<Integer, Habitacion> habHash = new HashMap<Integer, Habitacion>();
			habHash.put("80", new Habitacion("James",20));
			habHash.put("10", new Habitacion("Mary",10));
			habHash.put("40", new Habitacion("John",80));
			habHash.put("20", new Habitacion("Amanda",40));
			habHash.put("30", new Habitacion("Charles",30));
			
			for (Map.Entry<Integer, Habitacion> entry : habHash.entrySet()) {
				Integer key = entry.getKey();
				Habitacion value = entry.getValue();
				System.out.println(key +" - "+value);
			}
			
			*/
	
	// (7.C) Realiza una ordenación de una hashMap por su clave alfanumérica en orden creciente.
			
			
			/*
			HashMap<String, Habitacion> habitacionesHash = new HashMap<String, Habitacion>();
			habitacionesHash.put("80", new Habitacion("James",20));
			habitacionesHash.put("10", new Habitacion("Mary",10));
			habitacionesHash.put("40", new Habitacion("John",80));
			habitacionesHash.put("20", new Habitacion("Amanda",40));
			habitacionesHash.put("30", new Habitacion("Charles",30));
			
			
			SortedSet<String> keys = new TreeSet<>(habitacionesHash.keySet());
			
			for (String key : keys) {
				Habitacion value = habitacionesHash.get(key);
				System.out.println(key +" - "+value);
			}
			
			*/
			
	// (7.D) Realiza una ordenación de una hashMap por su clave alfanumérica en orden creciente
			
			/*
			
			HashMap<String, Habitacion> habitacionesHash = new HashMap<String, Habitacion>();
			habitacionesHash.put("80", new Habitacion("James",20));
			habitacionesHash.put("10", new Habitacion("Mary",10));
			habitacionesHash.put("40", new Habitacion("John",80));
			habitacionesHash.put("20", new Habitacion("Amanda",40));
			habitacionesHash.put("30", new Habitacion("Charles",30));
			
			TreeMap treeMap = new TreeMap <String, Habitacion>(habitacionesHash);
			Iterator it = treeMap.entrySet().iterator();
			
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				String key = (String) entry.getKey();
				Habitacion value = (Habitacion) entry.getValue();
				System.out.println(key +" - "+value);
			}
			
			*/
			
	// (7.E) ) Realiza una ordenación de una HashMap por el atributo entero de Habitacion en orden creciente.
			
			HashMap<String, Habitacion> habitacionesHash = new HashMap<String, Habitacion>();
			habitacionesHash.put("80", new Habitacion("James",20));
			habitacionesHash.put("10", new Habitacion("Mary",10));
			habitacionesHash.put("40", new Habitacion("John",80));
			habitacionesHash.put("20", new Habitacion("Amanda",40));
			habitacionesHash.put("30", new Habitacion("Charles",30));
			
			
			habitacionesHash=sortedMapByInteger(habitacionesHash);
			
			for (Map.Entry<String, Habitacion> entry : habitacionesHash.entrySet()) {
				String key = entry.getKey();
				Habitacion value = entry.getValue();
				System.out.println(key +" - "+value);
			}
			
	}

	private static HashMap<String, Habitacion> sortedMapByInteger(HashMap<String, Habitacion> unsorted) {
		
		List<Entry<String, Habitacion>> list = new LinkedList<Entry<String,Habitacion>>(unsorted.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Habitacion>>(){

			@Override
			public int compare(Entry<String, Habitacion> arg0, Entry<String, Habitacion> arg1) {
				return arg0.getValue().getId()-arg1.getValue().getId();
			}
		});
		
		HashMap <String, Habitacion> sorted = new LinkedHashMap<String, Habitacion>();
		for(Entry<String, Habitacion> item: list) {
			sorted.put(item.getKey(), item.getValue());
		}
		return sorted;
	}
	
}
