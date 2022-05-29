public class UsaGatRenat{
    public static void main(String[] args){
        
        GatRenat renat = new GatRenat();
        System.out.printf("Vides inicials: %d%n", renat.vides);
        System.out.printf("Posició inicial: %s%n", renat.posicio);
        
        renat.setPosicio("assegut");
        
        System.out.printf("Posició final: %s%n", renat.posicio);
        System.out.println();
        
    }
}
