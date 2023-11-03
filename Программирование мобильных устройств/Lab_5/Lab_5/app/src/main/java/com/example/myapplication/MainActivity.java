package com.example.myapplication;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView txt_name;
    TextView txt_description;
    ImageView img_view;
    Drawable image;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String structure_name;
    String description;
    int radio_id;
    HashMap<String, String> descriptions = new HashMap<String, String>();
    ArrayList<Drawable> images = new ArrayList<Drawable>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fill_images();
        setContentView(R.layout.activity_main);
        txt_name = findViewById(R.id.txt_name);
        txt_description = findViewById(R.id.txt_descr);
        img_view = findViewById(R.id.img);
        prefs = getSharedPreferences("Main", 0);
        editor = prefs.edit();
        txt_name.setText(prefs.getString("structure_name", ""));
        txt_description.setText(prefs.getString("description", ""));
        img_view.setImageDrawable(images.get(prefs.getInt("Image", 1)));
        Log.d(TAG, "onCreate " + structure_name);
    }

    @Override
    protected void onPause(){
        super.onPause();
        image = img_view.getDrawable();
        structure_name = (String)txt_name.getText();
        description = (String)txt_description.getText();
        Log.d(TAG, "onPause " + structure_name);
    }

    @Override
    protected void onDestroy(){
        SharedPreferences settings = getSharedPreferences("Settings", 0);
        SharedPreferences.Editor editor1 = settings.edit();
        editor1.remove("calls");
        editor1.commit();
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        fill_dict();
        radio_id = data.getExtras().getInt("Image");
        switch (reqCode) {
            case 1: {
                switch (radio_id % 5) {
                    case 1:
                        image = ResourcesCompat.getDrawable(getResources(), R.drawable.stack, null);
                        structure_name = "Стек";
                        description = descriptions.get("Стек"); break;
                    case 2:
                        image = ResourcesCompat.getDrawable(getResources(), R.drawable.queue, null);
                        structure_name = "Очередь";
                        description = descriptions.get("Очередь"); break;
                    case 3:
                        image = ResourcesCompat.getDrawable(getResources(), R.drawable.deque, null);
                        structure_name = "Дек";
                        description = descriptions.get("Дек"); break;
                    case 4:
                        image = ResourcesCompat.getDrawable(getResources(), R.drawable.singly_linked_list, null);
                        structure_name = "Односвязный список";
                        description = descriptions.get("Односвязный список"); break;
                    case 0:
                        image = ResourcesCompat.getDrawable(getResources(), R.drawable.two_linked_list, null);
                        structure_name = "Двусвязный список";
                        description = descriptions.get("Двусвязный список"); break;
                }
            }

        }
        txt_name.setText(structure_name);
        txt_description.setText(description);
        img_view.setImageDrawable(image);
        editor.putString("structure_name", structure_name);
        editor.putString("description", description);
        editor.putInt("Image", 1);
        editor.apply();
    }

    public void btnClickSettings(View view){
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivityForResult(intent, 1);
    }

    public void btnClickInfo(View view){
        Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
        startActivity(intent);
    }
    private void fill_dict(){
        descriptions.put("Стек", "Абстрактный тип данных, представляющий собой коллекцию элементов, организованных по принципу LIFO (last in - first out)," +
                " то есть добавление и удаление элементов возможно лишь из начала очереди");

        descriptions.put("Очередь","Абстрактный тип данных, доступ к элементам которого организован по правилу FIFO (first in - first out)" +
                ", то есть добавление элемента возможно только в конец очереди, а выборка - только из начала очереди, при этом выбранный элемент удаляется");

        descriptions.put("Дек", "Cтруктура данных, представляющая из себя список элементов, " +
                "в которой добавление новых элементов и удаление существующих производится с обоих концов. Дек можно воспринимать как двустороннюю очередь");

        descriptions.put("Односвязный список", "Динамическая структура данных, состоящая из элементов одного типа, связанных между собой посредством указателей. " +
                "При этом элемент, на которого нет ссылки, является головным, а последний элемент списка указывает на NULL ");

        descriptions.put("Двусвязный список", "Динамическая структура данных, состоящая из узлов, содержащих данные и ссылки на следующий и предыдущий узел списка.");
    }

    private void fill_images(){
        images.add(getDrawable(R.drawable.stack));
        images.add(getDrawable(R.drawable.queue));
        images.add(getDrawable(R.drawable.deque));
        images.add(getDrawable(R.drawable.singly_linked_list));
        images.add(getDrawable(R.drawable.two_linked_list));
    }

}
