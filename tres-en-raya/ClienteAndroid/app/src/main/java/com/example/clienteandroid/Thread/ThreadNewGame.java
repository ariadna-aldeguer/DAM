package com.example.clienteandroid.Thread;

import static com.example.clienteandroid.model.DefaultConstants.*;

import android.os.AsyncTask;
import android.util.Log;

import com.example.clienteandroid.MainActivity;
import com.example.clienteandroid.model.Resposta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadNewGame extends AsyncTask<String,Void, Resposta> {

    Socket socket;
    MainActivity instance;
    DataInputStream dis;
    DataOutputStream dos;
    int cord1, cord2;
    byte cap;

    public ThreadNewGame(Socket socket, MainActivity instance) throws IOException{

        this.socket = socket;
        this.instance = instance;
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
    }


    /**
     * Se conecta al servidor y trata resultado
     * */
    @Override
    protected Resposta doInBackground(String... values){
        try {

            dos.writeByte(START_GAME);
            // 0x01 (nova partida)
            cap = dis.readByte();
            int torn = dis.readInt();

            if (torn == 1){
                cap = dis.readByte();
                cord1 = dis.readInt();
                cord2 = dis.readInt();
            }

            Log.i("ThreadNewGame", "" + cap + " - " + torn);

            Resposta resposta = new Resposta(torn, cap, cord1, cord2, "Comença la partida: ");

            return resposta;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Resposta();
    }

    /**
     * Oculta ventana emergente y muestra resultado en pantalla
     * */
    protected void onPostExecute(Resposta resposta){

        Log.i("ThreadNewGame", resposta.getResultat() + resposta.getTorn());
        Log.i("ThreadNewGame", "" + resposta.getCord1() + " - " + resposta.getCord2());
        instance.updateUI(resposta);
    }
}
