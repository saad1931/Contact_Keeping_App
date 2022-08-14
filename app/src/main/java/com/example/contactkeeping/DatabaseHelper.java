package com.example.contactkeeping;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "testdb";
    public static final int DB_VERSION = 1;
    public static final String QUERY_CREATE_STUDENT_TABLE =
            "create table Student(name text, num text)";
    private String Student="Student";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QUERY_CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Student");
        onCreate(sqLiteDatabase);
    }
    long insertData(String name, String num) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name", name);
        content.put("num", num);
        long id = db.insert("Student", null, content);
        db.close();
        return id;
    }
//    Cursor getAllData() {
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery("select * from Student order by rowid desc", null);
//        return cursor;
//    }


    public ArrayList<Contact> readContacts() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorContacts = db.rawQuery("SELECT * FROM " + Student, null);

        // on below line we are creating a new array list.
        ArrayList<Contact> contactArrayList = new ArrayList<>();


        // moving our cursor to first position.
        if (cursorContacts.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                contactArrayList.add(new Contact(cursorContacts.getString(1),
                        cursorContacts.getString(2)));
            } while (cursorContacts.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorContacts.close();
        return contactArrayList;
    }
}
