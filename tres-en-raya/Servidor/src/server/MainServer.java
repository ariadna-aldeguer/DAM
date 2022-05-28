package server;


import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;



/**
 * @author Ariadna Aldeguer, Laura Martín, Miquel Massó
 */
public class MainServer {
    /**
     * Puerto
     */
    private final static int PORT = 5000;

 
    public static void main(String[] args) {
        try {
            //Socket de servidor para esperar peticiones de la red
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor> Servidor iniciado");
            System.out.println("Servidor> En espera de cliente...");
            //Socket de cliente
            Socket clientSocket;
            while (true) {
                //en espera de conexion, si existe la acepta
                clientSocket = serverSocket.accept();
                //Para leer lo que envie el cliente
                
                Game game = new Game(clientSocket);
                game.startGame();
      
            }
        
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}  