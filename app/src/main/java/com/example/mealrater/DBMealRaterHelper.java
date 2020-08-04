package com.example.mealrater;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBMealRaterHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDatabase";
    public static final String CONTACTS_TABLE_NAME = "RatingTable";
    public DBMealRaterHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table "+ CONTACTS_TABLE_NAME +"(id integer primary key, resturent_name text, dish_name text, rating text)"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+CONTACTS_TABLE_NAME);
        onCreate(db);
    }
    public boolean insert(MealRaterDataSource mealRaterDataSource) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("resturent_name", mealRaterDataSource.rname);
        contentValues.put("dish_name", mealRaterDataSource.dname);
        contentValues.put("rating", mealRaterDataSource.rating);


        db.insert(CONTACTS_TABLE_NAME, null, contentValues);
        return true;
    }



    public ArrayList<MealRaterDataSource> read() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + CONTACTS_TABLE_NAME, null);
        ArrayList<MealRaterDataSource> courseModalArrayList = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            do {
                courseModalArrayList.add(new MealRaterDataSource(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return courseModalArrayList;
    }

    public void delete() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(CONTACTS_TABLE_NAME, null, null);
        db.close();
    }
}