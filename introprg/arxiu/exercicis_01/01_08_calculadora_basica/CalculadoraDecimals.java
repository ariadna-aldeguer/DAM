/*
 * Aquest programa implementa una calculadora bàsica
 *
 * Demana dos nombres per entrada estàndard i mostra el
 * resultat de sumar-los, restar-li el segon al primer, multiplicar-los,
 * dividir el primer entre el segon.
 *
 * El programa no controla valors no adequats d'entrada
 */

class CalculadoraDecimals {
    public static void main(String[] args) {

        // obté operands d'entrada
        System.out.println("Primer operand:");
        double primerOperand = Double.parseDouble(Entrada.readLine());
        System.out.println("Segon operand:"); 
        double segonOperand = Double.parseDouble(Entrada.readLine());

        // operacions
        double suma = primerOperand + segonOperand;
        double resta = primerOperand - segonOperand;
        double multiplicacio = primerOperand * segonOperand;
        double divisio = primerOperand / segonOperand; // Aqui tinc un dubte, per què si dona decimals, no sabria com fer-ho per mostrar-ho. 
       
        // mostra resultats
        System.out.println("" + primerOperand + " + " + segonOperand + " = " + suma);
        System.out.println("" + primerOperand + " - " + segonOperand + " = " + resta);
        System.out.println("" + primerOperand + " x " + segonOperand + " = " + multiplicacio);
        System.out.println("" + primerOperand + " : " + segonOperand + " = " + divisio);
    }
}
