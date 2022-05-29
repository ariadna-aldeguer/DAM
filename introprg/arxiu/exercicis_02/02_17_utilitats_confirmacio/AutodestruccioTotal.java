/*
 * Programa que destrueix el món.
 * Abans de fer res, demana confirmació als usuaris.
 * Nota: per si algun usuari acaba confirmant, ha estat un plaer
 * conèixer-te
 */
public class AutodestruccioTotal {
    public static void main(String[] args) {
        System.out.println("Estic apunt de destruir el món. Estàs d'acord?");
        boolean confirma = true;
        while (confirma) {
            String resposta = Entrada.readLine();
            confirma = UtilitatsConfirmacio.respostaABoolean(resposta);
            if (confirma) {
                System.out.println("Mira que és una decisió definitiva. Segur que vols?");
            }
        }
        System.out.println(
                "Sàvia resposta. " +
                "De totes maneres la destrucció del món és una tasca que ja estem fent entre tots!");
    }
}

