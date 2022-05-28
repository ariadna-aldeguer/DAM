import java.io.Serializable;

public class EstatPartida implements Serializable{
    private final char jugador1 = 'X';
    private final char jugador2 = 'O';
    private final char BUIT = '-';
    private char EstatPartida[][];
    private boolean torn;

    public EstatPartida() {
        this.torn = true; //Servidor
        this.EstatPartida = new char[3][3];
        this.inicializarTauler();
    }
    
    public void inicializarTauler() {

        for (int i = 0; i < EstatPartida.length; i++) {
            for (int j = 0; j < EstatPartida.length; j++) {
                EstatPartida[i][j] = BUIT;
            }
        }
    }

    // Indica si es el fin de la partida, acaba cuando hay un ganador o el tablero esta lleno

    public boolean fiPartida() {

        if (taulerPle()
                || coincidenciaLinea() != BUIT
                || coincidenciaColumna() != BUIT
                || coincidenciaDiagonal() != BUIT) {
            return true;
        }
        return false;
    }

    //Indica si el tablero esta llena cuando el simbolo por defecto aparezca,
    public boolean taulerPle() {
        for (int i = 0; i < EstatPartida.length; i++) {
            for (int j = 0; j < EstatPartida[0].length; j++) {
                if (EstatPartida[i][j] == BUIT) {
                    return false;
                }
            }
        }
        return true;
    }

    // Indica si hay un ganador en una linea

    private char coincidenciaLinea() {

        char simbol;
        boolean coincidencia;

        for (int i = 0; i < EstatPartida.length; i++) {

            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbol de la fila
            simbol = EstatPartida[i][0];
            if (simbol != BUIT) {
                for (int j = 1; j < EstatPartida[0].length; j++) {
                    //sinó coincideix ja no hi haurà ramader en aquesta fila
                    if (simbol != EstatPartida[i][j]) {
                        coincidencia = false;
                    }
                }

                //Si no es fica a l'if, torno el símbol guanyador
                if (coincidencia) {
                    return simbol;
                }
            }
        }

        //Si no hi ha guanyador, torno el símbol per defecte
        return BUIT;

    }

    //Indica si hay un ganador en una columna

    private char coincidenciaColumna() {

        char simbol;
        boolean coincidencia;

        for (int j = 0; j < EstatPartida.length; j++) {

            //Reiniciem la coincidencia
            coincidencia = true;
            //Agafem el símbol de la columna
            simbol = EstatPartida[0][j];
            if (simbol != BUIT) {
                for (int i = 1; i < EstatPartida[0].length; i++) {
                    //sinó coincideix ja no hi haurà ramader en aquesta fila
                    if (simbol != EstatPartida[i][j]) {
                        coincidencia = false;
                    }
                }

                //Si no es fica a l'if, torno el símbol guanyador
                if (coincidencia) {
                    return simbol;
                }
            }
        }

        //Si no hi ha guanyador, torno el símbol per defecte
        return BUIT;

    }

    // Comproba les diagonals

    private char coincidenciaDiagonal() {

        char simbol;
        boolean coincidencia = true;

        //Diagonal principal
        simbol = EstatPartida[0][0];
        if (simbol != BUIT) {
            for (int i = 1; i < EstatPartida.length; i++) {
                //sinó coincideix ja no hi haurà ramader en aquesta fila
                if (simbol != EstatPartida[i][i]) {
                    coincidencia = false;
                }
            }

            //Si no es fica a l'if, torno el símbol guanyador
            if (coincidencia) {
                return simbol;
            }
        }

        coincidencia = true;

        //Diagonal inversa
        simbol = EstatPartida[0][2];
        if (simbol != BUIT) {
            for (int i = 1, j = 1; i < EstatPartida.length; i++, j--) {
                if (simbol != EstatPartida[i][j]) {
                    coincidencia = false;
                }
            }

            if (coincidencia) {
                return simbol;
            }
        }
        return BUIT;
    }

    // Mostra el guanyador de la partida

    public int getTorn(){
        if(torn){
            return 0;
        } else {
            return 1;
        }
    }


    // Funcio auxiliar de l'anterior funcio

    public void mostrarGuanyador() {

        if (torn) {
            System.out.println("Ha guanyat el jugador X");
        } else {
            System.out.println("Ha guanyat el jugador O");
        }
        inicializarTauler();
    }

    public void canviaTorn(){
        this.torn = !this.torn;
    }
    // Insertem en una posició d'una matriu un simbol en concret

    public void insertarEn(int fila, int columna) {
        if (torn) {
            this.EstatPartida[fila][columna] = jugador1;
        } else {
            this.EstatPartida[fila][columna] = jugador2;
        }
    }

    // Indicar si en una posicio hi ha una marca

    public boolean hihaValorPosicio(int fila, int columna) {
        if (this.EstatPartida[fila][columna] != BUIT) {
            return true;
        }
        return false;
    }

    public void printBoard(){
        String printB = "";
        for(int i =0; i<3; i++){
            for(int j=0; j<3; j++){
                printB = printB + this.EstatPartida[i][j] + " ";
            }
            printB = printB + "\n";
        }

        System.out.print(printB);
    }

}