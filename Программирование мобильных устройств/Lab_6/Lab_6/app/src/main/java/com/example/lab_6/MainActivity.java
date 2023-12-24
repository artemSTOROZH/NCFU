package com.example.lab_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Chronometer chron;
    Button buttonStart;
    Button buttonStop;
    Button buttonResume;
    TextView x_view;
    TextView a_view;
    TextView b_view;
    TextView c_view;
    TextView value_view;
    private long lastPause = 0;
    private long x = -30;
    private boolean count_flag = true;

    double a;
    double b;
    double c;
    String value_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chron = (Chronometer) findViewById(R.id.chronometer);
        buttonStart = (Button) findViewById(R.id.Start);
        buttonStop = (Button) findViewById(R.id.Stop);
        buttonResume = (Button) findViewById(R.id.buttonResume);
        x_view = (TextView) findViewById(R.id.x_view);
        a_view = (TextView) findViewById(R.id.a_view);
        b_view = (TextView) findViewById(R.id.b_view);
        c_view = (TextView) findViewById(R.id.c_view);
        value_view = (TextView) findViewById(R.id.Value);
        chron.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (count_flag) {
                    if (x == 30) {
                        x = -30;
                    } else {
                        x += 1;
                    }
                }
                value_string = "F(" + x + ") = ";
                x_view.setText(value_string);
                value_string = String.format(Locale.ENGLISH,"%,.4f", F(x));
                value_view.setText(value_string);
            }
        });
    }

    public void startChron(View v) {
        chron.setBase(SystemClock.elapsedRealtime());
        x = -30;
        chron.start();
        count_flag = true;
        buttonResume.setEnabled(false);
        buttonStop.setEnabled(true);
        a_view.setEnabled(false);
        b_view.setEnabled(false);
        c_view.setEnabled(false);
    }

    public void stopChron(View v) {
        count_flag = false;
        lastPause = SystemClock.elapsedRealtime();
        chron.stop();
        buttonResume.setEnabled(true);
        a_view.setEnabled(true);
        b_view.setEnabled(true);
        c_view.setEnabled(true);
    }

    public void resumeChron(View v) {
        count_flag = false;
        chron.setBase(chron.getBase() + SystemClock.elapsedRealtime() - lastPause);
        chron.start();
        count_flag = true;
        buttonResume.setEnabled(false);
        a_view.setEnabled(false);
        b_view.setEnabled(false);
        c_view.setEnabled(false);
    }

    public double F(double x)
    {
        a = Double.parseDouble(a_view.getText().toString());
        b = Double.parseDouble(b_view.getText().toString());
        c = Double.parseDouble(c_view.getText().toString());
        if (c < 0 && b != 0)
        {
            return (a*x*x + b*b*x);
        }
        else if (c > 0 && b == 0)
        {
            return ((x+a)/(x+c));
        }
        else
        {
            return x / c;
        }
    }
}