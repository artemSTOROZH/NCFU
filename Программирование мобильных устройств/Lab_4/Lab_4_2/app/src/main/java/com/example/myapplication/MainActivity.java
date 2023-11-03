package com.example.myapplication;

import androidx.annotation.IntRange;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

public class MainActivity extends AppCompatActivity {
    SQLHelper helper_2;
    dbRow selected_row;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper_2 = new SQLHelper(this);
        setContentView(R.layout.activity_main);
        showFullTable();
    }


    public ArrayList<dbRow> getList() {
        ArrayList<dbRow> dbRows = new ArrayList<>();
        Cursor cursor = helper_2.getFullTable();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                dbRows.add(new dbRow(cursor.getInt(0), cursor.getInt(1), cursor.getString(2),
                        cursor.getString(3), cursor.getInt(4), cursor.getInt(5),
                        cursor.getString(6), cursor.getDouble(7), cursor.getString(8)));
            }

        }
        return dbRows;
    }

    public void showFullTable() {
        LinearLayout row;
        HorizontalScrollView scrollview;
        LinearLayout table_rows = (LinearLayout) findViewById(R.id.table_rows);
        ArrayList<dbRow> dbRows = getList();
        LinearLayout table = findViewById(R.id.table_rows);
        table.removeAllViews();
        for (dbRow new_row : dbRows) {
            row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);

            TextView id = new TextView(this);
            id.setText(Integer.toString(new_row.id));
            id.setTextSize(12);
            id.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            id.setWidth(72);
            id.setHeight(40);
            id.setBackground(getResources().getDrawable(R.drawable.cell));

            TextView personal_account = new TextView(this);
            personal_account.setText(Integer.toString(new_row.PersonalAccount));
            personal_account.setTextSize(12);
            personal_account.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            personal_account.setWidth(200);
            personal_account.setHeight(40);
            personal_account.setBackground(getResources().getDrawable(R.drawable.cell));

            TextView fio = new TextView(this);
            fio.setText(new_row.FIO);
            fio.setTextSize(12);
            fio.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            fio.setWidth(400);
            fio.setHeight(40);
            fio.setBackground(getResources().getDrawable(R.drawable.cell));

            TextView street = new TextView(this);
            street.setText(new_row.Street);
            street.setTextSize(12);
            street.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            street.setWidth(260);
            street.setHeight(40);
            street.setBackground(getResources().getDrawable(R.drawable.cell));

            TextView house_number = new TextView(this);
            house_number.setText(Integer.toString(new_row.HouseNumber));
            house_number.setTextSize(12);
            house_number.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            house_number.setWidth(144);
            house_number.setHeight(40);
            house_number.setBackground(getResources().getDrawable(R.drawable.cell));

            TextView apartment_number = new TextView(this);
            apartment_number.setText(Integer.toString(new_row.ApartmentNumber));
            apartment_number.setTextSize(12);
            apartment_number.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            apartment_number.setWidth(170);
            apartment_number.setHeight(40);
            apartment_number.setBackground(getResources().getDrawable(R.drawable.cell));

            TextView service_type = new TextView(this);
            service_type.setText(new_row.ServiceType);
            service_type.setTextSize(12);
            service_type.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            service_type.setWidth(240);
            service_type.setHeight(40);
            service_type.setBackground(getResources().getDrawable(R.drawable.cell));

            TextView sum = new TextView(this);
            sum.setText(Double.toString(new_row.Sum));
            sum.setTextSize(12);
            sum.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            sum.setWidth(160);
            sum.setHeight(40);
            sum.setBackground(getResources().getDrawable(R.drawable.cell));

            TextView pay_before = new TextView(this);
            pay_before.setText(new_row.PayBefore);
            pay_before.setTextSize(12);
            pay_before.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            pay_before.setWidth(240);
            pay_before.setHeight(40);
            pay_before.setBackground(getResources().getDrawable(R.drawable.cell));

            row.addView(id);
            row.addView(personal_account);
            row.addView(fio);
            row.addView(street);
            row.addView(house_number);
            row.addView(apartment_number);
            row.addView(service_type);
            row.addView(sum);
            row.addView(pay_before);

            row.setClickable(true);
            LinearLayout local_row = row;
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    EditText[] edits = new EditText[9];
                    EditText col_1 = findViewById(R.id.id_edit);
                    edits[0] = col_1;
                    EditText col_2 = findViewById(R.id.personal_account_edit);
                    edits[1] = col_2;
                    EditText col_3 = findViewById(R.id.fio_edit);
                    edits[2] = col_3;
                    EditText col_4 = findViewById(R.id.street_edit);
                    edits[3] = col_4;
                    EditText col_5 = findViewById(R.id.house_number_edit);
                    edits[4] = col_5;
                    EditText col_6 = findViewById(R.id.apartment_number_edit);
                    edits[5] = col_6;
                    EditText col_7 = findViewById(R.id.service_type_edit);
                    edits[6] = col_7;
                    EditText col_8 = findViewById(R.id.sum_edit);
                    edits[7] = col_8;
                    EditText col_9 = findViewById(R.id.pay_before_edit);
                    edits[8] = col_9;
                    for (int i = 0; i < 9; i++){
                        TextView child = (TextView)local_row.getChildAt(i);
                        edits[i].setText(child.getText());
                    }
                }
            });

            table_rows.addView(row);

        }
    }

    public void addRow(View view){
        try{
            dbRow row = getEditsData();
            SQLiteDatabase db = helper_2.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("_id", row.id);
            cv.put("personal_account", row.PersonalAccount);
            cv.put("FIO", row.FIO);
            cv.put("street_name", row.Street);
            cv.put("house_number", row.HouseNumber);
            cv.put("apartment_number", row.ApartmentNumber);
            cv.put("service_type", row.ServiceType);
            cv.put("sum", row.Sum);
            cv.put("pay_before", row.PayBefore);
            db.insert("table_JKH_1",null, cv);
            showFullTable();
            editsClear();
        }
        catch (Exception e) {
            Toast.makeText(this, "Incorrect input", Toast.LENGTH_SHORT).show();
        }
    }

    public dbRow getEditsData(){
        EditText edit_id = findViewById(R.id.id_edit);
        int id_value = Integer.parseInt(edit_id.getText().toString());
        EditText edit_personal_account = findViewById(R.id.personal_account_edit);
        int personal_account_value = Integer.parseInt(edit_personal_account.getText().toString());
        EditText edit_fio = findViewById(R.id.fio_edit);
        String FIO_value = edit_fio.getText().toString();
        EditText edit_street = findViewById(R.id.street_edit);
        String street_value = edit_street.getText().toString();
        EditText edit_house_number = findViewById(R.id.house_number_edit);
        int house_number_value = Integer.parseInt(edit_house_number.getText().toString());
        EditText edit_apartment_number = findViewById(R.id.apartment_number_edit);
        int apartment_number_value = Integer.parseInt(edit_apartment_number.getText().toString());
        EditText edit_service_type = findViewById(R.id.service_type_edit);
        String service_type_value = edit_service_type.getText().toString();
        EditText edit_sum = findViewById(R.id.sum_edit);
        Double sum_value = Double.parseDouble(edit_sum.getText().toString());
        EditText edit_pay_before = findViewById(R.id.pay_before_edit);
        String pay_before_value = edit_pay_before.getText().toString();
        dbRow row = new dbRow(id_value, personal_account_value, FIO_value, street_value, house_number_value, apartment_number_value, service_type_value, sum_value, pay_before_value);

        return row;
    }

    public ContentValues getContentValues(dbRow row){
        ContentValues cv = new ContentValues();
        cv.put("_id", row.id);
        cv.put("personal_account", row.PersonalAccount);
        cv.put("FIO", row.FIO);
        cv.put("street_name", row.Street);
        cv.put("house_number", row.HouseNumber);
        cv.put("apartment_number", row.ApartmentNumber);
        cv.put("service_type", row.ServiceType);
        cv.put("sum", row.Sum);
        cv.put("pay_before", row.PayBefore);
        return cv;
    }

    public void updateRow(View v){
        dbRow row = getEditsData();
        SQLiteDatabase db = helper_2.getWritableDatabase();
        ContentValues cv = getContentValues(row);
        db.update("table_JKH_1", cv, "_id = ?", new String[]{Integer.toString(row.id)});
        showFullTable();
        editsClear();
    }

    public void deleteRow(View v){
        dbRow row = getEditsData();
        SQLiteDatabase db = helper_2.getWritableDatabase();
        ContentValues cv = getContentValues(row);
        db.delete("table_JKH_2","_id = ?", new String[]{Integer.toString(row.id)});
        showFullTable();
        editsClear();

    }

    public void editsClear(){
        LinearLayout edits = findViewById(R.id.edits);
        int child_count = edits.getChildCount();
        for (int child_index = 0; child_index < child_count; child_index++){
           EditText edittext = (EditText) edits.getChildAt(child_index);
           edittext.setText("");
        }
    }
}