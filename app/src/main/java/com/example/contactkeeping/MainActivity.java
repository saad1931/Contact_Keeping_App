package com.example.contactkeeping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView newsRecyclerView;
    private ContactAdapter adapter;
    private ArrayList<Contact> dataList ;
    Button button;
    private DatabaseHelper dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = new ArrayList<>();
        dbHandler = new DatabaseHelper(MainActivity.this);

        // getting our course array
        // list from db handler class.
        dataList = dbHandler.readContacts();

        // on below line passing our array lost to our adapter class.

        adapter = new ContactAdapter(MainActivity.this, dataList);
        //adapter  = new ContactAdapter(dataList, MainActivity.this);
        //coursesRV = findViewById(R.id.idRVCourses);
        newsRecyclerView = findViewById(R.id.news_recycler_view);

        // setting layout manager for our recycler view.
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
//        newsRecyclerView.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        newsRecyclerView.setAdapter(adapter);
//        newsRecyclerView = findViewById(R.id.news_recycler_view);
        addListenerOnButton();
//        dataList = new ArrayList<Contact>();
//        dataList.add(new Contact( "Saad", "0348-1133837"));
//        dataList.add(new Contact( "Asad", "0348-1133837"));
//        dataList.add(new Contact( "Ali", "0348-1133837"));
//
        adapter = new ContactAdapter(this, dataList);
        LinearLayoutManager manager = new
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        newsRecyclerView.setLayoutManager(manager);
        newsRecyclerView.setAdapter(adapter);
//    }
    }
    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity2.class);
                startActivity(intent);

            }

        });

    }

}
