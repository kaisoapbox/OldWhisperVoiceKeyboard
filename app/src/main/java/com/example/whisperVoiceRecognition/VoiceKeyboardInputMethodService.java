package com.example.whisperVoiceRecognition;

import android.Manifest;
import android.inputmethodservice.InputMethodService;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

import androidx.core.app.ActivityCompat;

import com.example.WhisperVoiceKeyboard.R;

public class VoiceKeyboardInputMethodService extends InputMethodService {

    WhisperVoiceTranscriptionDriver driver = new WhisperVoiceTranscriptionDriver();

    @Override
    public View onCreateInputView() {
        View inputView =
                getLayoutInflater().inflate(R.layout.keyboard, null);
        ToggleButton recordButton = inputView.findViewById(R.id.buttonRecord);




        recordButton.setOnCheckedChangeListener((button,checked) -> {
            if (checked) {
//                ActivityCompat.requestPermissions (VoiceKeyboardInputMethodService.this, new String[]{Manifest.permission.RECORD_AUDIO},
//                        REQUEST_RECORD_PERMISSION);
                Log.d("DSFLJ", new RustLib().helloWorld());
                Log.d("DSFLJ", new RustLib().retrieveAssetPub(getAssets()));
                startVoiceService();
            } else {
                stopVoiceService();
            }
        });

        return inputView;
    }



    private void startVoiceService() {
        Log.i("VoiceKeyboardService","Init Service");
        driver.startListening();

    }

    private void stopVoiceService() {
        Log.i("VoiceKeyboardService","Term Service");
        String text = driver.stopListeningAndRetrieveText();
        getCurrentInputConnection().commitText(text, text.length());

    }

}