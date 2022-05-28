package com.example.clienteandroid;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.clienteandroid.model.DefaultConstants.*;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import com.example.clienteandroid.Thread.ThreadConnection;
import com.example.clienteandroid.Thread.ThreadMovement;
import com.example.clienteandroid.Thread.ThreadNewGame;
import com.example.clienteandroid.model.Resposta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * Controles
     * */

    Button conn, start;
    EditText ip_txt, port_txt, result;
    TextView error;
    public Socket socket;
    ThreadConnection connection;
    int cord1, cord2;

    private Context context = this;

    MainActivity instance;
    Button[][] arrayButtons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ip_txt = findViewById(R.id.ip_txt);
        port_txt = findViewById(R.id.port_txt);
        result = findViewById(R.id.result_txt);
        conn = findViewById(R.id.conn_btn);
        start = findViewById(R.id.start_btn);
        error = findViewById(R.id.error_txt);

        instance = this;

        start.setEnabled(false);
        error.setVisibility(View.GONE);

        arrayButtons = new Button[3][3];

        arrayButtons[0][0] = findViewById(R.id.btn00);
        arrayButtons[0][1] = findViewById(R.id.btn01);
        arrayButtons[0][2] = findViewById(R.id.btn02);
        arrayButtons[1][0] = findViewById(R.id.btn10);
        arrayButtons[1][1] = findViewById(R.id.btn11);
        arrayButtons[1][2] = findViewById(R.id.btn12);
        arrayButtons[2][0] = findViewById(R.id.btn20);
        arrayButtons[2][1] = findViewById(R.id.btn21);
        arrayButtons[2][2] = findViewById(R.id.btn22);
        setColorButtons("verde");

        enableButtons(false);

        conn.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View view) {
                    String ip = ip_txt.getText().toString();
                    int port = 0;
                    if(port_txt.getText().toString().length() > 0){
                        port = Integer.parseInt(port_txt.getText().toString());
                        error.setEnabled(false);
                        error.setVisibility(View.GONE);
                    } else {
                        error.setVisibility(View.VISIBLE);
                    }

                    if(!ip.equals("") && port!=0){
                        connection = new ThreadConnection(ip, port, instance);
                        connection.execute();
                    }else{
                        Toast.makeText(getApplicationContext(), "Ip o port", Toast.LENGTH_LONG).show();
                    }
                }
            }
        );

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                socket = connection.getSocket();
                try {
                    ThreadNewGame newGame = new ThreadNewGame(socket, instance);
                    Toast.makeText(context, "Comença la partida", Toast.LENGTH_SHORT).show();
                    newGame.execute();
                    removeButtons();
                    setColorButtons("black");
                    enableButtons(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void updateUI(Resposta resposta){
        switch (resposta.getCap()){
            case CONNECTION_OK:
                start.setEnabled(true);
                conn.setEnabled(false);
                port_txt.setEnabled(false);
                ip_txt.setEnabled(false);

                error.setVisibility(View.VISIBLE);
                error.setText("Conectado");
                break;
            case CONNECTION_KO:
                error.setText("CONNECTED KO");
                error.setVisibility(View.VISIBLE);
                break;
            case MOVE:
                error.setText("");
                cord1 = resposta.getCord1();
                cord2 = resposta.getCord2();
                Log.i("MainActivity", "cord1" + cord1 + " cord2 " + cord2);
                enableButtons(true);
                arrayButtons[cord1][cord2].setText("X");
                arrayButtons[cord1][cord2].setTextColor(Color.YELLOW);
                break;
            case FINAL_GAME: // Empate
                enableButtons(true);
                cord1 = resposta.getCord1();
                cord2 = resposta.getCord2();
                arrayButtons[cord1][cord2].setText("X");
                arrayButtons[cord1][cord2].setTextColor(Color.YELLOW);
                disableAllButton();
                error.setText(resposta.getResultat());
                Toast.makeText(this, resposta.getResultat(), Toast.LENGTH_SHORT).show();
                setColorButtons("verde");
                break;
            case RESULT:
                disableAllButton();
                error.setText(resposta.getResultat());
                Toast.makeText(this, resposta.getResultat(), Toast.LENGTH_SHORT).show();
                setColorButtons("verde");
        }
    }

    public void clickButton(View view) throws IOException{
        String tag = view.getTag().toString();
        int cord1 = Integer.valueOf("" + tag.charAt(0));
        int cord2 = Character.getNumericValue(tag.charAt(1));
        Log.i("MainActivity ClickBtn", "posicio -->" + cord1 + "-" + cord2);
        arrayButtons[cord1][cord2].setText("O");
        arrayButtons[cord1][cord2].setTextColor(Color.RED);
        ThreadMovement move = new ThreadMovement(socket, instance, cord1, cord2);
        move.execute();
        enableButtons(false);
    }

    public void enableButtons(boolean status){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if (arrayButtons[i][j].getText() != ""){
                    arrayButtons[i][j].setEnabled(false);
                } else {
                    arrayButtons[i][j].setEnabled(status);
                }
            }
        }
    }
    public void disableAllButton(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                arrayButtons[i][j].setEnabled(false);
            }
        }
    }
    public void removeButtons(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                arrayButtons[i][j].setText("");
            }
        }
        setColorButtons("verde");
    }
    public void setColorButtons(String color){
        if (color.equals("black")){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    arrayButtons[i][j].setBackgroundColor(Color.BLACK);
                }
            }
        } else {
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    arrayButtons[i][j].setBackgroundColor(Color.parseColor("#1cbaa4"));
                }
            }
        }
    }
}