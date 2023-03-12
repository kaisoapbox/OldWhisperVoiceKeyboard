package com.mjm.whisperVoiceRecognition;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.WhisperVoiceKeyboard.R;


public class Preferences extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences);

        // below line is to change
        // the title of our action bar.
        getSupportActionBar().setTitle("Preferences");

        // below line is used to check if
        // frame layout is empty or not.
        if (findViewById(R.id.idFrameLayout) != null) {
            if (savedInstanceState != null) {
                return;
            }
            // below line is to inflate our fragment.
            this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.idFrameLayout, new PreferencesFragment())
                .commit();
        }
    }
}
