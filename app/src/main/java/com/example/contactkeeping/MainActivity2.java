package com.example.contactkeeping;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText EdttxtName, EdttxtNum;
    Button BtnSaveData, BtnShowData;
    DatabaseHelper DbHelper;
    String Name;
    String Num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        Stetho.initializeWithDefaults(this);
        DbHelper = new DatabaseHelper(this);
        EdttxtName = findViewById(R.id.edttxt_name);
        EdttxtNum = findViewById(R.id.edttxt_num);
        BtnSaveData = findViewById(R.id.btn_savedata);

        BtnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name = EdttxtName.getText().toString().trim();
                Num = EdttxtNum.getText().toString().trim();
                long id = DbHelper.insertData(Name, Num);
                Log.i("LOG", "id = " + id);
                if (id == -1) {
                    Toast.makeText(MainActivity2.this, "Data not inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity2.this, "Record inserted successfully",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        BtnShowData = findViewById(R.id.btn_showalldata);
        BtnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
//    public void showAllData() {
//        StringBuilder MessageString = new StringBuilder();
//        Cursor cursor = DbHelper.getAllData();
//        while (cursor.moveToNext()) {
//            MessageString.append(cursor.getString(0));
//            MessageString.append(" ");
//            MessageString.append(cursor.getString(1));
//            MessageString.append("\n");
//        }
//        cursor.close();
//        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity2.this);
//        dialog.setTitle("Database Data");
//        dialog.setMessage(MessageString);
//        dialog.show();
    }
