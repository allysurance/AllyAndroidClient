package com.example.nipunarora.ally;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

import com.example.nipunarora.ally.Companions.Adam.Adam_Main;
import com.example.nipunarora.ally.Companions.Eve.Eve_Main;

import java.util.Locale;

public class ChooseAlly extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextToSpeech tts;
    CardView adam,eve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ally);
        adam=(CardView)findViewById(R.id.adam);
        eve=(CardView)findViewById(R.id.eve);
        adam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Adam_Main.class));
            }
        });
        eve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Eve_Main.class));
            }
        });
    }

    @Override
    public void onInit(int i) {
        Log.d("TTS","check");
        if (i == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                //on compatible language you can facilitate your operations related to tts
                ;
                //tts.speak("Hey Buddy, I am your ally  /≥can help you find the best insurance policies also i provide you incentives on keeping yourself fit ",TextToSpeech.QUEUE_FLUSH, null,null);
                Log.d("Did he speak?","He spoke");

            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }
}
