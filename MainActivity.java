package com.example.ujicoba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.view.View;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity{
    private Intent serviceIntent;
    MediaPlayer audio;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceIntent = new Intent(getApplicationContext(), MyService.class);

        audio = MediaPlayer.create(this, R.raw.sound);
        audio.setLooping(true);
    }
    public void onToggleClicked(View view){
        boolean on = ((ToggleButton) view).isChecked();
        if(on){
            startService(new Intent(getApplicationContext(), MyService.class));
        }else{
            audio.pause();
        }
    }
}