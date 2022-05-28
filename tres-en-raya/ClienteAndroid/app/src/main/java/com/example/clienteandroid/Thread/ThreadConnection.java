package com.example.clienteandroid.Thread;

import static com.example.clienteandroid.model.DefaultConstants.*;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.example.clienteandroid.MainActivity;
import com.example.clienteandroid.model.Resposta;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThreadConnection extends AsyncTask<Void, Void, Resposta> {

    String ip;
    int port;
    Socket socket;
    MainActivity instance;
    Resposta resposta;


    /**
     * Ventana que bloqueara la pantalla del movil hasta recibir respuesta del servidor
     * */
    ProgressDialog progressDialog;

    public ThreadConnection(String ip, int port, MainActivity instance){
        this.ip = ip;
        this.port = port;
        this.instance = instance;
        resposta = new Resposta();
    }

    /**
     * muestra una ventana emergente
     * */
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        progressDialog = new ProgressDialog(instance);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setTitle("Connecting to server");
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
    }

    @Override
    protected Resposta doInBackground(Void... params) {

        try {
            //Se conecta al servidor
            InetAddress serverAddr = InetAddress.getByName(ip);
            Log.i("ThreadConnection", "Connecting...");
            socket = new Socket(serverAddr, port);
            Log.i("ThreadConnection", "Connected to server");

        }catch (UnknownHostException ex) {
            Log.e("ThreadConnection", "" + ex.getMessage());
            resposta.setCap(CONNECTION_KO);
            resposta.setResultat("Error");
            return resposta;
        } catch (IOException ex) {
            Log.e("ThreadConnection", "" + ex.getMessage());
            resposta.setCap(CONNECTION_KO);
            return resposta;
        }
        resposta.setCap(CONNECTION_OK);
        return resposta;
    }

    @Override
    protected void onPostExecute(Resposta resposta){
        progressDialog.dismiss();
        instance.updateUI(resposta);

        Log.i("ThreadConnection onPost", "Connexió: " + resposta.getResultat());
    }

    public Socket getSocket() {
        return socket;
    }
}

