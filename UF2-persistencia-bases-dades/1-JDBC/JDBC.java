package projecte;
import java.sql.*;
import java.util.Scanner;

public class Main {
	
   static Scanner sc = new Scanner(System.in);
   public static void main(String[] args) {
	   
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo","root","root");
           Statement sentencia =connexion.createStatement();
           /* Ejercicio A1 - obtenir el COGNOM, OFICI i SALARI dels empleats del departament 10 */
           String sql = "select apellido, oficio, salario from emple where dept_no = 10";
           ResultSet result = sentencia.executeQuery(sql);
           System.out.println("Exercici A1: obtenir el COGNOM, OFICI i SALARI dels empleats del departament 10\n");
           while (result.next()){
        	   
               System.out.printf("Cognom: %s, Ofici: %s, Salari: %d. %n",
               result.getString(1),
               result.getString(2),
               result.getInt(3));
           }
           /* Ejercicio A2: el COGNOM de l'empleat amb màxim salari, visualitza també el seu SALARI i el nom del departament. */
           
           sql = "select apellido, salario, dnombre from emple join depart on emple.dept_no = depart.dept_no where salario = (select max(salario) from emple) limit 1";
           result = sentencia.executeQuery(sql);
           System.out.println("\nExercici 2: el COGNOM de l'empleat amb màxim salari, visualitza també el seu SALARI i el nom del departament");
           while (result.next()){
        	   
               System.out.printf("\nCognom: %s, Salari: %d, Departament: %s. %n",
               result.getString(1),
               result.getInt(2),
               result.getString(3));
           }
           
           /* Exercici A3.- Realitza un programa que busqui els departaments d'una localitat */
           System.out.println("\nExercici 3: Realitza un programa que busqui els departaments d'una localitat");
           System.out.println("Introdueix una localitat:");
           String loc = sc.nextLine();
           System.out.println();
           sql = "select apellido, dnombre from emple join depart where loc = \"" + loc + "\"";
           result = sentencia.executeQuery(sql);
           if(result.next() == false){
                System.out.println("Aquesta localitat no té empleats");
                result.close();
                sentencia.close();
                connexion.close();
                return;
           }
           while (result.next()){
        	   
               System.out.printf("Cognom: %s, Departament: %s. %n",
               result.getString(1),
               result.getString(2));
           }
           
           result.close();
           sentencia.close();
           connexion.close();
       } catch (ClassNotFoundException cn) { cn.printStackTrace();
       } catch (SQLException e) {e.printStackTrace();
       }
   }
}

