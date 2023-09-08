package com.hamidul.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView song_1,song_2,song_3;
    MediaPlayer mediaPlayer;
    BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        song_1 = findViewById(R.id.song_1);
        song_2 = findViewById(R.id.song_2);
        song_3 = findViewById(R.id.song_3);

        broadcastReceiver = new InternetConnection();
        registerNetwork();
        song_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (song_1.getTag()!=null && song_1.getTag().toString().contains("Play")){
                    if (mediaPlayer!=null) mediaPlayer.release();
                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource("https://smhamidulcodding.000webhostapp.com/mp3/Alone_Sad_Ringtone.mp3");
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    icon();
                    song_1.setImageResource(R.drawable.pause_icon);
                    song_1.setTag("Pause");
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            song_1.setImageResource(R.drawable.play_icon);
                            song_1.setTag("Play");
                        }
                    });

                } else {
                    if (mediaPlayer!=null) mediaPlayer.release();
                    song_1.setImageResource(R.drawable.play_icon);
                    song_1.setTag("Play");
                }
            }
        });

        song_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (song_2.getTag()!=null && song_2.getTag().toString().contains("Play")){
                    if (mediaPlayer!=null) mediaPlayer.release();
                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource("https://smhamidulcodding.000webhostapp.com/mp3/sad_ringtone__emotional_ringtone__breakup_ringtone__.mp3");
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    icon();
                    song_2.setImageResource(R.drawable.pause_icon);
                    song_2.setTag("Pause");
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            song_2.setImageResource(R.drawable.play_icon);
                            song_2.setTag("Play");
                        }
                    });

                } else {
                    if (mediaPlayer!=null) mediaPlayer.release();
                    song_2.setImageResource(R.drawable.play_icon);
                    song_2.setTag("Play");
                }
            }
        });

        song_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (song_3.getTag()!=null && song_3.getTag().toString().contains("Play")){
                    if (mediaPlayer!=null) mediaPlayer.release();
                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource("https://smhamidulcodding.000webhostapp.com/mp3/viral_ringtone.mp3");
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    icon();
                    song_3.setImageResource(R.drawable.pause_icon);
                    song_3.setTag("Pause");
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            song_3.setImageResource(R.drawable.play_icon);
                            song_3.setTag("Play");
                        }
                    });

                } else {
                    if (mediaPlayer!=null) mediaPlayer.release();
                    song_3.setImageResource(R.drawable.play_icon);
                    song_3.setTag("Play");
                }
            }
        });

    }

    private void icon(){

        if (song_1.getTag().toString().contains("Pause")){
            song_1.setImageResource(R.drawable.play_icon);
            song_1.setTag("Play");
        }
        if (song_2.getTag().toString().contains("Pause")){
            song_2.setImageResource(R.drawable.play_icon);
            song_2.setTag("Play");
        }
        if (song_3.getTag().toString().contains("Pause")){
            song_3.setImageResource(R.drawable.play_icon);
            song_3.setTag("Play");
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
        icon();
    }

    protected void registerNetwork(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
            registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    protected void unregisterNetwork(){
        try {
            unregisterReceiver(broadcastReceiver);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterNetwork();
    }
}