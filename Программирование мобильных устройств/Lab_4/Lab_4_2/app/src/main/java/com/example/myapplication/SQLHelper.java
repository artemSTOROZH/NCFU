package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

    public SQLHelper(Context context) {
        super(context, "helper_2", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + "table_JKH_1(_id integer primary key autoincrement unique, personal_account integer, FIO text, street_name text, house_number integer, apartment_number integer, service_type text, sum real, pay_before text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS table_JKH_1");
        onCreate(db);
    }

    public Cursor getFullTable(){
        SQLiteDatabase new_db = this.getWritableDatabase();
        return new_db.query("table_JKH_1", new String[] {"_id", "personal_account", "FIO", "street_name",
                "house_number", "apartment_number", "service_type", "sum", "pay_before"}, null, null, null, null, null);
    }
}
