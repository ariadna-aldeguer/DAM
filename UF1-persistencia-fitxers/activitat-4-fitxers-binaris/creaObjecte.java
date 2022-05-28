import java.util.Scanner;

public class creaObjecte{
    
    public static void main (String[] args){
        final int jugador1 = 0;
        DesaiRecuperaEstat estat = new DesaiRecuperaEstat();
        Scanner sc = new Scanner(System.in);

        EstatPartida game = estat.recuperarEstat();
        if(game == null){
            game = new EstatPartida();
        }

        if(game.getTorn() == jugador1){
            System.out.println("Torn jugador 1: X");
        } else {
            System.out.println("Torn jugador 1: Y");
        }


        // Demana posicions
        try{

            game.printBoard();

            System.out.println("Posicio x:");
            int x = sc.nextInt();
            System.out.println("Posicio y");
            int y = sc.nextInt();

            // Inserta una fitxa i canvia el torn
            
            if(game.hihaValorPosicio(x,y)){
                System.out.println("Hi ha una ficha en aquesta posicio");
                game.canviaTorn();
            } else {
                game.insertarEn(x, y);
            }
            
            game.printBoard();
            if(game.fiPartida()){
                game.mostrarGuanyador();
            }
            game.canviaTorn();

            // Guarda l'objete en un fitxer
            estat.desarEstat(game);


        } catch (NumberFormatException e){
            System.out.println("No es un número");
        }
        sc.close();
    }
}