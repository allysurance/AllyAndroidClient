package com.example.nipunarora.ally;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Add the intent to open the Chooose Ally Activity
                startActivity(new Intent(getApplicationContext(),ChooseAlly.class));
                finish();
            }
        },3000);

    }
}
