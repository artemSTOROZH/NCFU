package com.example.lab_7;

import static java.sql.Types.NULL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;

import java.sql.Array;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import kotlin.text.Regex;

public class MainActivity extends AppCompatActivity {

    String[] products;
    String[] langs;
    String phone_number;
    Spinner languages_spin;
    Button validate_button;
    ArrayMap<EditText, Regex> edits_regex = new ArrayMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        products = getResources().getStringArray(R.array.products);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, products);
        ((Spinner)findViewById(R.id.spinner_products)).setAdapter(adapter);
        langs = getResources().getStringArray(R.array.Languages);
        ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, langs);
        validate_button = findViewById(R.id.button_validate);

        EditText edit_date = findViewById(R.id.BirthDate_edit);
        edit_date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(v.hasFocus())
                {
                    showDP(v);
                }
            }
        });

        /*Заполнение словаря - массива, который связывает текстовые поля с их регулярными выражениями.
        * Нужен для валидации всех текстовых полей в цикле*/
        edits_regex.put((EditText)findViewById(R.id.FIO_edit), new Regex("^[a-zA-Zа-яА-Я]{1,} [a-zA-Zа-яА-Я]{1,} [a-zA-Zа-яА-Я]{1,}"));
        edits_regex.put((EditText)findViewById(R.id.Phone_edit), new Regex("7-[0-9]{3}-[0-9]{3}-[0-9]{4}"));
        edits_regex.put((EditText)findViewById(R.id.Login_edit), new Regex("^[a-zA-Z0-9_]+$"));
        edits_regex.put((EditText)findViewById(R.id.Email_edit), new Regex("^[a-zA-Z]{1}[a-zA-Z0-9_.~']{4,30}@[a-zA-Z]{4,10}.[a-zA-Z]{2,10}"));
        edits_regex.put((EditText)findViewById(R.id.Password_edit), new Regex("^[a-zA-Z0-9~,.!?%$&*+=]{1,30}"));
        edits_regex.put((EditText)findViewById(R.id.RepPassword_edit), new Regex("^[a-zA-Z0-9~,.!?%$&*+=]{1,30}"));
        edits_regex.put((EditText)findViewById(R.id.BirthDate_edit), new Regex("^(19[0-9][0-9]|200[0-9]|201[0-9]|202[0-3])-(0[1-9]|1[1-2])-(0[1-9]|1[0-9]|2[0-9]|3[0-1])"));
    }

    private void changeLocale(Locale locale)
    {
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getBaseContext().getResources()
                .updateConfiguration(configuration,
                        getBaseContext()
                                .getResources()
                                .getDisplayMetrics());
        TextView FIO_view = (TextView) findViewById(R.id.FIO_view);
        FIO_view.setText(R.string.FIO);
        TextView Login_view = (TextView) findViewById(R.id.Login_view);
        Login_view.setText(R.string.Login);
        TextView Email_view = (TextView) findViewById(R.id.Email_view);
        Email_view.setText(R.string.Email);
        TextView Phone_view = (TextView) findViewById(R.id.Phone_view);
        Phone_view.setText(R.string.Phone_number);
        TextView Password_view = (TextView) findViewById(R.id.Password_view);
        Password_view.setText(R.string.Password);
        TextView RepPassword_view = (TextView) findViewById(R.id.RepPassword_view);
        RepPassword_view.setText(R.string.Rep_Password);
        TextView BirthDate_view = (TextView) findViewById(R.id.BirthDate_view);
        BirthDate_view.setText(R.string.BirthDate);
        TextView Product_view = (TextView) findViewById(R.id.Product_view);
        Product_view.setText(R.string.Product);
        TextView Agreement_view = (TextView) findViewById(R.id.Agreement_view);
        Agreement_view.setText(R.string.Agreement);
        TextView Languages_view = (TextView) findViewById(R.id.Lang_view);
        Languages_view.setText(R.string.Language);

        products = getResources().getStringArray(R.array.products);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, products);
        ((Spinner)findViewById(R.id.spinner_products)).setAdapter(adapter);

        Button button_rus = findViewById(R.id.button_rus);
        button_rus.setText(R.string.Button_rus);
        Button button_cs = findViewById(R.id.button_cs);
        button_cs.setText(R.string.Button_cs);
        Button button_validate = findViewById(R.id.button_validate);
        button_validate.setText(R.string.Button_validate);
    }

    public void onClick_rus(View v)
    {
        Locale locale = new Locale("rus");
        changeLocale(locale);
        setTitle(R.string.app_name);
    }

    public void onClick_cs(View v)
    {
        Locale locale = new Locale("cs");
        changeLocale(locale);
        setTitle(R.string.app_name);
    }

    public void validate(View v)
    {
        Integer error_count = 0;
        for (int item_count = 0; item_count < edits_regex.size(); item_count++)
        {
            error_count += validate_edit(edits_regex.keyAt(item_count), edits_regex.valueAt(item_count));
        }
        if (error_count > 0)
        {
            String error = getResources().getString(R.string.error_validation);
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }

        EditText password_edit = findViewById(R.id.Password_edit);
        EditText Reppassword_edit = findViewById(R.id.RepPassword_edit);
        if (!password_edit.getText().toString().equals(Reppassword_edit.getText().toString()))
        {
            error_count += 1;
            Log.println(Log.ERROR, "Password error", "Password error");
            String error_password = getResources().getString(R.string.error_password);
            Toast.makeText(this, error_password, Toast.LENGTH_SHORT).show();
        }

        CheckBox check = (CheckBox)findViewById(R.id.checkbox_1);
        if(!check.isChecked())
        {
            check.setBackgroundResource(R.drawable.red_cell);
            Log.println(Log.ERROR, "Agreement error", "Agreement error");
        }
        else
        {
            check.setBackgroundResource(R.drawable.nothing);
        }

//        EditText birth_date = (EditText)findViewById(R.id.BirthDate_edit);
//        int Year = Integer.parseInt(birth_date.getText().toString().substring(1,3));
//        if (Year < 1900)
//        {
//            birth_date.setBackgroundResource(R.drawable.red_cell);
//            Log.println(Log.ERROR, "Validation error", "Validation error");
//        }

    }

    public int validate_edit(EditText edit, Regex regex)
    {
        String edit_text;
        edit_text = edit.getText().toString();
        if (!edit_text.matches(String.valueOf(regex))) {
            Log.println(Log.ERROR, "Validation error", "Validation error");
            edit.setBackgroundResource(R.drawable.red_cell);
            edit.setText("");
            return 1;
        } else
        {
            edit.setBackgroundResource(R.drawable.cell);
            return 0;
        }
    }

    public void showDP(View v)
    {
        DatePicker dp = findViewById(R.id.dp);
        dp.setVisibility(View.VISIBLE);
    }

    public void hideDP(View v)
    {
        DatePicker dp = findViewById(R.id.dp);
        dp.setVisibility(View.GONE);

        EditText date_edit = findViewById(R.id.BirthDate_edit);
        date_edit.setText(dp.getYear() + "-" + dp.getMonth() + "-" + dp.getDayOfMonth());
    }
}