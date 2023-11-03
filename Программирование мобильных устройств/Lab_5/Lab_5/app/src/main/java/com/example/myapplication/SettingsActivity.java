package com.example.myapplication;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    int calls = 0;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    int selected_radio;
    RadioGroup rbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        prefs = getSharedPreferences("Settings", 0);
        calls = prefs.getInt("calls", 0);
        calls += 1;
        editor = prefs.edit();
        rbtn = findViewById(R.id.rbtn);
        selected_radio = prefs.getInt("Radio_id", 1);
        if (calls == 1) {
            selected_radio = selected_radio % 5;
        } else {
            selected_radio += 5;
        }
        if (selected_radio == 0){
            selected_radio = 5;
        }
        rbtn.check(selected_radio);
        Log.d(TAG, "onCreate " + calls);
    }

    public void onClickResult(View view) {
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        intent.putExtra("Image", rbtn.getCheckedRadioButtonId());
        editor.putInt("calls", calls);
        editor.putInt("Radio_id", rbtn.getCheckedRadioButtonId());
        editor.apply();
        setResult(RESULT_OK, intent);
        finish();
    }
}
