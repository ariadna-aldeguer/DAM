package server;
public class TicTacToe {

    //reprentacions dels jugadors i del símbol buit
    private final char servidor = 'X';
    private final char cliente = 'O';
    private final char BUIT = '-';

    //turn actual
    //true = J1, false = J2
    private boolean torn;

    //tauler on jugarem
    private char TicTac[][];

    public TicTacToe() {
        this.torn = true; //Servidor
        this.TicTac = new char[3][3];
        this.inicializarTauler();
    }

    //Inicialitza el tauler amb el símbol BUIT
    private void inicializarTauler() {

        for (int i = 0; i < TicTac.length; i++) {
            for (int j = 0; j < TicTac.length; j++) {
                TicTac[i][j] = BUIT;
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
        for (int i = 0; i < TicTac.length; i++) {
            for (int j = 0; j < TicTac[0].length; j++) {
                if (TicTac[i][j] == BUIT) {
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

        for (int i = 0; i < TicTac.length; i++) {

            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbol de la fila
            simbol = TicTac[i][0];
            if (simbol != BUIT) {
                for (int j = 1; j < TicTac[0].length; j++) {
                    //sinó coincideix ja no hi haurà ramader en aquesta fila
                    if (simbol != TicTac[i][j]) {
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

        for (int j = 0; j < TicTac.length; j++) {

            //Reiniciem la coincidencia
            coincidencia = true;
            //Agafem el símbol de la columna
            simbol = TicTac[0][j];
            if (simbol != BUIT) {
                for (int i = 1; i < TicTac[0].length; i++) {
                    //sinó coincideix ja no hi haurà ramader en aquesta fila
                    if (simbol != TicTac[i][j]) {
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
        simbol = TicTac[0][0];
        if (simbol != BUIT) {
            for (int i = 1; i < TicTac.length; i++) {
                //sinó coincideix ja no hi haurà ramader en aquesta fila
                if (simbol != TicTac[i][i]) {
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
        simbol = TicTac[0][2];
        if (simbol != BUIT) {
            for (int i = 1, j = 1; i < TicTac.length; i++, j--) {
                if (simbol != TicTac[i][j]) {
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



    public int mostrarGuanyador() {

        char simbol = coincidenciaLinea();

        if (simbol != BUIT) {
            return guanyador(simbol);
        }

        simbol = coincidenciaColumna();

        if (simbol != BUIT) {
            return guanyador(simbol);
        }

        simbol = coincidenciaDiagonal();

        if (simbol != BUIT) {
            return guanyador(simbol);
        }

        return 2;

    }

    // Funcio auxiliar de l'anterior funcio

    private int guanyador(char simbol) {

                if (simbol == servidor) {
                    return Constants.SERVIDOR;
                } else {
                    return Constants.CLIENT;
                }

    }

    public void canviaTorn(){
        this.torn = !this.torn;
    }
    // Insertem en una posició d'una matriu un simbol en concret

    public void insertarEn(int fila, int columna) {
        if (torn) {
            this.TicTac[fila][columna] = servidor;
        } else {
            this.TicTac[fila][columna] = cliente;
        }
    }

    // Indicar si en una posicio hi ha una marca

    public boolean hihaValorPosicio(int fila, int columna) {
        if (this.TicTac[fila][columna] != BUIT) {
            return true;
        }
        return false;
    }

    public void printBoard(){
        String printB = "";
        for(int i =0; i<3; i++){
            for(int j=0; j<3; j++){
                printB = printB + this.TicTac[i][j] + " ";
            }
            printB = printB + "\n";
        }

        System.out.print(printB);
    }

}
