package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText dname, rname;
    Button rate, save;
    TextView rating;
    Float v1;
    MealRaterDataSource meal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dname = findViewById(R.id.dname);
        rname = findViewById(R.id.rname);
        rate = findViewById(R.id.rate);
        rating = findViewById(R.id.rating);
        save = findViewById(R.id.save);

        final DBMealRaterHelper DBMealRaterHelper = new DBMealRaterHelper(this);

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dname.getText().length()==0||rname.getText().length()==0){
                    Toast.makeText(MainActivity.this, "Please Fill UP both Dish Name and Restaurant Name!!", Toast.LENGTH_SHORT).show();
                }else{
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.custom);

                    RatingBar rt1 = (RatingBar) dialog.findViewById(R.id.ratingBar1);
                    LayerDrawable stars1=(LayerDrawable)rt1.getProgressDrawable();
                    stars1.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
                    Button set = (Button) dialog.findViewById(R.id.set);
                    set.setBackgroundColor(Color.YELLOW);
                    set.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            v1 = rt1.getRating();
                            rating.setText("Rating :  "+ String.valueOf(v1));
                            dialog.dismiss();
                            save.setVisibility(View.VISIBLE);
                        }
                    });
                    dialog.show();
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meal = new MealRaterDataSource(rname.getText().toString(), dname.getText().toString(), String.valueOf(v1));
                if (DBMealRaterHelper.insert(meal)) {
                    Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "NOT Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
            }
        });
    }
}