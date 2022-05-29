/*
 * Programa que destrueix l'equip en el que s'executa.
 * Abans de fer res, demana confirmació als usuaris.
 * Nota: potser al final no s'atreveix a fer-ho
 */

public class Autodestruccio {
    public static void main(String[] args) {
        System.out.println("Estic apunt de destruir el teu ordinador. Estàs d'acord?");
        String resposta = Entrada.readLine();
        boolean confirma = UtilitatsConfirmacio.respostaABoolean(resposta);
        destrueixSiConfirmat(confirma);
    }
    
    public static void destrueixSiConfirmat(boolean confirmacio) {
        if (! confirmacio) {
            System.out.println("Uf! Ha estat d'un pel!");
            return;
        }
        System.out.println("El teu equip es destruirà en");
        for (int i=5; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("Valeeee. Anava de farol!");
    }
}
    
