package com.example.storozhenko_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button)findViewById(R.id.b1);
        b.setOnClickListener(click1);
    }
    public void onButtonClick(View v){
        ((Button)v).setText("Нажалась");
        Toast.makeText(this, "нажата кнопка_1", Toast.LENGTH_SHORT).show();
    }
    public void onClick_1(View v){
        ((Button)v).setText("Нажалась");
        Toast.makeText(this, "нажата кнопка_2", Toast.LENGTH_SHORT).show();
    }
    public void onClickRandom(View v){
        String number;
        number = Long.toString(Math.round(Math.random() * 100));
        Toast.makeText(this, number, Toast.LENGTH_SHORT).show();
    }
    View.OnClickListener click1 = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            /*((Button)v).setText("Нажалась");*/
            onClickRandom(v);
        }
    };
    public void onClickName_1(View v){
        Button target_button = findViewById(R.id.button_1);
        target_button.setText("Стороженко");
        Button button_2 = findViewById(R.id.button_2);
        Button button_3 = findViewById(R.id.button_3);
        button_2.setText("");
        button_3.setText("");
    }
    public void onClickName_2(View v){
        Button target_button = findViewById(R.id.button_2);
        target_button.setText("Стороженко");
        Button button_1 = findViewById(R.id.button_1);
        Button button_3 = findViewById(R.id.button_3);
        button_1.setText("");
        button_3.setText("");
    }
    public void onClickName_3(View v){
        Button target_button = findViewById(R.id.button_3);
        target_button.setText("Стороженко");
        Button button_1 = findViewById(R.id.button_1);
        Button button_2 = findViewById(R.id.button_2);
        button_1.setText("");
        button_2.setText("");
    }
}