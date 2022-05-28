package com.example.clienteandroid.Thread;

import static com.example.clienteandroid.model.DefaultConstants.*;

import android.os.AsyncTask;
import android.util.Log;

import com.example.clienteandroid.MainActivity;
import com.example.clienteandroid.R;
import com.example.clienteandroid.model.Resposta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadMovement extends AsyncTask<String,Void,Resposta> {

    private Socket socket;
    MainActivity instance;
    DataInputStream dis;
    DataOutputStream dos;
    int cord1, cord2, fi, guanyador;
    byte cap;
    Resposta resposta;

    public ThreadMovement(Socket socket, MainActivity instance, int cord1, int cord2) throws IOException{
        this.socket = socket;
        this.instance = instance;
        this.cord1 = cord1;
        this.cord2 = cord2;
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
    }

    /**
     * Se conecta al servidor y trata resultado
     */
    @Override
    protected Resposta doInBackground(String... values) {

        try {
            dos.writeByte(MOVE);
            dos.writeInt(cord1);
            dos.writeInt(cord2);

            cap = dis.readByte();

            if (cap == MOVE){
                cord1 = dis.readInt();
                cord2 = dis.readInt();
                resposta = new Resposta(cap, cord1, cord2, "Servidor ha fet moviment: " + cord1 + " - " + cord2);
            } else if (cap == FINAL_GAME){
                cord1 = dis.readInt();
                cord2 = dis.readInt();
                fi = dis.readInt(); // Llegeix si guanya el servidor o taules
                if (fi == 0){ // Ha hagut guanyador
                    resposta = new Resposta(cap, guanyador, cord1, cord2, "Ha guanyat la máquina");
                } else {
                    resposta = new Resposta(cap, guanyador, cord1, cord2, "Empat");
                }
            } else if (cap == RESULT){ //
                fi = dis.readInt(); // Llegeix si hi ha guanyador(client) o taules

                if (fi == 0) { // Ha guanyat el client
                    resposta = new Resposta(cap, fi, "Has guanyat!");
                } else {
                    resposta = new Resposta(cap, fi, "EMPAT!");
                }
            }

            return resposta;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resposta;
    }

    /**
     * Oculta ventana emergente y muestra resultado en pantalla
     */
    protected void onPostExecute(Resposta resposta) {
        instance.updateUI(resposta);
        Log.i("ThreadMovemenet", resposta.getResultat());
    }
}

