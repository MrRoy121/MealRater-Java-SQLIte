package com.example.mealrater;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ArrayList<MealRaterDataSource> arrayList;
    private DBMealRaterHelper dbHandler;
    private Adapter adapter;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        arrayList = new ArrayList<>();
        dbHandler = new DBMealRaterHelper(MainActivity2.this);
        arrayList = dbHandler.read();

        adapter = new Adapter(arrayList, MainActivity2.this);
        rv = findViewById(R.id.idRVCourses);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity2.this, RecyclerView.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);

        findViewById(R.id.clr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler.delete();
                Toast.makeText(MainActivity2.this, "Deleted!!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.end).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}