package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button buttonPlay, buttonPause, buttonStop, videoPlayerB;
    public MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPause = findViewById(R.id.buttonPause);
        buttonStop = findViewById(R.id.buttonStop);
        videoPlayerB = findViewById(R.id.videoPlayer);

        mediaPlayer = MediaPlayer.create(this, R.raw.spring);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.spring);
            }
        });

        videoPlayerB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), videoPlayer.class);
                startActivity(intent);
            }
        });

    }
}