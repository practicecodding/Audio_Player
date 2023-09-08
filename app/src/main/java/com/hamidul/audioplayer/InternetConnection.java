package com.hamidul.audioplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.widget.Toast;

public class InternetConnection extends BroadcastReceiver {
    MediaPlayer mediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (isConnected(context)){
            if (mediaPlayer!=null) mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(context,R.raw.voice_internet_connected);
            mediaPlayer.start();
        }else {
            if (mediaPlayer!=null) mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(context,R.raw.voice_no_internet);
            mediaPlayer.start();
        }
    }
    public boolean isConnected (Context context){
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return (networkInfo!=null && networkInfo.isConnected());
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

}
