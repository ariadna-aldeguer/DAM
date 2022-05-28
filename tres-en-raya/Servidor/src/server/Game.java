package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class Game {

    Socket clientSocket;
    private DataInputStream dis;
    private DataOutputStream dos;
    Random random;
    int cord1;
    int cord2;

    public Game(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;

        dis = new DataInputStream(clientSocket.getInputStream());
        dos = new DataOutputStream(clientSocket.getOutputStream());
    }

    public void startGame() throws IOException {
        Boolean gameEnded = false;

        byte header;
        TicTacToe game = new TicTacToe();
        while (!gameEnded) {
            header = dis.readByte();

            System.out.println("____" + header);

            switch (header) {
                case Constants.START_GAME:
                    game = new TicTacToe();

                    System.out.println("new game created");
                    System.out.println("____" + header);

                    /* Escolleix qui comença*/
                    int torn = new Random().nextInt(2); 

                    /* S'envia capçalera Star Game i el torn */
                    dos.writeByte(Constants.START_GAME); // Capçalera comença el joc
                    System.out.println("Envio: " + Constants.START_GAME);
                    dos.writeInt(torn); // Enviem el torn de qui comença
                    System.out.println("Torn: " + torn);

                    /* Si comença el servidro*/
                    if (torn == 1) { // Si comença el servidor

                        dos.writeByte(Constants.MOVE); // S'envia capçalera de moviment
                        System.out.println("Envio cap: " + Constants.MOVE);

                        /* Posar fitxa a un lloc lliure */
                        boolean trobat = false;
                        int i = 0;
                        int y = 0;
                        while (i <= 2 && !trobat) {
                            while (y <= 2 && !trobat) {
                                if (!game.hihaValorPosicio(i, y)) {
                                    game.insertarEn(i, y);
                                    trobat = true;

                                    /* S'envia les coordenades */
                                    dos.writeInt(i); // Coord1
                                    dos.writeInt(y); // Coord2

                                    System.out.println("Envio cordenades " + y + i);
                                    
                                }
                                y++;
                            }
                            i++;
                        }
                    }


                    game.canviaTorn();
                    break;

                case Constants.MOVE:
                    
                    /* Es llegeix les coordenades que es reben */
                    System.out.println("Llegeixo: " + header);
                    int c1 = dis.readInt();
                    int c2 = dis.readInt();
                    System.out.println("Lleixo : " + c1 + c2);
                    

                    game.insertarEn(c1, c2);
                    game.printBoard();
                    game.canviaTorn();

                    if (game.fiPartida()) { // Comprova si ha guanyat el client o empat al posar la fitxar
                        dos.writeByte(Constants.RESULT);
                        System.out.println("Envio cap: " + Constants.RESULT);
                        int resultat = game.mostrarGuanyador();
                        if (resultat == Constants.CLIENT) {
                            dos.writeInt(0); // Ha guanyat client
                            System.out.println("Envio: 0");
                        } else if (resultat == Constants.EMPAT) {
                            dos.writeInt(1); // hi ha hagut emp
                            System.out.println("Envio: 1" );
                        }
                        
                        break;
                    }


                    /* Escolleix un lloc buit per posar la fitxa */
                    boolean trobat = false;
                    int i = 0;
                    int y = 0;
                    while (i <= 2 && !trobat) {
                        y = 0;
                        while (y <= 2 && !trobat) {
                            if (!game.hihaValorPosicio(i, y)) {
                                game.printBoard();
                                game.insertarEn(i, y);
                                cord1 = i;
                                cord2 = y;
                                System.out.println("Envio: " + y + i);
                                
                                trobat = true;
                                game.printBoard();
                                game.canviaTorn();
                            }
                            y++;
                        }
                        i++;
                    }
                    game.printBoard();
                    /* Comprova si ha guanyat amb el moviment */
                    if (game.fiPartida()) {
                        dos.writeByte(Constants.FINAL_GAME);
                        dos.writeInt(cord1); // Coord1
                        dos.writeInt(cord2); // Coord2
                        System.out.println("Envio cap: " + Constants.FINAL_GAME);
                        System.out.println("Envio mov: " + cord1 + cord2);
                        int resultat = game.mostrarGuanyador();
                        if (resultat == Constants.SERVIDOR) {
                            dos.writeInt(0); // Ha guanyat servidor
                            System.out.println("Envio: 0");
                        } else if (resultat == Constants.EMPAT) {
                            dos.writeInt(1); // hi ha hagut emp
                            System.out.println("Envio: 1");
                        }
                        
                        break;
                    } else {
                        /* S'envia la capçalera de moviment i les coordenades */
                        dos.writeByte(Constants.MOVE); // Capçalera de moviment
                        dos.writeInt(cord1); // Coord1
                        dos.writeInt(cord2); // Coord2
                        System.out.println("Envio cap: " + Constants.MOVE);
                        System.out.println("Envio mov: " + cord1 + cord2);
                    }
                    
                    break;
                default:
                    gameEnded = true;
                    System.out.println("The read header is not a valid header");
            }
        }
        clientSocket.close();
    }
}
